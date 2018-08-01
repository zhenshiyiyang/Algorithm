package sort;

import java.util.Hashtable;

//关于链表的经典题型
public class LinkList {
	//Node节点的实现类
	class Node {
        Node next = null;// 节点的引用，指向下一个节点
        int data;// 节点的对象，即内容

        public Node(int data) {
            this.data = data;
        }
    }
	
	//获取链表节点的个数
    public static int getLinkListNodeLength(Node head){  
		if(head == null){  
	        return 0;  
	    }  
	    int length = 0;  
	    Node currentNode = head;  
	    //如果链表不为空，则长度加1并且当前结点指向下一个结点  
	    while(currentNode != null){  
	        length++;  
	        currentNode = currentNode.next;  
	    }  
	    return length;  
    }
    //删除index位置的node节点
    public static Boolean deleteNode(int index,Node head){
    	int length = getLinkListNodeLength(head);
        if(index<1||index>length){
            return false;//删除元素位置不合理
        }
        //删除链表中的第一个元素
        if(index==1){
            head=head.next;
            return true;
        }
        int i=1;
        Node preNode=head;
        Node curNode=preNode.next;
        while(curNode!=null){
            if(i==index){
                preNode.next=curNode.next;
                return true;
            }
            preNode=curNode;
            curNode=curNode.next;
            i++;
        }
        return true;
    }    
    
    //对链表进行排序，返回排序后的头节点,交换链表节点data值即可，排序利用直接选择排序。
    public static Node sort(Node head){
    	Node nextNode = null;
    	Node curNode = head;
        int temp = 0;
        while(curNode!=null){
        	nextNode = curNode.next;
            while(nextNode!=null){
            	if(curNode.data>nextNode.data){
            		temp = curNode.data;
            		curNode.data = nextNode.data;
            		nextNode.data = temp;
            	}
            	nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
    	return head;
    }
    
    //删除链表重复数据，方法一：加入辅助空间，hash表
    public static Node deleteOfFirst(Node head){
    	Hashtable<Integer,Integer> hash= new Hashtable<Integer,Integer>();
    	Node pre = null;
    	Node cur = head;
    	while(cur != null){
    		if(hash.containsKey(cur.data)){
    			pre.next = cur.next;
    		}else{
    			hash.put(cur.data, 1);
    			pre = cur;
    		}
    		cur = cur.next;
    	}
    	return head;
    }
    //删除链表重复数据，方法二:双重循环遍历
    public static Node deleteOfSecond(Node head){
    	Node cur = head;
    	while(cur != null){
    		Node q = cur;
    		while(q.next!=null){
    			if(cur.data == q.next.data){
    				q.next = q.next.next;
    			}else{
    			    q = q.next;
    			}
    		}
    		cur = cur.next;
    	}
    	return head;
    }
    
    //找到链表倒数第k个节点。思路：利用两个指针，之间相距k，后面的到达结尾，前面的就是。
    public static Node findKNode(Node head,int k){
    	int length = getLinkListNodeLength(head);
    	if(k<1 || k>length){
    		return null;
    	}
    	Node p = head;
    	Node q = head;
    	for(int i=0;i<k;i++){
    		q = q.next;
    	}
    	while(q.next!=null){
    		q = q.next;
    		p = p.next;
    	}
    	return p;
    }
    
    //实现链表的反转。经典变形题，三个指针，记录前一个节点，记录当前节点，记录后一个节点。
    public static void reverseIteratively(Node head){
        Node pReversedHead=head;
        Node pNode=head;
        Node pPrev=null;
        while (pNode!=null) {
            Node pNext=pNode.next;
            if(pNext==null)
                pReversedHead=pNode;
            pNode.next=pPrev;
            pPrev=pNode;
            pNode=pNext;        
        }
        head=pReversedHead; 
    }
    
    
    //判断单链表是否有环
    public static boolean hasLoop(Node head){  
        Node p1 = head;    //定义一个引用指向头结点  
        Node p2 = head.next;    //定义另一个引用指向头结点的下一个结点  
          
        /** 
         * 因为引用p2要比p1走的快，p2是p1的两倍，最后如果p2和p1相遇，则证明单链表有环
         * 所以要用它作为循环的结束标志，为了防止当链表中个数为 
         * 偶数时出现p2.next=null空指针异常，这时可以在循环中进行一下判断，如果这种情况 
         * 出现一定是无环的。 
         */  
        //为了防止p2.val出现空指针异常，需要对p2进行判断  
        while(p2 != null && p2.next != null){    
            p1 = p1.next;  
            p2 = p2.next.next;  
            if(p2 == null)  
                return false;  
            int val1 = p1.data;  
            int val2 = p2.data;  
            if(val1 == val2)  
                return true;  
        }  
        return false;  
    }  
}
