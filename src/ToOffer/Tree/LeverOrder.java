package ToOffer.Tree;

import java.util.ArrayDeque;

public class LeverOrder {
    public void levelOrderTraversal(ListNode node){
        if(node==null){
            System.out.print("empty tree");
            return;
        }
        ArrayDeque<ListNode> deque = new ArrayDeque<ListNode>();
        deque.add(node);
        while(!deque.isEmpty()){
            ListNode rnode = deque.remove();
            System.out.print(rnode.val+"  ");
            if(rnode.left!=null){
                deque.add(rnode.left);
            }
            if(rnode.right!=null){
                deque.add(rnode.right);
            }
        }
    }
}
