package ToOfferNew;
/*
  求旋转数组的最小值
 */
public class Title8 {
    public static int Min(int[] nums){
        if(nums==null){
            try{
                throw new Exception("数组不合法");
            }catch (Exception e){

            }
        }
        if(nums.length==1){
            return nums[0];
        }
        int index1 = 0;
        int index2 = nums.length-1;
        int mid = index1;
        while (nums[index1]>=nums[index2]){
            if(index2-index1==1){
                mid = index2;
                break;
            }
            mid = (index1+index2)/2;
            //如果下标为index1、index2和mid指向的三个数字相等，则只能顺序查找。
            if(nums[index1]==nums[index2] && nums[index1]==nums[mid]){
                return MinInOrder(nums,index1,index2);
            }
            if(nums[mid]>=nums[index1]){
                index1 = mid;
            }else if(nums[mid]<=nums[index2]){
                index2 = mid;
            }
        }
        return nums[mid];
    }
    //顺序查找
    public static int MinInOrder(int[] nums,int index1,int index2){
        int result = nums[index1];
        for (int i = index1+1; i <= index2; i++) {
            if(result>nums[i]){
                result = nums[i];
            }
        }
        return result;
    }
}
