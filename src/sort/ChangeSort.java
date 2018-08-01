package sort;

import java.util.Arrays;

public class ChangeSort {
	//冒泡排序,时间复杂度为O(n2)
	//交换两个元素　　
	//冒泡排序的基本思想是，对相邻的元素进行两两比较，
	//顺序相反则进行交换，这样，每一趟会将最小或最大的
	//元素“浮”到顶端，最终达到完全有序
	public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void bubbleSort(int[] array){
        if (array == null) return;
        int len = array.length;;
        for(int i = 0; i < len-1; i++){
            for (int j = len-1; j > i; j--){//最小的浮到最上面
                if (array[j] < array[j-1] ){
                    swap(array,j,j-1);
                }
            }
        }
    }
    
    public static void main(String[] args){
		int a[] = {5,1,7,9,3,6,2,4};
		//bubbleSort(a);
		quickSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
    //快速排序，时间复杂度为O(nlogn)，最坏情况是O(n^2)
    //哨兵两个，基准数
    public static void quickSort(int[] array, int low, int high){
        if (array == null || low < 0 || high < 0 || low >= array.length) return;
        int pivotloc = partition(array, low, high);
        if(low < high){
            quickSort(array, low, pivotloc-1);
            quickSort(array,pivotloc+1,high);
        }
    }
    public static int partition(int[] array, int low, int high){
    	//pivokey基准数
        int pivokey = array[low];
        //记录最初基准数对应的数组下标位置，以便最后的基准数交换。
        int i = low;
        int t = 0;  //循环交换左右元素
        while(low < high){
            //顺序很重要，要先从右边开始找 
            while(low < high && array[high] >= pivokey)
            {
                high--;
            }
            //再找左边的 
            while(low < high && array[low] <= pivokey)
            {
                low++;
            }
            //交换两个数在数组中的位置 
            if(low<high){
               t = array[high];
               array[high] = array[low];
               array[low] = t;
            }
        }
        //最终将基准数归位 
        array[i] = array[low];
        array[low] = pivokey;
        return low;
    }


}
