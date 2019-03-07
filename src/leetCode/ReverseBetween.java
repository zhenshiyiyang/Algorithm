package leetCode;
/*
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
说明:
1 ≤ m ≤ n ≤ 链表长度。
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
            return head;
        ListNode normal = head, last = null, pre, cur, gra = new ListNode(0);
        gra.next = head;
        pre = gra;
        cur = head;
        while (cur != null) {
            if (m == 1) {
                normal = cur;
                // 链表反转,头拼接
                last = reverseList(cur, pre, n);
                // 尾拼接
                normal.next = last;
                break;
            }
            cur = cur.next;
            pre = pre.next;
            m--;
            n--;
        }
        return gra.next;
    }
    // 反转链表工具方法,反转当前节点与之后n个节点的子链表,头拼接
    public ListNode reverseList(ListNode head, ListNode first, int n) {
        ListNode pre = null;
        ListNode next = head;
        while (n > 0) {
            ListNode tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
            n--;
        }
        first.next = pre;
        return next;
    }
}
