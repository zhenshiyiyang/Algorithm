package ToOffer.Tree;
/*
 * 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输
 * 入整数的所有路径，从树的根结点开始往下一直到叶结点所经过的结点
 * 形成一条路径。
 */
import java.util.ArrayList;
import java.util.Stack;

public class findPath {
	public class TreeNode{
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int val){
			this.val = val;
		}
	}
	public static void main(String[] args){
		
	}
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			 return list;
		int currentSum = 0;
		Stack<Integer> data = new Stack<Integer>();
		findPath2(root,currentSum,target,data,list);
		return list;
	}
	private void findPath2(TreeNode root,int currentSum,int target,Stack<Integer> data,ArrayList<ArrayList<Integer>>list){
		if(root == null)
		    return;
		currentSum = currentSum+root.val;
		data.push(root.val);
		boolean isLeaf = (root.left==null && root.right==null);
		if(currentSum == target && isLeaf){
		    ArrayList<Integer> tempList = new ArrayList<Integer>();
		    //用下面的方法对栈进行遍历
			for(Integer i:data){
			     tempList.add(i); 
			}
			list.add(tempList);
		}
		if(root.left != null){
		    findPath2(root.left,currentSum,target,data,list);
		}
		if(root.right != null){
		    findPath2(root.right,currentSum,target,data,list);
		}
		currentSum = currentSum-root.val;
		data.pop();
	}
}

