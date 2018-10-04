package leetCode;

import java.util.Arrays;

public class GenerateMatrix {
    public static void main(String[] args) {
        int n = 3;
    }
    public static int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = n - 1;
        int count = 1;
        while (left <= right && up <= down) {
            // 上
            for (int j = left; j <= right; j++)
                ret[up][j] = count++;
            up++;
            // 右
            for (int j = up; j <= down; j++)
                ret[j][right] = count++;
            right--;
            // 下
            for (int j = right; j >= left; j--)
                ret[down][j] = count++;
            down--;
            // 左
            for (int j = down; j >= up; j--)
                ret[j][left] = count++;
            left++;

        }
        return ret;
    }
}
