package 京东;
import java.util.Scanner;

/*
 * 输入2^63，所以应该使用long型
 * X*Y = N,X为奇数，Y为偶数，如果能找到这样的
 * X，Y，则依次输出X,Y，如果有多解，输出Y最小的
 * 那组解。以空格分割，否则输出"No"。
 * 输入：
 * 2
 * 10
 * 5
 * 输出：
 * 5 2
 * No
 */
public class Second {
	public static void main(String[] args){
	    Scanner in = new Scanner(System.in);
	    int num = in.nextInt();
	    int count = num;
	    long[] array = new long[num];
	    int i = 0;
	    while(count>0){
	    	array[i] = in.nextInt();
	    	i++;
	    	count--;
	    }
	    for(int j=0;j<num;j++){
	    	long N = array[j];
	    	if(N==0){
	    		System.out.println("No");
	    	}
	    	else if(N%2==1){
	    		System.out.println("No");
	    	}else{
	    		long x = N/2;
	    		long y = 2;
	    		while(x%2==0){
	    			x = N/2;
		    		y = y*2;
	    		}
	    		System.out.println(x+" "+y);
	    	}
	    }
   }
}
