package leetCode;

import java.util.Arrays;

public class NumsMerge {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int index = m+n-1;
        while(index>=0){
            if(i<0){
                nums1[index--] = nums2[j--];
            }else if(j<0){
                nums1[index--] = nums1[i--];
            }else if(nums1[i]>nums2[j]&&i>=0){
                nums1[index--] = nums1[i--];
            }else if(nums1[i]<=nums2[j]&&j>=0){
                nums1[index--] = nums2[j--];
            }
        }
    }
}
