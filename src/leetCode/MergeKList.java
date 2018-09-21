package leetCode;

public class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        int n = lists.length;
        while(n>1){
           int k = (n+1)/2;
           for(int i=0;i<n/2;i++){
               lists[i] = merge(lists[i],lists[i+k]);
           }
           n = k;
        }
        return lists[0];
    }
    public static ListNode merge(ListNode l1,ListNode l2){
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(l1!=null && l2!=null){
           if(l1.val<=l2.val){
               cur.next = l1;
               l1 = l1.next;
           }else{
               cur.next = l2;
               l2 = l2.next;
           }
           cur = cur.next;
        }
        while(l1!=null){
           cur.next = l1;
           l1 = l1.next;
           cur = cur.next;
        }
        while(l2!=null){
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return head.next;
    }
}
