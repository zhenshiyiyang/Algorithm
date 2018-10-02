package leetCode;

import com.sun.tools.javac.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permute {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        perm(list,nums,0);
        return list;
    }
    public static void perm(List<List<Integer>> list,int[] nums,int i){
        if(i==nums.length-1){
            List<Integer> list1 = Arrays.stream(nums).boxed().collect(Collectors.toList());;
            list.add(list1);
        }else {
            for (int j = i; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                perm(list, nums, i+1);
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
