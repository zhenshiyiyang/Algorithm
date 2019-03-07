package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static class TreeNode {
       public int val;
       public TreeNode left = null;
       public TreeNode right = null;
       public TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = null;
        inorderTraversal(root);
        inorder(root);
        preorder(root);
        postorder(root);
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if(root==null){
            return resultList;
        }
        helper(resultList,root);
        return resultList;
    }
    public static void helper(List<Integer> resultList,TreeNode root){
        if(root==null){
            return;
        }
        helper(resultList,root.left);
        resultList.add(root.val);
        helper(resultList,root.right);
    }
    public static List<Integer> inorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack =  new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
    public static List<Integer> preorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
    }
    /*
      主要思想：首先遍历root根节点的所有左节点，并依次入栈。对出栈的元素，如果没有右儿子或者虽然有右儿
      子但右儿子已完成遍历，即可完成出栈；否则，再次入栈，并把右儿子入栈，遍历右儿子的所有左儿子。
     */
    public static List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode flag = null;
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.right == null || cur.right == flag) {
                res.add(cur.val);
                flag = cur;
            } else {
                stack.push(cur);
                cur = cur.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return res;
    }
}
