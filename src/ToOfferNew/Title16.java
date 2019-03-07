package ToOfferNew;
//反转链表
public class Title16 {
    public class ListNode{
        int value = 0;
        ListNode next = null;
        public ListNode(int value){
            this.value = value;
        }
    }
    //非递归
    public static ListNode reverseListNode(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode behind = head;
        ListNode reverseHead = null;
        while(cur!=null){
            behind = cur.next;
            if(behind==null){
                reverseHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = behind;
        }
        head = reverseHead;
        return head;
    }
    //递归
    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null){
             return head;
        }else {
            ListNode phead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return phead;
        }
    }

}
