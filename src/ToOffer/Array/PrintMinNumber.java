package ToOffer.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3,32,321}，则
 * 打印出这3个数字能排成的最小数字321323。
 */
public class PrintMinNumber {
	public static void main(String[] args){
		int[] numbers = {3,32,321};
		System.out.println(minNumber(numbers));
	}
	public static String minNumber(int [] numbers) {
		if(numbers == null || numbers.length<=0)
		    return "";
		int length = numbers.length;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<length;i++){
			list.add(numbers[i]);
		}
		//实现了Comparator接口的compare方法，将集合元素按照compare方法的规则进行排序
		Collections.sort(list, new Comparator<Integer>(){
		public int compare(Integer i, Integer j) {
			String s1 = i+""+j;
			String s2 = j+""+i;
			return s1.compareTo(s2);
		}
		});
		StringBuilder s = new StringBuilder();
		for(Integer l:list){
			s.append(l);
		}
		return s.toString();
	}
}
