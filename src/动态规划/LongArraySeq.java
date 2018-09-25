package 动态规划;

import java.util.Stack;
/*
  最长公共子序列，利用dp算法，分两种情况考虑即可，最后利用栈来对子序列进行求值输出。
 */
public class LongArraySeq {
	public static void main(String[] args){
		String str1 = "axbydzenf";
		String str2 = "acbsdiepf";
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		System.out.println(longestSeq(s1,s2));
	}
	public static int longestSeq(char[] s1,char[] s2){
		int n = s1.length;
		int m = s2.length;
		int[][] dp = new int[n+1][m+1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if(i==0 || j==0){
                    dp[i][j] = 0;
				}else{
					if(s1[i-1]==s2[j-1]){
						dp[i][j] = dp[i-1][j-1]+1;
					}else{
						dp[i][j] = dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1];
					}
				}
			}
		}

		Stack stack = new Stack();
		int i = s1.length - 1;
		int j = s2.length - 1;

		while((i >= 0) && (j >= 0)){
			if(s1[i] == s2[j]){//字符串从后开始遍历，如若相等，则存入栈中
				stack.push(s1[i]);
				i--;
				j--;
			}else{
				//如果字符串的字符不同，则在数组中找
				// 相同的字符，注意：数组的行列要比字
				// 符串中字符的个数大1，因此i和j要各加1
				if(dp[i+1][j] > dp[i][j+1]){
					j--;
				}else{
					i--;
				}
			}
		}

		while(!stack.isEmpty()){//打印输出栈正好是正向输出最大的公共子序列
			System.out.print(stack.pop());
		}
		return dp[n][m];
	}
}
