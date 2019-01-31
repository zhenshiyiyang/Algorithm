package 创新工场;


import java.util.Scanner;

public class third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        int k = Integer.parseInt(str1[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findSum(arr,k);
    }
    public static void findSum(int[] arr,int number){
        int left  = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length;i++){
            left  = i;
            right = i;
            int curCount =0;
            while(curCount < number && right<arr.length-1){
                curCount+=arr[right++];
            }
            if(curCount == number){
                if(right-left>max){
                    max = right-left;
                    start = left;
                    end = right;
                }
            }
        }
        if(start==0 && end==0){
            System.out.println(0+" "+0);
        }else {
            System.out.println(start + " " + end);
        }
    }
}
