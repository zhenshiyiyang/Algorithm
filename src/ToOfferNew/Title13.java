package ToOfferNew;
//在O(1)时间删除链表结点
public class Title13 {
    public class ListNode{
        int value = 0;
        ListNode next = null;
        public ListNode(int value){
            this.value = value;
        }
    }
    public static ListNode DeleteNode(ListNode head,ListNode cur){
        if(head==null || cur==null){
            return null;
        }
        if(cur.next != null){
            cur.value = cur.next.value;
            cur.next = cur.next.next;
            return head;
        }
        else if(head == cur){//链表中只有一个结点，删除头结点（也是尾结点）
            cur = null;
            head = null;
            return null;
        }
        else{//链表中有多个结点，删除尾结点
            ListNode node = head;
            while (node.next!=cur){
                node = node.next;
            }
            node.next = null;
            return head;
        }
    }
}
