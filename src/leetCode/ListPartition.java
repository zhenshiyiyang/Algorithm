package leetCode;
/*
给定一个链表和一个特定值 x，对链表进行分隔，
使得所有小于 x 的节点都在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。
 */
public class ListPartition {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {

    }
    public static ListNode partition(ListNode head,int x){
        if(head==null||head.next==null){
            return head;
        }
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(1);
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while(head!=null){
             if(head.val>=x){
                 cur2.next = head;
                 head = head.next;
                 cur2 = cur2.next;
                 cur2.next = null;
             }else{
                 cur1.next = head;
                 head = head.next;
                 cur1 = cur1.next;
                 cur1.next = null;
             }
        }
        cur1.next = head2.next;
        return head1.next;
    }
}
