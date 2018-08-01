package ToOffer.LinkedList;
/*
 * 输入两个链表，找出它们的第一个公共节点。
 * 求出两个链表长度，相减，长链表先走，两个链表剩余长度一样之后，同时走，
 * 求出的第一个相同点就是结果。
 */
public class FindFirstCommonNode {
	public static class Node{
    	Node next = null;
    	int data;
    	public Node(int data){
    		this.data = data;
    	}
    }
	public static void main(String[] args){
		
	}
	public Node find(Node root1,Node root2){
		int length1 = GetListLength(root1);
		int length2 = GetListLength(root2);
		int nlength = length1-length2;
		Node longNode = root1;
		Node shortNode = root2;
		if(length2 > length1){
			longNode = root2;
			shortNode = root1;
		}
		for(int i=0;i<nlength;i++){
			longNode = longNode.next;
		}
		while((longNode!=null)&&(shortNode!=null)&&(longNode!=shortNode)){
			longNode = longNode.next;
			shortNode = shortNode.next;
		}
		Node firstNode = longNode;
		return firstNode;
	}
	public static int GetListLength(Node pHead){
		int length = 0;
		Node pNode = pHead;
		while(pNode != null){
			length++;
			pNode = pNode.next;
		}
		return length;
	}
}
