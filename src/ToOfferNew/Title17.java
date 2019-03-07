package ToOfferNew;
/*
 合并两个有序链表为新的有序链表
 */
public class Title17 {
    public class ListNode{
        int value = 0;
        ListNode next = null;
        public ListNode(int value){
            this.value = value;
        }
    }
    public static ListNode merge(ListNode head1,ListNode head2){
        if(head1==null){
            return head2;
        }
        else if(head2==null){
            return head1;
        }
        ListNode mergeHead = null;
        if(head1.value<head2.value){
            mergeHead = head1;
            mergeHead.next = merge(head1.next,head2);
        }else{
            mergeHead = head2;
            mergeHead.next = merge(head1,head2.next);
        }
        return mergeHead;
    }
}
