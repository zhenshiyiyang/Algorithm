package sort;

import java.util.Arrays;

public class MergingSort {
	//归并排序，O(nlogn)
	public static int[] mergeSort(int[] nums, int low, int high) {
        if (nums == null || low < 0 || low > nums.length-1 || high < 0) return nums;
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边           
        	mergeSort(nums, low, mid);
            // 右边
            mergeSort(nums, mid + 1, high);
            // 左右归并           
            merge(nums, low, mid, high);
        }
        return nums;
    }
    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        // 把右边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
        	//注意这里需要用k2+low
            nums[k2 + low] = temp[k2];
        }
    }
    
    public static void main(String[] args){
  	  int a[] = {3,6,2,5,9,8,1,4,7};
  	  //insertDirectlySort(a);
  	  mergeSort(a,0,8);
  	  System.out.println(Arrays.toString(a));
    }

}
