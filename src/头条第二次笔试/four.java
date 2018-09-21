package 头条第二次笔试;

import java.util.Arrays;
import java.util.Scanner;

public class four
{

    static final int MAX = 100;
    static int dp[][][][] = new int[MAX][MAX][MAX][3];
    static int countWays(int p, int q, int r, int last)
    {
        if (p < 0 || q < 0 || r < 0)
            return 0;
        if (p == 1 && q == 0 && r == 0 && last == 0)
            return 1;
        if (p == 0 && q == 1 && r == 0 && last == 1)
            return 1;

        if (p == 0 && q == 0 && r == 1 && last == 2)
            return 1;
        if (dp[p][q][r][last] != -1)
            return dp[p][q][r][last];
        if (last == 0)
            dp[p][q][r][last] = countWays(p - 1, q, r, 1) +
                    countWays(p - 1, q, r, 2);
        else if (last == 1)
            dp[p][q][r][last] = countWays(p, q - 1, r, 0) +
                    countWays(p, q - 1, r, 2);
        else
            dp[p][q][r][last] = countWays(p, q, r - 1, 0) +
                    countWays(p, q, r - 1, 1);

        return dp[p][q][r][last];
    }

    static int countUtil(int p, int q, int r)
    {
        for (int[][][] row : dp)
        {
            for (int[][] innerRow : row)
            {
                for (int[] innerInnerRow : innerRow)
                {
                    Arrays.fill(innerInnerRow, -1);
                }
            }
        };
        return countWays(p, q, r, 0) + // Last required balls is type P
                countWays(p, q, r, 1) +    // Last required balls is type Q
                countWays(p, q, r, 2);       // Last required balls is type R
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();
        System.out.print(countUtil(p, q, r));
    }
}