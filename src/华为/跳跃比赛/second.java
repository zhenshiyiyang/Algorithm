package 华为.跳跃比赛;
import java.util.Arrays;
import java.util.Scanner;
/*
 * 给出一组正整数，你从第一个数向最后一个数方向跳跃，每次至少跳跃1格，
 * 每个数的值表示你从这个位置可以跳跃的最大长度，计算如何以最少的跳跃
 * 次数跳到最后一个数。
 * 输入描述：
 * 第一行表示有多少个数n，
 * 第二行开始依次是1到n个数，一个数一行
 * 输出描述：
 * 输出一行，表示最少跳跃的次数。
 * 输入：
 * 7
 * 2
 * 3
 * 2
 * 1
 * 2
 * 1
 * 5
 * 输出：
 * 3
 * 说明：
 * 7表示接下来要输入7个正整数，从2开始，数字本身代表可以跳跃的最大步长，
 * 此时有2种跳法，为2-2-2-5和2-3-2-5都为3步
 */
public class second{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int line = Integer.parseInt(in.nextLine());
		int[] num = new int[line];
		for(int i = 0;i <line;i++){
			num[i] = Integer.parseInt(in.nextLine());
		}
		int result = jump(num);
		System.out.println(result);	
	}
	public static int jump(int[] num) {
	    int [] dp = new int[num.length];
	    Arrays.fill(dp, num.length); 
	    dp[0] = 0;
	    for (int i = 1; i < dp.length; ++i) {
	        for (int j = 0; j < i; ++j) {
	            if (num[j] + j >= i)
	                dp[i] = Math.min(dp[i], dp[j]+1);
	        }
	    }
	    return dp[dp.length-1];
	}
}