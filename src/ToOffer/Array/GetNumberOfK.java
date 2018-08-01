package ToOffer.Array;

/*
   统计一个数字在排序数组中出现的次数。
   利用二分查找，分别找出数字第一个位置和最后一个的位置。
 */
public class GetNumberOfK {
    public static void main(String[] args){
       int[] array = {1,2,3,3,3,3,4,5};
       int number = 0;
       if(array != null && array.length>0){
           int first = GetFirstK(array,array.length,3,0,array.length-1);
           int last = GetLastK(array,array.length,3,0,array.length-1);
           if(first>-1 && last>-1){
               number = last-first+1;
           }
       }
       System.out.println(number);
    }
    public static int GetFirstK(int[] array,int length,int k,int start,int end){
        if(start>end){
            return 1;
        }
        int mid = (start+end)/2;
        if(array[mid]==k){
            if((mid>0 && array[mid-1]!=k) || mid==0){
                return mid;
            }else {
                end = mid-1;
            }
        }else if(array[mid]>k){
            end = mid-1;
        }
        else{
            start = mid+1;
        }
        return GetFirstK(array,length,k,start,end);
    }
    public static int GetLastK(int[] array,int length,int k,int start,int end){
        if(start>end){
            return 1;
        }
        int mid = (start+end)/2;
        if(array[mid]==k){
            if((mid<length-1 && array[mid+1]!=k) || mid ==length-1){
                return mid;
            }else{
                start = mid+1;
            }
        }else if(array[mid]>k){
            end = mid-1;
        }else{
            start = mid+1;
        }
        return GetLastK(array,length,k,start,end);
    }
}
