package 动态规划;
/*
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。
 * 思路：
 * 当n为1时，f(n) = 1,n为2时，f(n) =2,就是说当台阶只有一级的时候，
 * 方法数是一种，台阶有两级的时候，方法数为2。那么当我们要走上n级台阶，
 * 必然是从n-1级台阶迈一步或者是从n-2级台阶迈两步，所以到达n级台阶的方
 * 法数必然是到达n-1级台阶的方法数加上到达n-2级台阶的方法数之和。
 * 即f(n) = f(n-1)+f(n-2)，我们用dp[n]来表示动态规划表，dp[i],i>0,i<=n,
 * 表示到达i级台阶的方法数。
 */
public class Step {
	public static int[] dp = new int[100];
	public static void main(String[] args){
		System.out.println(fun(10));
	}
	public static int fun(int n){
		if(n==1 || n==2){
			return n;
		}
		if(dp[n-1]==0){
		  dp[n-1] = fun(n-1);
		}
		if(dp[n-2]==0){
		  dp[n-2] = fun(n-2);
		}
		return dp[n-1]+dp[n-2];
	}
}
