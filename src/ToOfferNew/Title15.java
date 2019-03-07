package ToOfferNew;


public class Title15 {
    public class ListNode {
        int value = 0;
        ListNode next = null;

        public ListNode(int value) {
            this.value = value;
        }
    }
    public static ListNode findKthToTail(ListNode head,int k){
        if(head==null || k==0){
            return null;
        }
        ListNode cur = head;
        ListNode target = head;
        for (int i = 0; i < k-1; i++) {
            if(cur.next!=null) {
                cur = cur.next;
            }else{
                return null;
            }
        }
        while(cur.next!=null){
            cur = cur.next;
            target = target.next;
        }
        return target;
    }
    //求链表的中间结点
    public static ListNode findMidNode(ListNode head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode cur = head;
        ListNode behind = head.next;
        while(behind!=null && behind.next!=null){
            cur = cur.next;
            behind = behind.next.next;
            if(behind==null){
                return cur;
            }
        }
        return cur;
    }
    //判断一个链表是否形成了环形结构
    public static boolean hasLoop(ListNode head){
        if(head==null){
            return false;
        }
        ListNode cur = head;
        ListNode behind = head.next;
        while(behind!=null && behind.next!=null){
            cur = cur.next;
            behind = behind.next.next;
            if(behind==null){
                return false;
            }
            if(cur.value==behind.value){
                return true;
            }
        }
        return false;
    }
}
