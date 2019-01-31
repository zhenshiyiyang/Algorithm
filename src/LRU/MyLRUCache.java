package LRU;
import java.util.HashMap;
public class MyLRUCache {
    public static void main(String[] args) {
        MyLRUCache cache = new MyLRUCache(3);
        cache.put(1, 1);
        System.out.println(cache.toString());
        cache.put(2, 2);
        System.out.println(cache.toString());
        cache.put(3, 3);
        System.out.println(cache.toString());
        cache.put(4, 4);
        System.out.println(cache.toString());
        cache.get(2);
        System.out.println(cache.toString());
        cache.put(4, 5);
        System.out.println(cache.toString());
    }
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
        @Override
        public String toString() {
            if (next == null || next.key == -1) {
                return "(" + key + "," + value + ")";
            } else {
                return "(" + key + "," + value + ")<->";
            }
        }
    }
    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        if (!hs.containsKey(key)) {
            return -1;
        }
        // remove current
        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        // add to tail
        addToTail(current);

        return hs.get(key).value;
    }
    public void put(int key, int value) {
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }
        if (hs.size() == capacity) {
            // remove head
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node current = new Node(key, value);
        hs.put(key, current);
        addToTail(current);
    }
    private void addToTail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node node = head.next;
        while (node != null && node.key != -1) {
            builder.append(node.toString());
            node = node.next;
        }
        return builder.toString();
    }
}