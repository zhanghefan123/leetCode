package 动态规划.动态规划入门.计数类型.整数划分;

import java.util.Scanner;

public class Solution {
    public static void main(String [] args)
    {
        int mod = 1000000007;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // dp[i][j]表示只考虑前i个数，恰好凑出j的情况数
        int[][] dp = new int[n+1][n+1];
        // 只考虑前1个数恰好拼凑出j的情况为全1
        for(int i = 1; i <= n;i++)
        {
            dp[1][i] = 1;
        }
        // 考虑前任何个数恰好拼凑出j的情况全1
        for(int i = 0; i <=n; i++)
        {
            dp[i][0] = 1;
        }
        // 考虑前i个物品
        for(int i = 2;i<=n;i++)
        {
            // 考虑所有的体积
            for(int v = 0;v<=n;v++)
            {
                dp[i][v] = dp[i-1][v];
                int count = 1;
                while(v>=count * i)
                {
                    dp[i][v] = (dp[i][v] + dp[i-1][v-count * i]) % mod  ;
                    count++;
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
