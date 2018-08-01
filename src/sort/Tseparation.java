package sort;

import java.util.Arrays;

//快速排序的变种，一个整形数组，奇数偶数分离
public class Tseparation {
	 //快速排序的循环方法
     public static void change(int a[],int low,int high){
    	 while(low<high){
    		 while(a[high]%2==0){//找到右边的奇数
    			 high--;
    		 }
    		 while(a[low]%2!=0){//找到左边的偶数
    			 low++;
    		 }
    		 if(low<high){
    			 int temp = a[high];
    			 a[high] = a[low];
    			 a[low] = temp;
    		 }
    	 }
     }
     public static void main(String[] args){
    	 int a[] = {4,3,5,1,9,2,8,7};
    	 change(a,0,a.length-1);
    	 System.out.println(Arrays.toString(a));
     }
}




