package leetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>(50);

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        // 只有一行的情况
        if (matrix.length == 1) {
            for (int i : matrix[0]) {
                result.add(i);
            }

            return result;
        }

        // 只有一列的情况
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                result.add(matrix[i][0]);
            }

            return result;
        }

        // 计算有多少圈
        int row = matrix.length;
        int col = matrix[0].length;
        int cycle = row < col ? row : col;
        cycle = (cycle + 1) / 2;

        int round = 0; // 记录当前是第几圈
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int down = matrix.length - 1;
        int total = col*row;
        int count = 0;
        while (round < cycle) {

            // 上面一行
            for (int i = left; i <= right && count < total; i++) {
                count++;
                result.add(matrix[round][i]);
            }
            top++; //

            // 右边一列
            for (int i = top; i <= down && count < total; i++) {
                count++;
                result.add(matrix[i][col - round - 1]);
            }
            right--;

            // 底下一行
            for (int i = right; i >= left && count < total; i--) {
                count++;
                result.add(matrix[row - round - 1][i]);

            }
            down--;

            // 左边一列
            for (int i = down; i >= top && count < total; i--) {
                count++;
                result.add(matrix[i][round]);
            }
            left++;

            round++;
        }

        return result;
    }
}
