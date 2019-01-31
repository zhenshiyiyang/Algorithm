package leetCode;

import java.util.Arrays;

public class RemoveDuplicates2 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int n = removeDuplicates(nums);
        System.out.println(n);
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int num = 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[j]==nums[i]){
                num++;
                if(num<2){
                    nums[++j] = nums[i];
                }
            }else{
                nums[++j] = nums[i];
                num = 0;
            }
        }
        return j+1;
    }
}
