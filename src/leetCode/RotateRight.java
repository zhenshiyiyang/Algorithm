package leetCode;
/*
  输入: 1->2->3->4->5->NULL, k = 2
  输出: 4->5->1->2->3->NULL
  解释:
  向右旋转 1 步: 5->1->2->3->4->NULL
  向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class RotateRight {
    public static void main(String[] args) {

    }
    public static ListNode rotateRight(ListNode head, int k) {
         if(head==null){
             return null;
         }
         int n = 1;
         ListNode cur = head;
         while(cur.next!=null){
             ++n;
             cur = cur.next;
         }
         cur.next = head;
         int m = n-k%n;
         for (int i = 0; i < m ; i++) {
            cur = cur.next;
         }
         ListNode newhead = cur.next;
         cur.next = null;
         return newhead;
    }
}
