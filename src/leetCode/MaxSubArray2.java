package leetCode;
/*
   连续子数组最大和，利用动态规划的思想解题。
 */
public class MaxSubArray2 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max+nums[i],nums[i]);
            result = Math.max(result,max);
        }
        return result;
    }
}
