package sort;

import java.util.Arrays;

public class SelectSort {
	//直接选择排序，时间复杂度O(n^2)，每次都直接选择最小的数放在前面
	public static void selectDirectlySort(int[] a) {
        if (a == null) return;
        int min = 0;
        int i = 0;
        int j = 0;
        int index = 0;
        int len = a.length;
        for (i = 0; i < len - 1; i++) {
        	//min记录最小的数，index记录最小的数对应的数组下标。
            min = a[i];
            index = i;
            for (j = i + 1; j < len; j++) {
                if (a[j] < min) {
                    min = a[j];
                    index = j;
                }
            }
            a[index] = a[i];
            a[i] = min;
        }
    }
    
	public static void main(String[] args){
		int a[] = {5,1,7,9,3,6,2,4};
		//selectDirectlySort(a);
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	//堆排序,时间复杂度为O(nlogn)
	/*
	 * 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，
	 * 整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，
	 * 此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，
	 * 这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
	 */
	public static void heapSort(int[] array) {
        if (array == null) return;
        buildHeap(array);//构建堆
        int n = array.length;
        int i = 0;
        //堆顶元素与最下面元素互换.
        for (i = n - 1; i >= 1; i--) {
            swap(array, 0, i);
            heapify(array, 0, i-1);
        }
    }
    //构建
    public static void buildHeap(int[] array) {
        int n = array.length;//数组中元素的个数
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, i, n);
    }
    public static void heapify(int[] A, int idx, int max) {
        int left = 2 * idx + 1;// 左孩子的下标（如果存在的话）
        int right = 2 * idx + 2;// 右孩子的下标（如果存在的话）
        int largest = 0;//寻找3个节点中最大值节点的下标
        if (left < max && A[left] > A[idx])
            largest = left;
        else
            largest = idx;
        if (right < max && A[right] > A[largest])
            largest = right;
        //父节点不是最大值
        if (largest != idx) {
            swap(A, largest, idx);//交换使父节点为三个节点里的最大值
            heapify(A, largest, max);//向下调整子树
        }
    }
    public static void swap(int[] array, int i, int j) {
        int temp = 0;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
