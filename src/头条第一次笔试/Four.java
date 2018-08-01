package 头条第一次笔试;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Four {
	public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      Set<Integer> a = new HashSet<Integer>();
      Set<Integer> b = new HashSet<Integer>();
      System.out.println("第一行输入");
      int sizeA = sc.nextInt();
      int sizeB = sc.nextInt();
      Scanner scanA = new Scanner(System.in);
      System.out.println("第二行输入");
      int avgA = 0;
      int avgB = 0;
      for(int i=0;i<sizeA;i++){
    	  int midA = scanA.nextInt();
    	  avgA += midA;
    	  a.add(midA);
      }
      Scanner scanB = new Scanner(System.in);
      System.out.println("第三行输入");
      for(int j=0;j<sizeB;j++){
    	  int midB = scanB.nextInt();
    	  avgB += midB;
    	  b.add(midB);
      }
      //a取值，存入b；
      int count_ab = 0;
      int count_ba = 0;
      for(int magic_a : a){
    		  if(magic_a<=Math.floor(avgA/sizeA) && magic_a > Math.ceil(avgB/sizeB)){
    			  count_ab++;
    		  }
      }
      for(int magic_b : b){
		  if(magic_b <= Math.floor(avgB/sizeB) && magic_b > Math.ceil(avgA/sizeA)){
			  count_ba++;
		  }
      }
      int total = count_ab + count_ba;
      System.out.println(total+"   "+count_ab+"  "+count_ba);
	}     
}
