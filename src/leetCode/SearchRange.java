package leetCode;

import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
          int[] nums = {5,7,7,8,8,10};
          int target = 8;
          System.out.println(Arrays.toString(searchRange(nums,target)));
    }
    public static int[] searchRange(int[] nums, int target) {
          int n = nums.length;
          int low = 0;
          int high = n-1;
          int begin = -1;
          int end = -1;
          if(n<=0){
              return new int[]{-1,-1};
          }else{
              while(low<=high){
                  int mid = (low+high)/2;
                  if(nums[mid]==target){
                      while(mid>=low && nums[mid]==target){
                          mid--;
                      }
                      begin = mid+1;
                      mid = (low + high)/2;
                      while(mid<=high && nums[mid]==target){
                          mid++;
                      }
                      end = mid - 1;
                      break;
                  }else if(nums[mid]<target){
                      low = mid+1;
                  }else{
                      high = mid-1;
                  }
              }
          }
          return new int[]{begin,end};
    }
}
