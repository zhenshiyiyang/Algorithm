package ToOfferNew;
/*
  调整数组位置使奇数位于偶数之前
 */
public class Title14 {
    public static void quickSort(int[] array,int low,int high){
        if(array==null || low<0 || high<0 || low>high) return;
        while(low<high){
            while(low<high && (array[high]&1)==0){
                high--;
            }
            while(low<high && (array[low]&1)==1){
                low++;
            }
            if(low<high){
                int temp = array[low];
                array[low] = array[high];
                array[high] = array[low];
            }
        }
    }
}
