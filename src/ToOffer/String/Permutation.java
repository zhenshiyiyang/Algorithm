package ToOffer.String;

import java.util.ArrayList;
import java.util.List;

/*
 * 字符串排列组合：输入一个字符串，打印出该字符的所有排列，例如输入
 * abc，则打印出由字符a,b,c所能排列出来的所有字符串abc、acb、bac、
 * bca、cab和cba
 */
public class Permutation {
     public static void main(String[] args){
    	 String str = "abc";
    	 char[] array = str.toCharArray();
    	 List<String> list = new ArrayList<>();
    	 change(array,0,list);
		 for (int i = 0; i < list.size(); i++) {
			 System.out.println(list.get(i));
		 }
     }
     public static void change(char[] array,int i,List<String> list){
    	 if(i == array.length-1){
    	 	 list.add(String.valueOf(array));
    	 }
    	 else{
    		 for(int j = i;j<array.length;j++){
    			 char temp = array[j];
    			 array[j] = array[i];
    			 array[i] = temp;
    			 change(array,i+1,list);
    			 temp = array[j];
    			 array[j] = array[i];
    			 array[i] = temp;
    		 }
    	 }
     }
}
