package sort;

import java.util.Arrays;

public class InsertSort {
      public static void insertDirectlySort(int a[]){
    	  if(a == null) return;
    	  int len = a.length;
    	  //直接插入排序，时间复杂度O(n2),即按顺序与前面每个元素比较，插入到合适
    	  //位置，j作为游标一直与j-1元素比较。
    	  for(int i=0;i<len;i++){
    		  for(int j=i+1;j<len && j>0;j--){
    			  if(a[j]<a[j-1]){
    				  int temp = a[j-1];
    				  a[j-1] = a[j];
    				  a[j] = temp;
    			  }
    		  }
    	  }
      }
      //希尔排序,时间复杂度O(n1.3)
      //希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着
      //增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，
      //算法便终止。
      public static void shellSort(int a[]){
    	  if(a == null) return;
    	  int len = a.length/2;
    	  int temp = 0;
    	  int j = 0;
    	  //增量，每次除以2
    	  for(int increament = len;increament>0;increament/=2){
    		   //控制一次的增量完成
    		   for(int i=increament;i<a.length;i++){
    			   temp = a[i];
    			   //寻找与i根据增量匹配的元素
    			   for(j=i-increament;j>=0;j-=increament){
    				   if(temp<a[j]){
    					   a[j+increament] = a[j];
    				   }else{
    					   break;
    				   }
    			   }
    			   a[j+increament] = temp;
    		   }
    	  }
    	  
    	  
      }
      public static void main(String[] args){
    	  int a[] = {3,6,2,5,9,8,1,4,7};
    	  //insertDirectlySort(a);
    	  shellSort(a);
    	  System.out.println(Arrays.toString(a));
      }
}
