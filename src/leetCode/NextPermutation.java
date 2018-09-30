package leetCode;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] num = {1,2,3};
        nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }
    public static void nextPermutation(int[] num) {
        if(num==null||num.length==0)
            return ;
        int i=num.length-2;
        while(i>=0&&num[i]>=num[i+1])
            i--;
        if(i>=0){
            int j=i+1;
            while(j<num.length&&num[j]>num[i])
                j++;
            j--;
            swap(num,i,j);
        }
        reverse(num,i+1,num.length-1);
    }
    public static void swap(int[] num,int i,int j){
        int temp = num[i];
        num[i]=num[j];
        num[j]=temp;
    }
    public static void reverse(int[] num,int i,int j){
        while(i<j)
            swap(num,i++,j--);
    }
}
