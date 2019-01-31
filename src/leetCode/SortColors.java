package leetCode;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    //快排,小于1的放左边，大于1的放右边
    public static void sortColors(int[] nums) {
        int less=-1;
        int more=nums.length;
        int i=0;
        while(i<more){
            if(nums[i]<1)
                swap(nums,++less,i++);
            else if(nums[i]>1)
                swap(nums,--more,i);
            else
                i++;
            System.out.println(Arrays.toString(nums));
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
