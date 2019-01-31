package 创新工场;

import java.util.Scanner;

public class first {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         sc.nextLine();
         String str = sc.nextLine();
         String[] strs = str.split(" ");
         int[] nums = new int[n];
         for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
         }
         int count = 0;
         while(n>1){
             n = n/2;
             count++;
         }
         int loc = (int) Math.pow(2,count);
         System.out.println(nums[loc-1]);
         System.out.println(loc);
    }
}
