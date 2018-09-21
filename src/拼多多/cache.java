package 拼多多;

import java.util.HashSet;
import java.util.Scanner;
/*
  缓存
 */
public class cache {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }
        int flag = n;
        for(int i=2;i<=n;i++){
            HashSet<Integer> set = new HashSet<>();
            int max = 0;
            int min = n;
            for(int j=0;j<n;j++){
                int x = num[j]%i;
                if(!set.contains(x)){
                    set.add(x);
                    if(x>=max){
                        max = x;
                    }
                    if(x<=min){
                        min = x;
                    }
                }
            }
            if(max+1<flag){
                flag = max+1;
            }
        }
        System.out.println(flag);
    }
}
