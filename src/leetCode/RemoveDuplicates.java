package leetCode;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums){
        int i = 0;
        int j = 0;
        int n = nums.length;
        if (n==0)return n;
        else {
            for (i = 1; i < n; i++) {
                if(nums[i]!=nums[j]){
                    nums[++j] = nums[i];
                }
            }
        }
        return j+1;
    }
}
