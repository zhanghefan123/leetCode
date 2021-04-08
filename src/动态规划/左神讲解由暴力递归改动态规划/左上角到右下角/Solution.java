package 动态规划.左神讲解由暴力递归改动态规划.左上角到右下角;
// 题目
// 给你一个数组，二维数组中每个数都是整数，要求从左上角走到右下角
// 每一步只能向右或者向下，沿途经过的数字要累加起来，返回最小的路径和

// 什么样的递归问题可以改成动态规划问题
// 当递归展开的过程之中我们一旦发现有重复的状态，而且状态
// 与到达它的路径是无关的，这称之为无后效性问题，总结来说就是固定可变参数之后返回值固定
// 这样的问题可以改成动态规划

// 什么样的递归问题不可以改成动态规划问题
// 有后效性问题，就是之前的路径会影响结果，比如N皇后问题。


public class Solution {

    // 解决方案1
    public static int minPath1(int[][] matrix) {
        return process1(matrix, 0, 0);
    }

    // 这个递归的复杂度非常高。
    // 计算了重复的子问题--这就是暴力递归不行的原因
    public static int process1(int[][] matrix, int i, int j) {
        // 原问题划分到这个问题就不需要划分了
        if (i == matrix.length-1 && j == matrix[0].length-1) {
            return matrix[i][j];
        }
        // 最后一行只能够向右走
        if (i == matrix.length-1) {
            return matrix[i][j] + process1(matrix, i, j + 1);
        }
        // 走到最后一列只能够向下走
        if (j == matrix[0].length-1) {
            return matrix[i][j] + process1(matrix, i - 1, j);
        }
        // 若在中间的情况。
        return matrix[i][j] + Math.min(process1(matrix, i, j + 1), process1(matrix, i + 1, j));
    }

    // 改成动态规划
    // 计算子问题，利用子问题解决大问题，这样就不会计算重复子问题，使用空间换时间
    public static int minPath2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));

        m = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }
}
