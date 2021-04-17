package 动态规划.区间和背包型动态规划.区间型动态规划.石子合并;

import java.util.*;
public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n+1];
        int[] prefix_sum = new int[n+1];
        for(int i = 1; i < array.length; i++)
        {
            array[i] = sc.nextInt();
            prefix_sum[i] = prefix_sum[i-1] + array[i];
        }
        int[][] dp = new int[n+1][n+1];
        // 遍历区间的长度
        for(int length = 1;length <= n;length++)
        {
            // 遍历区间的左端点
            for(int left = 1;left <= n; left++)
            {
                int right = left + length - 1;
                if(right > n)
                {
                    continue;
                }
                else if(length == 1)
                {
                    dp[left][right] = 0;
                }
                else
                {
                    dp[left][right] = Integer.MAX_VALUE;
                    // 遍历第一段的结尾的地点
                    for(int split = left;split < right;split++)
                    {
                        dp[left][right] = Math.min(dp[left][right],dp[left][split] + dp[split + 1][right] + prefix_sum[right] - prefix_sum[left - 1]);
                    }
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
