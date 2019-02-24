public class MatrixMinPath {
    public int minPath(int[][] m){
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int [row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + m[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + m[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
