package 动态规划;
/*
   最长公共子串。
 */
public class LongestSubStr {
    public static void main(String[] args) {
         String str1 = "abcdexyz";
         String str2 = "abcdabcdef";
         char[] s1 = str1.toCharArray();
         char[] s2 = str2.toCharArray();
         System.out.println(dp(s1,s2));
    }
    public static String dp(char[] s1,char[] s2){
         int n = s1.length;
         int m = s2.length;
         int max = 0;
         int index = 0;
         int[][] dp = new int[n+1][m+1];
         for (int i = 0; i < n; i++) {
             for (int j = 0; j < m; j++) {
                 if(i==0 || j==0){
                     dp[i][j]=0;
                 }else{
                     if(s1[i]==s2[j] && s1[i-1]==s2[j-1]){
                         dp[i][j] = dp[i-1][j-1]+1;
                     }else{
                         dp[i][j] = 0;
                     }
                 }
                 if(dp[i][j]>max){
                     max = dp[i][j];
                     index = i;
                 }
             }
         }
         if(max==0){
             return "";
         }else{
             String res = String.valueOf(s1).substring(index-max,index+1);
             return res;
         }
    }
}
