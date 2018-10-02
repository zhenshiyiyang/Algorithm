package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list,new ArrayList<>(),candidates,target,0);
        return list;
    }
    public static boolean backtrack(List<List<Integer>> list,List<Integer> temp,int[] a,int remain,int start){
        if(remain < 0)
            return false;
        if(remain == 0){
            list.add(new ArrayList<Integer>(temp));
            return true;
        }
        else{
            for(int i = start;i<a.length;i++){
                boolean flag = true;
                //控制去重，只有当target==0时，i才会加加
                // 因此可通过i>start 判断已有一次得到结果
                // 通过a[i]==a[i-1]去重
                if(i>start&&a[i]==a[i-1]){
                    continue;
                }
                temp.add(a[i]);
                flag = backtrack(list, temp, a, remain-a[i], i+1);
                temp.remove(temp.size()-1);// not i+1,because we can use same number
                if(!flag)
                    break;
            }
            return true;
        }
    }
}
