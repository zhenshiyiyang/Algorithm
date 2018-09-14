package 搜狐;

import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        target = Math.abs(target);
        int result = 0, sum = 0;
        while (sum < target || (sum - target) % 2 == 1) {
            result++;
            sum += result;
        }
        System.out.println(result);
    }
}
