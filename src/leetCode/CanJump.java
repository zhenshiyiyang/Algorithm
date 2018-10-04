package leetCode;

public class CanJump {
    public static void main(String[] args) {
            int[] nums = {2,3,1,1,4};
            System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
            int n = nums.length;
            // dp[i]表示当前跳跃的最大距离
            int dp[] = new int[n];
            dp[0] = nums[0];
            // i表示当前距离，也是下标
            for (int i = 1; i < n; i++) {
                // i点可达
                if (i <= dp[i - 1])
                    dp[i] = Math.max(dp[i - 1], i + nums[i]);
                else
                    dp[i] = dp[i - 1];
            }
            return dp[n - 1] >= (n - 1);
    }
}
