package 创新工场;

import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[505];
        int[][] f = new int[505][505];
        int ans = 0;
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = sc.nextLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(strs[i-1]);
            f[i][1] = a[i];
        }
        for (int j = 2; j <= n; j++) {
            for (int i = 1; i <= n-j+1; i++) {
                f[i][j] = j*Math.abs(a[i]-a[i+j-1]);
                for (int k = 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j],f[i][k]+f[k+i][j-k]);
                }
            }
        }
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans,f[i][n]);
        }
        System.out.println(ans);
    }
}
