package sort;
/*
 * 找出排好序数组中数组首次出现的位置，
 * 思路就是利用二分查找，针对mid值进行比较。
 */
public class FirstAppear {
    public static void main(String[] args){
    	int[] array = {1,2,2,3,3,3,4,5,6};
    	System.out.println(Loc(array,4));
    }
    public static int Loc(int[] array,int num){
    	if(array==null) return -1;
    	int low = 0;
    	int high = array.length-1;
    	while(low<=high){
    		int mid = (low+high)/2;
    		if(array[mid]==num){
    			if(array[mid-1]<num){
    			    return mid;
    			}else{
    				high = mid-1;
    			}
    		}else if(array[mid]>num){
    			high = mid-1;
    		}else{
    			low = mid+1;
    		}
    	}
    	return -1;
    }
}
