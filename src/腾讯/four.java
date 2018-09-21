package 腾讯;

import java.util.HashMap;
import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        HashMap<String,Integer> map = new HashMap<>();
        int n = str1.length();
        int m = str2.length();
        int count = 0;
        for (int i = 0; i < n-k+1; i++) {
            String s = str1.substring(i, i+k);
            map.put(s,1);
        }
        if(m<k){
            System.out.println(0);
        }else{
            for (int i = 0; i < m-k+1; i++) {
                String s1 = str2.substring(i,i+k);
                if(map.containsKey(s1)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
