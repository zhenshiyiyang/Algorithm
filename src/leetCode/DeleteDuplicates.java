package leetCode;

public class DeleteDuplicates {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode newhead = new ListNode(-1);
        ListNode tmp = newhead;

        while(head != null && head.next != null){
            if (head.val == head.next.val){ //遇到相同的元素，整段删除
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                head = head.next;
            }
            else{
                tmp.next = head;
                tmp = tmp.next;
                head = head.next;

            }
        }
        tmp.next = head;
        return newhead.next;
    }
}
