package ToOfferNew;

import java.util.Stack;

public class Title25 {
    public class Node{
        int value = 0;
        Node left = null;
        Node right = null;
        public Node(int value){
            this.value = value;
        }
    }
    //二叉树中和为某一值的路径。
    public static void FindPath(Node root,int Sum){
        if(root==null){
            return;
        }
        int currentSum = 0;
        Stack<Integer> path = new Stack<>();
        FindPath(root,Sum,path,currentSum);
    }
    public static void FindPath(Node root,int Sum,Stack<Integer> path,int currentSum){
        currentSum += root.value;
        path.push(root.value);
        //如果是叶结点，并且路径上结点的和等于输入的值
        //打印出这条路径
        boolean isLeaf = root.left==null&&root.right==null;
        if(currentSum==Sum&&isLeaf){
            for (int i = 0; i < path.size(); i++) {
                System.out.println(path.get(i));
            }
        }
        //如果不是叶结点，则遍历它的子结点。
        if(root.left!=null){
            FindPath(root.left,Sum,path,currentSum);
        }
        if(root.right!=null){
            FindPath(root.right,Sum,path,currentSum);
        }
        //在返回到父节点之前，在路径上删除当前结点。
        currentSum -= path.peek();
        path.pop();
    }
}
