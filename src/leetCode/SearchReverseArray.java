package leetCode;

public class SearchReverseArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums,int target){
        int n = nums.length;
        int i = 0;
        int j = n-1;
        if(n<=0){
            return -1;
        }else {
            while (i < j) {
                int mid = (i + j) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] >= nums[i]) {
                    if (nums[i] <= target && nums[mid] > target) {
                        j = mid - 1;
                    } else {
                        i = mid + 1;
                    }
                } else {
                    if (nums[j] >= target && nums[mid] < target) {
                        i = mid + 1;
                    } else {
                        j = mid - 1;
                    }
                }
            }
            return nums[i] == target ? i : -1;
        }
    }
}
