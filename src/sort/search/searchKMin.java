package sort.search;
/*
 * 从n个无序的顺序表中找出第k小的数，采用快排思想：

先从n个元素中随便寻找一个数m作为分界点,m在列表中的位置为i

当 i = k时，m就是我们要寻找的第k小的数；

当 i > k时，我们就从1~i-1中查找；

当 i < k时，就从i+1~n中查找。
 */
public class searchKMin {
	    public static int partition(int A[], int low, int high) {
	        int pivotkey = A[low];  
	        while (low < high) {  
	            while (low < high && A[high] >= pivotkey)  
	                high--;  
	            A[low] = A[high];  
	            while (low < high && A[low] <= pivotkey)  
	                low++;  
	            A[high] = A[low];  
	        }  
	        A[low] = pivotkey;  
	        return low;  
	    }  
	    public static  int quickSort(int A[],int low,int high,int k){  
	        if(low <= high){  
	            int loc = partition(A,low,high);
	            if(loc == (k-1)){
	                return A[loc];
	            }  
	            else if(loc < (k-1)){
	                return quickSort(A,loc+1,high,k);
	            }  
	            else{  
	                return quickSort(A,low,loc-1,k);
	            }  
	        }else{  
	            return -1;  
	        }         
	    }  
	      
	    public static void main(String[] args) {  
	        int A[] = { 49, 38, 65, 97, 76, 13, 27, 49 };  
	        int k =8;  
	        int mink = quickSort(A, 0, A.length - 1,k);  
	        System.out.println("mink:"+mink);  
	    }  
}
