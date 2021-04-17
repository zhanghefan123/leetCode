package 动态规划.序列型动态规划.ACWING_股票买卖V;

import java.util.Scanner;

public class Solution {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N+1];
        for(int i = 1; i <= N;i++)
        {
            array[i] = sc.nextInt();
        }
        int[][] dp = new int[N+1][3];
        // base_case的设置
        dp[0][2] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][0] = Integer.MIN_VALUE;
        for(int i = 1;i<=N;i++)
        {
            for(int j = 0;j <=2;j++)
            {
                if(j == 0)
                {
                    // 第一项是保持持有的含义
                    // 第二项是从空仓大于等于2天转移过来
                    dp[i][j] = Math.max(dp[i-1][0],dp[i-1][2] - array[i]);
                }
                else if(j == 1)
                {
                    dp[i][j] = dp[i-1][0] + array[i];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][2],dp[i-1][1]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int state = 1;state < 3;state++)
        {
            res = Math.max(res,dp[N][state]);
        }
        System.out.println(res);
    }
}
