package 小米;

import java.util.*;
public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] s1 = sc.nextLine().split(" ");
            int[] num = new int[s1.length];
            for (int j = 0; j < s1.length; j++) {
                num[j] = Integer.parseInt(s1[j]);
            }
            list.add(num);
        }
        System.out.println(list.size());
    }
}