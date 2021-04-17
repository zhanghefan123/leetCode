package 动态规划.序列型动态规划.ACWING_股票买卖_IV;

import java.util.*;
class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 存放着N天的股票价格
        int N = sc.nextInt();
        // 存放着K，最多能够进行K次交易
        int K = sc.nextInt();
        // 创建一个数组用来进行股票价格的存放
        int[] array = new int[N+1];
        for(int i = 1;i <= N;i++){
            array[i] = sc.nextInt();
        }
        // 然后开始进行dp
        int[][][] dp = new int[N + 1][K + 1][2];
        for(int i = 0; i < N+1;i++)
        {
            for(int j = 0;j < K+1; j++)
            {
                for(int state = 0;state < 2;state++)
                {
                    dp[i][j][state] = Integer.MIN_VALUE;
                }
            }
        }
        // 如果dp[i][0][0]必定为0,因为经过了0次交易，处于状态0，必定是没有赚钱
        for(int i = 0; i < N+1;i++)
        {
            dp[i][0][0] = 0;
        }

        for(int i = 1;i <= N; i++)
        {
            for(int j = 1;j <= K; j++)
            {
                for(int state = 0;state <=1;state++)
                {
                    if(state == 0)
                    {
                        if(dp[i-1][j][1]!=Integer.MIN_VALUE)
                        {
                            dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + array[i]);
                        }
                        else
                        {
                            dp[i][j][0] = dp[i-1][j][0];
                        }
                    }
                    else
                    {
                        if(dp[i-1][j-1][0]!=Integer.MIN_VALUE)
                        {
                            dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - array[i]);
                        }
                        else
                        {
                            dp[i][j][1] = dp[i-1][j][1];
                        }
                    }
                }
            }
        }
        int res = 0;
        // 进行交易次数的枚举
        for(int i = 0; i <= K; i++)
        {
            res = Math.max(res,dp[N][i][0]);
        }
        System.out.println(res);
    }
}