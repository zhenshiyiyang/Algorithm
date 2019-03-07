package leetCode;

public class DeleteDuplicates2 {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        if (cur == null ){
            return head;
        }
        while (cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next; //当前值与下一个值相等， 则删除
            }
            else{
                cur = cur.next;
            }
        }
        return head;
    }
}
