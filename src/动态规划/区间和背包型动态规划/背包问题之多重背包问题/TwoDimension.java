package 动态规划.区间和背包型动态规划.背包问题之多重背包问题;

import java.util.*;
public class TwoDimension {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 物品的种类
        int kinds = sc.nextInt();
        // 背包的容量
        int V = sc.nextInt();
        // 每种物品的体积
        int[] volume_of_each_item = new int[kinds];
        // 每种物品的价值
        int[] price_of_each_item = new int[kinds];
        // 每种物品的数量
        int[] count_of_each_item = new int[kinds];
        // 开始进行循环遍历
        for(int i = 0;i < kinds;i++)
        {
            int volume = sc.nextInt();
            int price = sc.nextInt();
            int count = sc.nextInt();
            volume_of_each_item[i] = volume;
            price_of_each_item[i] = price;
            count_of_each_item[i] = count;
        }
        // 进行dp数组的创建
        int[][] dp = new int[kinds+1][V+1];

        // 开始进行遍历
        // 依次进行:只考虑前1种物品,前2种物品,……前kinds种物品
        for(int i = 1; i <= kinds; i++)
        {
            for(int v = 0; v <= V; v++)
            {
                // 遍历所有可以选择的数量
                int count = 0;
                while(count <= count_of_each_item[i-1] && count * volume_of_each_item[i-1] <= v)
                {
                    dp[i][v] = Math.max(dp[i][v],dp[i-1][v - count * volume_of_each_item[i-1]] + count * price_of_each_item[i-1]);
                    count++;
                }
            }
        }
        System.out.println(dp[kinds][V]);
        sc.close();
    }
}