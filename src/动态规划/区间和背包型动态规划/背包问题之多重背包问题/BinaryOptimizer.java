package 动态规划.区间和背包型动态规划.背包问题之多重背包问题;

import java.util.*;
public class BinaryOptimizer {

    public static ArrayList<Integer> items_price = new ArrayList<>();

    public static ArrayList<Integer> items_volume = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 总共存在N种物品
        int N = sc.nextInt();
        // 背包总容量为V
        int V = sc.nextInt();
        // 开始读入每一种物品的体积，价值，数量
        for(int i = 0; i < N; i++)
        {
            int volume = sc.nextInt();
            int price = sc.nextInt();
            int count = sc.nextInt();
            // 将这种物品进行分割成为多个物品
            split(volume,price,count);
        }
        // 创建dp矩阵
        int[] dp = new int[V+1];
        // 遍历所有的物品
        for(int i = 1; i <= items_price.size(); i++)
        {
            // 在确定某一种物品的情况下，找到每个体积所能包含的最大价值。
            for(int v = V; v>=items_volume.get(i-1);v--)
            {
                dp[v] = Math.max(dp[v],dp[v-items_volume.get(i-1)] + items_price.get(i-1));
            }
        }
        System.out.println(dp[V]);
    }

    public static void split(int volume,int price,int count) {
        // 将物品按照二进制进行分割
        int k = 1;
        while(k<=count)
        {
            items_volume.add(volume * k);
            items_price.add(price * k);
            count -= k;
            k *= 2;
        }
        // 将剩余的数量进行补上
        if(count > 0)
        {
            items_volume.add(volume * count);
            items_price.add(price * count);
        }
    }
}