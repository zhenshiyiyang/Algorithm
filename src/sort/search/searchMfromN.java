package sort.search;
/*从N个数中找出第m大的数字。利用快排的思想，
每次partition会确定枢轴元素的位置，并且位于
枢轴元素之前的元素都大于枢轴元素，且枢轴元素
之后的元素都小于枢轴元素。这样当某个枢轴元素
的位置确定在m时，该枢轴元素就是第m大元素。可以
证明这样做的时间复杂度是O(n)。
*/
public class searchMfromN {
    public static void main(String[] args){
    	int[] array = {5,4,6,9,10,3,2,8,1};
    	int loc = 3;
    	int result = quick(array,0,array.length-1,array.length-loc);
    	System.out.println(result);
    }
    public static int quick(int[] array,int low,int high,int m){
      if(low<=high){
	    	int p = partition(array,low,high);
	    	if(p == m){
	    		return array[p];
	    	}
	    	else if(p<m){
    			return quick(array,p+1,high,m);
    		}else{
    			return quick(array,low,p-1,m);
    		}
      }else{
	        return -1;
      }
    }
    public static int partition(int[] array,int low,int high){
    	int i = low;
    	int start = array[low];
    	while(low<high){
    		while(low<high && array[high]>=start){
    			high--;
    		}
    		while(low<high && array[low]<=start){
    			low++;
    		}
    		if(low<high){
    			int t = array[high];
    			array[high] = array[low];
    			array[low] = t;
    		}
    	}
    	array[i] = array[low];
    	array[low] = start;
    	return low;
    }
}
