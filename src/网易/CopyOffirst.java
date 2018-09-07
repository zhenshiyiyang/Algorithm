package 网易;

import java.util.Scanner;
/*
 * 
n堆苹果，问第i个苹果属于第几堆。
输入：
5
2 7 3 4 9
3
1 25 11
输出:
1
5
3
 */
public class CopyOffirst {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] ai = new int[n+1];
    	int[] sum = new int[n+1];
    	for(int i=0;i<n;i++){
    		ai[i] = sc.nextInt();
    		sum[i+1] = ai[i]+sum[i];
    	}
    	int m = sc.nextInt();
    	int[] qi = new int[m];
    	for(int j=0;j<m;j++){
    		qi[j] = sc.nextInt();
    		if(qi[j]<=0 || qi[j]>sum[n]){
    			return;
    		}else{
    			System.out.println(binarySearch(sum,qi[j]));
    		}
    	}
    }
    public static int binarySearch(int[] arr, int x) {
    	if(arr==null){
    		return -1;
    	}
        int low = 0;   
        int high = arr.length-1;   
        while(low <= high) {
        	if(high-low<=1){
        		return high;
        	}
            int middle = (low + high)/2;   
            if(x == arr[middle]) {   
                return middle;   
            }else if(x <arr[middle]) {   
                high = middle;   
            }else {   
                low = middle;   
            }  
        }  
        return -1;  
    }
}