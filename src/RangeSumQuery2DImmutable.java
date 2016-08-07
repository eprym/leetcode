public class NumMatrix {

    int[][] dp, rowSum, colSum;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return;
        dp = new int[matrix.length][matrix[0].length];
        rowSum = new int[matrix.length][matrix[0].length];
        colSum = new int[matrix.length][matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++) {
            rowSum[i][0] = matrix[i][0];
            for(int j = 1; j < matrix[0].length; j++) {
                rowSum[i][j] += rowSum[i][j-1] + matrix[i][j];
            }
        }
        
        for(int i = 0; i < matrix[0].length; i++) {
            colSum[0][i] = matrix[0][i];
            for(int j = 1; j < matrix.length; j++) {
                colSum[j][i] += colSum[j-1][i] + matrix[j][i];
            }
        }
        
        dp[0][0] = matrix[0][0];
        for(int i = 1; i < matrix.length; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for(int j = 1; j < matrix[0].length; j++) {
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = dp[i-1][j-1] + rowSum[i][j] + colSum[i][j] - matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = dp[row2][col2];
        if(row1 > 0)    res -= dp[row1-1][col2];
        if(col1 > 0)    res -= dp[row2][col1-1];
        if(row1 > 0 && col1 > 0)    res += dp[row1-1][col1-1];
        return res;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
