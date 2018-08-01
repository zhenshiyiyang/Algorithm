package 小米;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//此题利用二叉树层序遍历解答，首先构造二叉树节点类，返回二叉树根节点，将根节点传给
//层序遍历方法，最后返回list，list中存储每层最大值。
public class BinTree {
	//节点类
	public static class TreeNode {
	    public int val=0;
	    public TreeNode left = null;
	    public TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	    public int getValue() {
	        return val;
	    }
    }
	
	public static void main(String[] args){
		int[] array = {1, 2, 3, 4, 7, 5};
		TreeNode root = createBinTree(array,0);
	    levelOrder(root);  
	}
	
	//利用递归构造二叉树
	public static TreeNode createBinTree(int[] array,int index)  
    { 
		TreeNode node = null;
		if(array == null || array.length == 0){
			return node;
		}
		if (index<array.length) {  
                int value = array[index];  
                node = new TreeNode(value);  
                node.left = createBinTree(array, 2*index+1);  
                node.right = createBinTree(array, 2*index+2);  
                return node;  
        }         
		return node;  
    }  
	
	
	//二叉树层序遍历,利用队列实现二叉树层序遍历
	public static List<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        if (root != null) {
            queue.offer(root);
            // 层次遍历，记录本层结点个数  
            int curNum = 1;  
            // 下一层的节点数  
            int nextNum = 0;  
            //记录每层最大节点值
            int max = Integer.MIN_VALUE;  
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                curNum--;  
                max = Math.max(max, node.val); 
                if (node.left != null){
                    queue.offer(node.left);
                    nextNum++;
                }
                if (node.right != null){
                    queue.offer(node.right);
                    nextNum++;
                }
                if (curNum == 0) {  
                    list.add(max);  
                    System.out.print(max + "  ");
                    curNum = nextNum;  
                    nextNum = 0;  
                    max = Integer.MIN_VALUE;
                }  
            }
        }
        return list;
    }
	
	
	public void theFirstTraversal(TreeNode root) {  //先序遍历  
        printNode(root);  
        if (root.left != null) {  //使用递归进行遍历左孩子  
            theFirstTraversal(root.left);  
        }  
        if (root.right != null) {  //递归遍历右孩子  
            theFirstTraversal(root.right);  
        }  
    }  
    public void theInOrderTraversal(TreeNode root) {  //中序遍历  
        if (root.left != null) {  
            theInOrderTraversal(root.left);  
        }  
        printNode(root);  
        if (root.right != null) {  
            theInOrderTraversal(root.right);  
        }  
    } 
    public void thePostOrderTraversal(TreeNode root) {  //后序遍历  
        if (root.left != null) {  
            thePostOrderTraversal(root.left);  
        }  
        if(root.right != null) {  
            thePostOrderTraversal(root.right);  
        }  
        printNode(root);  
    }  
    public void printNode(TreeNode node){  
        System.out.print(node.getValue());  
    }  
	
}
