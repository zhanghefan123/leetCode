package 前缀和.子矩阵的和;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }
        // 进行前缀和的计算
        int[][] prefix_sum = new int[m][n];
        // 首先进行第一行的初始化
        prefix_sum[0][0] = matrix[0][0];
        for(int i = 1;i < n;i++)
        {
            prefix_sum[0][i] = prefix_sum[0][i-1] + matrix[0][i];
        }
        // 然后进行第一列的初始化
        for(int i = 1;i < m;i++)
        {
            prefix_sum[i][0] = prefix_sum[i-1][0] + matrix[i][0];
        }
        // 然后进行其余位置的初始化操作
        /*

         ***
         ***
         ***

         */
        for(int i = 1; i < m;i++)
        {
            for(int j = 1;j<n;j++)
            {
                prefix_sum[i][j] = prefix_sum[i-1][j] + prefix_sum[i][j-1] - prefix_sum[i-1][j-1] + matrix[i][j];
            }
        }
        for(int i = 0;i < q;i++)
        {
            int x1 = sc.nextInt()-1;
            int y1 = sc.nextInt()-1;
            int x2 = sc.nextInt()-1;
            int y2 = sc.nextInt()-1;
            if(x1 == 0 && y1 != 0)
            {
                int res = prefix_sum[x2][y2] - prefix_sum[x2][y1-1];
                System.out.println(res);
            }
            else if(x1 == 0)
            {
                int res = prefix_sum[x2][y2];
                System.out.println(res);
            }
            else if(y1 == 0)
            {
                int res = prefix_sum[x2][y2] - prefix_sum[x1-1][y2];
                System.out.println(res);
            }
            else
            {
                int res = prefix_sum[x2][y2] - prefix_sum[x1-1][y2] - prefix_sum[x2][y1-1] + prefix_sum[x1-1][y1-1];
                System.out.println(res);
            }

        }
    }
}
