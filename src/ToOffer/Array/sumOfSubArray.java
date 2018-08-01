package ToOffer.Array;
/*
 * 输入一个整型数组，数组里有正数也有负数，数组中一个或连续
 * 的多个整数组成一个子数组，求所有子数组的和的最大值。要求时间复杂度
 * 为O(n)
 */
public class sumOfSubArray {
     public static void main(String[] args){
    	 int[] array = {1,-2,3,10,-4,7,2,-5};
    	 System.out.println(findSumOfSubArray(array));
     }
     public static int findSumOfSubArray(int[] array){
    	 int len = array.length;
    	 int curSum = 0;
    	 int greatestSum = 0;
    	 if(len==0 || array==null){
    		 return 0;
    	 }else{
    		 for(int i=0;i<len;i++){
    			 if(curSum <= 0){
    				 curSum = array[i];
    			 }else{
    				 curSum += array[i];
    			 }
    			 if(curSum > greatestSum){
    				 greatestSum = curSum; 
    			 }
    		 }
    	 }
    	 return greatestSum;
     }
}
