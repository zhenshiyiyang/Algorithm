package ToOffer.Tree;

import java.util.Stack;

public class DepthOrder {
    public void depthTraversal(ListNode node){
        if(node==null){
            System.out.print("empty tree");
            return;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        stack.push(node);
        while(!stack.isEmpty()){
            ListNode rnode = stack.pop();
            System.out.print(rnode.val);
            if(rnode.right!=null){
                stack.push(rnode.right);
            }
            if(rnode.left!=null){
                stack.push(rnode.left);
            }
        }
    }
}
