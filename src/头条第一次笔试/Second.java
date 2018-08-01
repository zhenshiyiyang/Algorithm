package 头条第一次笔试;

import java.util.Scanner;

public class Second {
     public static void main(String[] args){
    	 Scanner sc = new Scanner(System.in);
    	 int n = sc.nextInt();
    	 double num = 0;
    	 if(n%2==1){
    		 System.out.println(n-1);
    	 }else{
    		 num = Math.sqrt(n);
    		 int i = (int) Math.ceil(num);
    		 System.out.println(i);
    	 }
     }
}
