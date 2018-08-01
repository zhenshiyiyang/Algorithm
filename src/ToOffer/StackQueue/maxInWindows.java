package ToOffer.StackQueue;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
/*
 * 使用双向队列（Linklist），队列中只存放当前元素的下标，设新来的元素为k，
 * 如果前面的元素比k小，直接把前面的删除（因为不可能成为后面窗口的最大值），
 * 如果前面的元素比k大，判断是否还在窗口范围内，不在则移除
        ①先判断当前队列是否为空，如果不空而且当前元素比队列中尾端的元素大，将队列元素的尾端弹出；
        ②判断队列头元素（存的是下标）是否还在滑动窗口范围中，不在则把头元素移除；
 */
public class maxInWindows {
	public static void main(String[] args) {
		int[] num = {2,3,4,2,6,2,5,1};
		System.out.println("ArrayList大小为:"+windows(num,3).size());
	}
    public static ArrayList<Integer> windows(int [] num, int size) {
	    ArrayList<Integer> arr = new ArrayList<>();
	    if (num==null)
	        return arr;
	    if (num.length<size||size<=0)
	        return arr;
	    Deque<Integer> queue = new LinkedList<>();
	    for (int i=0;i<num.length;i++){
	        while (!queue.isEmpty()&&num[i]>=num[queue.getLast()])
	            queue.pollLast();
	        while (!queue.isEmpty()&&queue.getFirst()<i-(size-1))
	            queue.pollFirst();
	        queue.offerLast(i); 
	        if (i+1>=size){
	            arr.add(num[queue.getFirst()]);
	            System.out.println(num[queue.getFirst()]);
	        }
	    }
	    return arr;
    }
}
