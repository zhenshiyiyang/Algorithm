package ToOfferNew;

import java.util.Stack;

public class Title5 {
    public class ListNode{
        int value = 0;
        ListNode next = null;
        public ListNode(int value){
            this.value = value;
        }
    }
    /*利用栈来实现*/
    public static void printList(ListNode head){
        Stack<Integer> stack = new Stack<Integer>();
        ListNode cur = head;
        while(cur!=null){
            stack.push(cur.value);
            cur = cur.next;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    /*
     递归本质上就是栈结构
     */
    public static void printByDG(ListNode head){
        if(head!=null) {
            if(head.next!=null) {
                printByDG(head.next);
            }
            System.out.println(head.value);
        }
    }
}
