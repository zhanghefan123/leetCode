package 动态规划.区间和背包型动态规划.区间型动态规划.石子合并;

import java.util.*;
public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // N堆石子
        int N = sc.nextInt();
        // 存储石子堆的数量
        int[] array = new int[N];
        // 前缀和
        int[] prefix_sum = new int[N+1];
        for(int i = 0;i < N; i++)
        {
            array[i] = sc.nextInt();
            prefix_sum[i+1] = prefix_sum[i] + array[i];
        }
        // 创建dp数组
        int[][] dp = new int[N][N];
        // 枚举所有的长度
        for(int len = 1; len <= N; len++)
        {
            // 枚举起点
            for(int start = 0;start < N; start++)
            {
                int end = start + len - 1;
                if(end >= N)
                {
                    continue;
                }
                // 合并一堆石子是不需要代价的
                if(len == 1)
                {
                    dp[start][end] = 0;
                }
                else if(len == 2)
                {
                    dp[start][end] = array[start] + array[end];
                }
                else
                {
                    dp[start][end] = Integer.MAX_VALUE;
                    for(int k = start; k < end;k++)
                    {
                        dp[start][end] = Math.min(dp[start][end],dp[start][k] + dp[k+1][end] + prefix_sum[end + 1] - prefix_sum[start]);
                    }
                }

            }
        }
        System.out.println(dp[0][N-1]);
    }
}
