package sort.search;
//n个排好序的数，找出某个数第一次出现的位置。利用二分的思想，加上一些限制条件。
public class searchFrist {
    public static void main(String[] args){
    	int[] array = {1,2,2,2,3,4,4,5,6,7};
    	System.out.println(binary(array,4));
    }
    public static int binary(int[] array,int key){
    	int low = 0;
    	int high = array.length-1;
    	while(low <= high){
    	   int middle = (low+high)/2;
    	   if(array[middle]==key && array[middle-1]<key){
    		   return middle;
    	   }
    	   else if(array[middle]<key){
    		   low = middle+1;
    	   }
    	   else{
    		   high = middle-1;
    	   }
    	}
    	return -1;
    }
}
