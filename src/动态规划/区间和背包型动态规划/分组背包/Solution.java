package 动态规划.区间和背包型动态规划.分组背包;

import java.util.*;
public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 总共存在N组物品
        int N = sc.nextInt();
        // 容量是V的背包
        int V = sc.nextInt();
        // 记录每组有多少个元素的数组
        int[] s = new int[N];
        // 因为Si<=100所以定义为101
        // 记录价值
        int[][] price = new int[110][110];
        // 记录体积
        int[][] volume = new int[110][110];
        // 开始进行数组的填充
        for(int i = 0; i < N; i++)
        {
            s[i] = sc.nextInt();
            for(int j = 0; j  < s[i]; j++)
            {
                volume[i][j] = sc.nextInt();
                price[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[N+1][V+1];
        for(int i = 1; i <=N ; i++)
        {
            for(int j = 0; j <= V;j++)
            {
                // 遍历选择数的情况
                // 一个都不选
                dp[i][j] = dp[i-1][j];
                // 遍历每一个数的选择
                for(int x = 0; x < s[i-1]; x++)
                {
                    if(j>=volume[i-1][x])
                    {
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-volume[i-1][x]]+price[i-1][x]);
                    }
                }
            }
        }
        System.out.println(dp[N][V]);
    }
}
