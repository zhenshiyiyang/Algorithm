package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 求电话号码的字母组合，即数字2到9中每
 * 个数字可以代表若干个字母，然后给一串
 * 数字，求出所有可能的组合
 */
public class letterCombinations {
    public static void main(String[] args){
    	Queue<String> queue = letter("234");
    	for(String q:queue){
    		System.out.println(q);
    	}
    }
    public static Queue<String> letter(String str){
    	Queue<String> queue = new LinkedList<String>();
    	if(str==null)return queue;
    	char[] array = str.toCharArray();
    	String[] dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        queue.add("");
        for(int i=0;i<array.length;i++){
        	int n = queue.size();
        	char[] s = dict[array[i]-'2'].toCharArray();
        	for(int j=0;j<n;j++){
        		String tmp = queue.poll();
        		for(int k=0;k<s.length;k++){
        			queue.add(tmp+s[k]);
        		}
        	}
        }
    	return queue;		
    }
}
