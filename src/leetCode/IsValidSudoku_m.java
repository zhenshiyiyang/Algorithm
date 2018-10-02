package leetCode;

import java.util.HashSet;
/*每一个小九宫格（互不交叉，总共九个小九宫格）必须是数字1~9且不重复
依次检查每行，每列，每个子九宫格是否出现重复元素，如果出现返回false，否则返回true.
难点在于表示第i个九宫格每个格点的坐标。
观察行号规律：
第0个九宫格：000111222; 第1个九宫格：000111222; 第2个九宫格：000111222;
第3个九宫格：333444555; 第4个九宫格：333444555; 第5个九宫格：333444555;
第6个九宫格：666777888; 第7个九宫格：666777888; 第8个九宫格：666777888;
可见对于每三个九宫格行号增3；对于单个九宫格，每三个格点行号增1。
因此第i个九宫格的第j个格点的行号可表示为i/3*3+j/3（每个小九宫格j都是从0~9递增）
观察列号规律：
第0个九宫格：012012012; 第1个九宫格：345345345; 第2个九宫格：678678678;
第3个九宫格：012012012; 第4个九宫格：345345345; 第5个九宫格：678678678;
第6个九宫格：012012012; 第7个九宫格：345345345; 第8个九宫格：678678678;
可见对于下个九宫格列号增3，循环周期为3；对于单个九宫格，每个格点行号增1，周期也为3。
周期的数学表示就是取模运算mod。
因此第i个九宫格的第j个格点的列号可表示为i%3*3+j%3（每个小九宫格j都是从0~9递增）
 */
public class IsValidSudoku_m {
    public static void main(String[] args) {

    }
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                // 检查第i行，在横坐标位置
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                // 检查第i列，在纵坐标位置
                if (board[j][i] != '.' && !column.add(board[j][i]))
                    return false;
                // 行号+偏移量
                int RowIndex = 3 * (i / 3) + j / 3;
                // 列号+偏移量
                int ColIndex = 3 * (i % 3) + j % 3;
                //每个小九宫格，总共9个
                if (board[RowIndex][ColIndex] != '.'
                        && !cube.add(board[RowIndex][ColIndex]))
                    return false;
            }
        }
        return true;
    }

}
