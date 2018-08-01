package sort;
//求数组中第k大的数字，此为快排的变形题，非常经典
//利用快排的思想，从数组arr中随机找出一个元素X，把数组分成两部分。
public class kMax {
	public static int partition(int[] a,int low,int high){  
        int tmp=a[low];  
        while(low<high){  
            while(low<high && a[high]>tmp)  
                --high;  
            a[low]=a[high];  
            while(low<high && a[low]<tmp)  
                ++low;  
            a[high]=a[low];  
        }  
        a[low]=tmp;  
        return low;  
    }  
    //这里的k意思是，左边序列的元素个数，左边有len-k个元素，此元素就是k大元素  
    public static int kMaxSort(int[] a,int low,int high,int k){  
        int kmax;  
        if(k<0)  
            return 0;  
        if(low>=high)  
            return a[low];  
        else{  
            int mid=partition(a, low, high);  
            //递归左边序列  
            if(mid>k)  
                kmax=kMaxSort(a, low, mid-1, k);  
            //递归右边序列，但是k要变成k-mid  
            else if(mid<k)  
                kmax=kMaxSort(a, mid+1, high, k-mid);         
            else  
                kmax= a[mid];  
        }  
        return kmax;  
    }  
    public static void main(String[] args) {  
        int[] a={10,7,8,6,3,1,5,2,4,9};  
        int k =10;  
        int len = a.length;  
        //注意k为len-k，转换成求第几个数的数组下标,方便计算 
        int kmax= kMaxSort(a,0, len-1, len-k);  
        System.out.println(kmax);  
    }  
}
