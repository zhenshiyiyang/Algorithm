package ToOffer.Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class kMin {
	public static void main(String[] args){
		int[] array = {3,5,2,7,0,9,1,4};
		int k = 4;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = GetLeastNumbers(array,k);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
	} 
	public static ArrayList<Integer> GetLeastNumbers(int [] input, int k) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(input==null || k<=0 || input.length<=0 || k>input.length){
		    return list;
		}
		TreeSet<Integer> set=new TreeSet<Integer>();
		for(int i=0;i<input.length;i++){
			if(set.size()<k){
			    set.add(input[i]);
			}
			else{
				if(set.last()>input[i]){
					set.pollLast();
					set.add(input[i]);
				}
			}
		}
		Iterator<Integer> it=set.iterator();
		while(it.hasNext()){
			list.add(it.next());
	    }
	    return list;
	}
}
