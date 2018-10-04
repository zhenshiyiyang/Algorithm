package leetCode;
/*
   连续子数组最大和
 */
public class MaxSubArray {
    public static void main(String[] args) {
         int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
         System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
         int n = nums.length;
         if(n<=0){
             return -1;
         }
         int max = Integer.MIN_VALUE;
         int sum = 0;
         for (int i = 0; i < n; i++) {
            if(sum<0){
               sum = nums[i];
            }else{
               sum += nums[i];
            }
            if(sum>max){
                max = sum;
            }
         }
         return max;
    }
}
