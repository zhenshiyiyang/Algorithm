package 动态规划;
/*
   最长递增子序列长度
   利用dp解，利用一维数组记录当前位置对应的前面递增子序列的个数。
   初始化dp每一位的值为1，不断进行更新。
 */
public class IncreasingSubSequence {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,1,7};
        System.out.println(longestIncreasingSubSequence(nums));
    }
    public static int longestIncreasingSubSequence(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i]>=nums[j] && dp[j]+1>dp[i]){
                     dp[i] = dp[j]+1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
