package 爱奇艺;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 
 */
public class second {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
	    int X = input.nextInt();
	    int Y = input.nextInt();
	    int Z = input.nextInt();
	    int[] num = {X, Y, Z};
	    Arrays.sort(num);
	    if((num[1] - num[0])%2 == 0)
	    	System.out.println((num[1] - num[0])/2 + num[2] - num[1]);
	    else
	    	System.out.println((num[1] - num[0])/2 + num[2] - num[1] + 2);
	}

}
