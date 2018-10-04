package leetCode;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(uniquePaths(m,n));
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        dp[0][0]=1;
        for(int i=1;i<m;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++)
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
        }
        return dp[n-1][m-1];
    }
}
