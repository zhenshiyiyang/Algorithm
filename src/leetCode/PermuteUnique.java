package leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class PermuteUnique {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        permUnique(set,nums,0);
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }
    public static void permUnique(Set<List<Integer>> set,int[] nums,int i){
        if(i==nums.length-1){
            List<Integer> list1 = Arrays.stream(nums).boxed().collect(Collectors.toList());;
            set.add(list1);
        }else {
            for (int j = i; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                permUnique(set, nums, i+1);
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
