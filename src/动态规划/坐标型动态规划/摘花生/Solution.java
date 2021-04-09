package 动态规划.坐标型动态规划.摘花生;

import java.util.*;
public class Solution {

    public static int[][] matrix;

    public static int[][] dp;

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while((count--)!=0)
        {
            // 进行多少行多少列的读取
            int m = sc.nextInt();
            int n = sc.nextInt();
            // 进行matrix矩阵的创建
            matrix = new int[m][n];
            dp = new int[m][n];
            // 开始进行数据的读取
            for(int i = 0;i < m; i++)
            {
                for(int j = 0;j<n ;j++)
                {
                    matrix[i][j] = sc.nextInt();
                }
            }
            // 开始进行dp动态规划
            // 首先进行第一行第一列的初始化
            dp[0][0] = matrix[0][0];
            // 进行第一列的初始化
            for(int i = 1; i < m; i++)
            {
                dp[i][0] = dp[i-1][0] + matrix[i][0];
            }
            // 进行第一行的初始化
            for(int i = 1;i < n; i++)
            {
                dp[0][i] = dp[0][i-1] + matrix[0][i];
            }
            // 进行内部dp矩阵的初始化
            for(int i = 1; i < m; i++)
            {
                for(int j = 1; j < n; j++)
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + matrix[i][j];
                }
            }
            // 输出到达右下角的值
            System.out.println(dp[m-1][n-1]);
        }
    }
}
