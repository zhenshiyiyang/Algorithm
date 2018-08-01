package 头条第一次笔试;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.Math;
public class Main {
	public static void main(String[] args){
       @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
       System.out.println("输入第一行");
       int n = sc.nextInt();
       int k = sc.nextInt();
       int[] array = new int[n];
       System.out.println("输入第二行");
       @SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
       Map<Integer,Integer> map=new HashMap<Integer,Integer>();
       for(int i=0;i<n;i++){
           array[i] = scan.nextInt();
       }
       for(int i=0;i<n;i++){
           for(int j=i+1;j<n;j++){
               if(Math.abs(array[i]-array[j])==k){
                   map.put(array[i],array[j]);
               }
           }
       }
       System.out.println(map.size());
   }   
}
