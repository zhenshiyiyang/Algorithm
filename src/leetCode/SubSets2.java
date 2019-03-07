package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> result = subsets(nums);
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i));
//        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        // 排序可以避免重复，然后结果可以安装顺序输出
        Arrays.sort(nums);
        dfsCore(res, 0, tmp, nums);
        System.out.println(res);
        return res;
    }
    private static void dfsCore(List<List<Integer>> res, int curIdx, List<Integer> tmp, int[] nums) {
        if (curIdx <= nums.length) {
            if(!res.contains(tmp)) {
                res.add(new ArrayList<Integer>(tmp));
            }
        }
        // 下标从curIdx开始
        for (int i = curIdx; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfsCore(res, i + 1, tmp, nums);
            tmp.remove(tmp.size() - 1);
        }

    }
}
