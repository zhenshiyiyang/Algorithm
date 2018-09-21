package 拼多多;

import java.util.Arrays;
import java.util.Scanner;
/*
   优惠券
 */
public class youhui {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] good=new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            good[i] = sc.nextInt();
            total += good[i];
        }
        Arrays.sort(good);
        int[] fee = new int[1001];
        int[] count = new int[1001];
        for (int i = 0; i < m; i++) {
           int x = sc.nextInt();
           int y = sc.nextInt();
           fee[x] = y;
           if(count[x]==0){
               count[x] = 1;
           }else{
               count[x] = count[x]+1;
           }
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            int max = 0;
            int pos = 0;
            for(int j=0;j<=good[i];j++){
               if(fee[j]>=max&&count[j]>0){
                   max = fee[j];
                   pos = j;
               }
            }
            count[pos] = count[pos] - 1;
            sum += max;
        }

        System.out.println(total-sum);
    }
}
