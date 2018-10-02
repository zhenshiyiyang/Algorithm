package leetCode;

public class SearchInsert {
    public static void main(String[] args) {
         int[] nums = {1,3,5,6};
         int target = 7;
         System.out.println(searchInsert(nums,target));
    }
    public static int searchInsert(int[] nums, int target) {
         int n = nums.length;
         int i = 0;
         for (i = 0; i < n; i++) {
            if(target<=nums[i]){
                break;
            }
         }
         return i;
    }
}
