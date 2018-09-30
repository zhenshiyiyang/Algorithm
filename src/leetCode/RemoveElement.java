package leetCode;

public class RemoveElement {
    public static void main(String[] args) {
            int[] nums = {0,1,2,2,3,0,4,2};
            System.out.println(removeElement(nums,2));
    }
    public static int removeElement(int[] nums,int val){
            int len = nums.length;
            int tempLen = len;
            int step = 0;//每个元素需要向前转移的距离
            for(int i = 0; i < len; i++){
                if(nums[i] == val){
                    step++;//若相等步长+1
                    tempLen--;//每一个相等的元素长度减少1
                }else{
                    nums[i-step] = nums[i];//元素前移n个步长
                }
            }
            return tempLen;
    }
}
