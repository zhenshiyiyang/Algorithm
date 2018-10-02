package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                temp.add(a[i]);
                flag = backtrack(list, temp, a, remain-a[i], i);
                temp.remove(temp.size()-1);// not i+1,because we can use same number
                if(!flag)
                    break;
            }
            return true;
        }
    }

}
