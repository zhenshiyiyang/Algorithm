package leetCode;
/*
   给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode t = head.next;
        head.next = swapPairs(head.next.next);
        t.next = head;
        return t;
    }
}
