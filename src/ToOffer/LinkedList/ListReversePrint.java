package ToOffer.LinkedList;

import java.util.Stack;

/*
 * 从尾到头打印链表，利用数据结构栈，后进先出
 */
public class ListReversePrint {
	    public static class Node{
	    	Node next = null;
	    	int data;
	    	public Node(int data){
	    		this.data = data;
	    	}
	    }
        public static void main(String[] args){
			Node head = new Node(0);
			Node pNode = head;
        	for(int i=0;i<20;i++){
        		Node node = new Node(i+1);
        		pNode.next = node;
        		pNode = node;
        	}
        	print(head);
        }
        public static void print(Node head){
        	Node node = head;
        	Stack<Integer> sk = new Stack<Integer>();
        	while(node.next!=null){
        		sk.add(node.data);
        		node = node.next;
        	}
        	while(!sk.isEmpty()){
        		int val = sk.pop();
        		System.out.println(val);
        	}
        }
}
