package ToOffer.Array;
//求旋转数组的最小值
//分情况考虑，第一种情况，数组旋转的长度为0，所以需要在最开始设置mid为第一个位置元素
//值，此时比较第一个元素和最后一个元素，即可知道数组全部有序，返回第一个即可。

public class RotatingArray {
       public static void main(String[] args){
    	   int[] array = new int[]{3,4,5,6,7,1,2};
    	   System.out.println(min(array));
       }
       public static int min(int[] array){
    	   int low = 0;
    	   int mid = low;
    	   int high = array.length-1;
    	   if(array==null || array.length==0){
    		   return -1;
    	   }else if(low==high){
    		   return array[low];
    	   }else{
	    	   while(array[low]>=array[high]){
	    		   if(high-low==1){
	    			   mid = high;
	    		   }
		    	   mid = (low + high)/2;
		    	   //如果下标为low，mid和high的三个数字相等，那么只能顺序查找
		    	   if(array[low]==array[mid] && array[mid]==array[high]){
		    		   return MinInOrder(array,low,high);
		    	   }
		    	   if(array[mid]>=array[low]){
		    		   low = mid;
		    	   }else if(array[mid]<=array[high]){
		    		   high = mid;
		    	   }
	    	   }
    	   }
    	   return array[mid];
       }
       //旋转数组中很多重复值时，只能对旋转数组进行顺序查找.
       public static int MinInOrder(int[] array,int low,int high){
    	   int result = array[low];
    	   for(int i=low+1;i<high;i++){
    		   if(result>array[i]){
    			   result = array[i];
    		   }
    	   }
    	   return result;
       }
}
