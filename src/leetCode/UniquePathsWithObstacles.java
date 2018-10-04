package leetCode;
/*
   有障碍
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {

    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;
        int[][] dp = new int[m][n];
        int i, j;
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        //当前为障碍或者则取dp[i-1][0]的值(若之前已经出现过障碍,则dp[i-1][0]也为0)
        for (i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i-1][0];
        }
        //同上
        for (j = 1; j < n; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j-1];
        }
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
