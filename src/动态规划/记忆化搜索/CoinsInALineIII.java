package 动态规划.记忆化搜索;

public class CoinsInALineIII {
    public boolean firstWillWin(int[] A) {
        int n = A.length;
        int[][] f = new int[n][n];
        int i, j, len;
        for (i = 0; i < n; i++) {
            f[i][i] = A[i];
        }
        for (len = 2; len <= n; ++len) {
            for (i = 0; i <= n - len; i++) {
                j = i + len - 1;
                f[i][j] = Math.max(A[i] - f[i + 1][j], A[j] - f[i][j - 1]);
            }
        }
        return f[0][n - 1] >= 0;
    }
}
