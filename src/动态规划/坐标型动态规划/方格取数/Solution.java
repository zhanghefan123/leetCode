package 动态规划.坐标型动态规划.方格取数;

import java.util.*;
public class Solution {

    public static int[][] matrix;

    public static int[][][] dp;

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        matrix = new int[N+1][N+1];
        // k最大为2*(N-1),最小为0,所以需要声明2N-1个。
        // i最大为N-1,最小为0,所以需要声明N个
        // j最大为N-1,最小为0,所以需要声明N个
        dp = new int[2*N+1][N+1][N+1];
        while(true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int value = sc.nextInt();
            if(x == 0 && y == 0 && value == 0)
            {
                break;
            }
            else
            {
                matrix[x][y] = value;
            }
        }
        // 开始进行动态规划
        // 首先遍历k(从0到2*N-2步)
        for(int k = 2; k <= (2*N); k++)
        {
            for(int i1 = 1;i1 <= N; i1++)
            {
                for(int i2 = 1;i2 <= N;i2++)
                {
                    int j1 = k - i1;
                    int j2 = k - i2;
                    if(j1>=1&&j1<=N&&j2>=1&&j2<=N)
                    {
                        int t;
                        // 说明不重合
                        if(i1!=i2)
                        {
                            t = matrix[i1][j1] + matrix[i2][j2];
                        }
                        // 说明重合
                        else {
                            t = matrix[i1][j1];
                        }
                        // 讨论四种情况
                        int res = Integer.MIN_VALUE;
                        res = Math.max(res,dp[k-1][i1-1][i2-1] + t);
                        res = Math.max(res, dp[k-1][i1-1][i2] + t);
                        res = Math.max(res, dp[k-1][i1][i2-1] + t);
                        res = Math.max(res, dp[k-1][i1][i2] + t);
                        dp[k][i1][i2] = res;
                    }
                }
            }
        }
        System.out.println(dp[2*N][N][N]);

    }
}