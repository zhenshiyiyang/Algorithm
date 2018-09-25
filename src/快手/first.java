package 快手;

import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int res = 0;
        int low = 0;
        int high = n - 1;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int low_res = arr[0];
        int high_res = arr[n - 1];
        while (low < high) {
            if (low_res == high_res) {
                res = low_res;
                low_res += arr[++low];
                high_res += arr[--high];
            } else if (low_res < high_res) {
                low_res += arr[++low];
            } else {
                high_res += arr[--high];
            }
        }
        System.out.println(res);
    }

}