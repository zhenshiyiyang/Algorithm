package leetCode;

public class RoatingSearch {
    public static void main(String[] args){
        int[] array = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(array,0));
    }
    public static boolean search(int[] nums, int target) {
        if(nums.length==0||nums==null){
            return false;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return true;
            }
        }
        return false;
    }
}
