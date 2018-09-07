package leetCode;
/*
 * 首先对数组排序。固定一个数字，利用left和right两个指针，
 * 进行判断，求出差值最小的那个三数之和。
 */
public class sum3close {
    public static void main(String[] args){
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int closest = nums[0]+nums[1]+nums[2];
        int diff = Math.abs(closest-target);
        quickSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length-2;i++){
        	int left = i+1;
        	int right = nums.length-1;
        	while(left<right){
        		int sum = nums[i]+nums[left]+nums[right];
        		int newDiff = Math.abs(sum-target);
        		if(diff>newDiff){
        			diff = newDiff;
        			closest = sum;
        		}
        		if(sum<target) left++;
        		else right--;
        	}
        }
        System.out.println(closest);
    }
    public static void quickSort(int[] array, int low, int high){
        if (array == null || low < 0 || high < 0 || low >= array.length) return;
        int pivotloc = partition(array, low, high);
        if(low < high){
            quickSort(array, low, pivotloc-1);
            quickSort(array,pivotloc+1,high);
        }
    }
    public static int partition(int[] array, int low, int high){
        int pivokey = array[low];
        int i = low;
        int t = 0; 
        while(low < high){
            while(low < high && array[high] >= pivokey)
            {
                high--;
            }
            while(low < high && array[low] <= pivokey)
            {
                low++;
            }
            if(low<high){
               t = array[high];
               array[high] = array[low];
               array[low] = t;
            }
        }
        array[i] = array[low];
        array[low] = pivokey;
        return low;
    }
}
