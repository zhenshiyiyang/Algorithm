package leetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoNumSum {
	public static void main(String[] args){
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		System.out.println(twoSum(nums,target)[1]);
	}
	public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int j=0;j<nums.length;j++){
            int b = target-nums[j];
            if(map.containsKey(b) && j != map.get(b)){
                return new int[]{j,map.get(b)};
            }
        }
        return answer;
    }
}
