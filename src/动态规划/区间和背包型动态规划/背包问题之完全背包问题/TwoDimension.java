package 动态规划.区间和背包型动态规划.背包问题之完全背包问题;
//题目
import java.util.*;
public class TwoDimension {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 物品的个数
        int N = sc.nextInt();
        // 背包的容量
        int V = sc.nextInt();
        // 开始进行读取物品的体积和价值
        int [] volume_of_item = new int[N];
        int [] price_of_item = new int[N];
        for(int i = 0;i < N; i++)
        {
            volume_of_item[i] = sc.nextInt();
            price_of_item[i] = sc.nextInt();
        }
        // 进行dp数组的创建
        int[][] dp = new int[N+1][V+1];
        for(int i = 1; i <= N; i++)
        {
            for(int j = 0;j <= V; j++)
            {
                // 开始进行遍历
                int counts_of_item = 0;
                while(j - counts_of_item * volume_of_item[i-1] >= 0)
                {
                    dp[i][j] = Math.max(dp[i-1][j - counts_of_item * volume_of_item[i-1]] + counts_of_item * price_of_item[i-1], dp[i][j]);
                    counts_of_item++;
                }
            }
        }
        System.out.println(dp[N][V]);
    }
}
