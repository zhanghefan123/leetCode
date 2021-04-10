package 动态规划.区间和背包型动态规划.背包问题之01背包问题;
//题目
import java.util.*;
public class TwoDimension {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 物品数量为n
        int n = sc.nextInt();
        // 总共背包容积V
        int V = sc.nextInt();
        // 每个物品的体积
        int[] volume_of_each_item = new int[n];
        // 每个物品的价值
        int[] price_of_each_item = new int[n];
        // 进行数据的读取
        for(int i = 0;i < n;i++)
        {
            volume_of_each_item[i] = sc.nextInt();
            price_of_each_item[i] = sc.nextInt();
        }
        // 进行dp
        // 第一维为考虑前几个物品
        // 第二维维背包的容量
        int[][] dp = new int[n+1][V+1];
        for(int i = 1; i <=n; i++)
        {
            for(int j = 0; j<=V; j++)
            {
                if(j >= volume_of_each_item[i-1])
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-volume_of_each_item[i-1]]+price_of_each_item[i-1]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][V]);
    }
}
