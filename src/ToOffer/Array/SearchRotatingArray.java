package ToOffer.Array;
//旋转数组中求给出的值k的位置。
//利用二分查找的思想，找到中间位置，
//利用中间值和最开始值进行比较，如果中间值比最开始值大
//则走第一个if判断，否则else
public class SearchRotatingArray {
	public static void main(String[] args){
	    int[] array = new int[]{4,5,6,7,8,9,1,2,3};
        System.out.println(search(array,2));
    }
	public static int search(int[] A, int target) {
	    int low = 0;
	    int high = A.length - 1;
	    while (low < high) {
	        int mid = (low + high) / 2;
	        if (A[mid] == target) return mid;
	        //中间值比最开始值大
	        if (A[low] <= A[mid]) {
	        	//因为前半部分有序，所以target与low和mid进行比较
	            if (target >= A[low] && target < A[mid]) {
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }
	        } else {    //中间值比最开始值小
	        	//因为后半部分有序，所以target与mid和high进行比较
	            if (target > A[mid] && target <= A[high]) {
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }
	    }
	    return A[low] == target ? low : -1;
	}
}

