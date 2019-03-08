package ToOfferNew;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//从上往下打印二叉树, 即层序遍历
public class Title23 {
    public class Node{
        int value = 0;
        Node left = null;
        Node right = null;
        public Node(int value){
            this.value = value;
        }
    }
    public static void printTree(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }
    //层次遍历选出没一层最大的结点，存到arraylist中。
    public static ArrayList<Integer> selectMaxNode(Node root){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        int count = 1;
        int max = 0;
        int nextCount=0;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.value > max){
                max = root.value;
            }
            count--;
            if(cur.left!=null){
                queue.add(cur.left);
                nextCount++;
            }
            if(cur.right!=null){
                queue.add(cur.right);
                nextCount++;
            }
            if(count==0){
                count = nextCount;
                nextCount = 0;
                list.add(max);
                max = 0;
            }
        }
        return list;
    }
}
