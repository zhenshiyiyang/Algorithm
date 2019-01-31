package 头条面试题;

import java.util.ArrayList;
import java.util.Collections;
/*
  单链表反转
 */
public class Reverse {
    class ListNode {//单链表
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        //健壮性判断
        if(head==null)
            return null;
        if(head.next==null)
            return head;

        ArrayList<Integer> li=new ArrayList<Integer>();
        li.add(head.val);
        while(head.next!=null){//用list存储链表的值
            head=head.next;
            li.add(head.val);
        }

        Collections.reverse(li);//Collections 反转list集合 没有返回值
        ListNode re=new ListNode(li.get(0));
        ListNode flag = null;
        flag=re;
        for(int x=1;x<li.size();x++){//重新新建链表 即反转后的链表
            ListNode rs=new ListNode(li.get(x));
            flag.next=rs;
            flag=rs;
        }
        return re;
    }
}
