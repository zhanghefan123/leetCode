package 动态规划.区间和背包型动态规划.区间型动态规划.环形石子合并;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        // 读取的初始化
        Scanner sc = new Scanner(System.in);
        // 总共n堆石子
        int n = sc.nextInt();
        // 读取每个石子的数量，注意这个时候我们需要创建双倍的数组
        int[] array = new int[2 * n + 1];
        int[] prefix_sum = new int[2 * n + 1];
        for(int i = 1;i <= n;i++)
        {
            int tmp = sc.nextInt();
            array[i] = tmp;
            array[i+n] = tmp;
        }
        // 进行前缀和的计算
        for(int i = 0; i < array.length; i++)
        {
            if(i == 0)
            {
                prefix_sum[i] = 0;
            }
            else
            {
                prefix_sum[i] = prefix_sum[i - 1] + array[i];
            }
        }
        // 创建dp矩阵进行初始化
        int[][] min_cost = new int[2 * n + 1][2 * n + 1];
        int[][] max_cost = new int[2 * n + 1][2 * n + 1];
        for(int i = 0; i < min_cost.length; i++)
        {
            Arrays.fill(min_cost[i],Integer.MAX_VALUE);
            Arrays.fill(max_cost[i],Integer.MIN_VALUE);
        }

        // 开始进行双重循环进行dp矩阵的填充
        // 遍历长度
        for(int length = 1;length <= n; length++)
        {
            // 遍历左端点
            for(int left = 1;left + length - 1 <= 2 * n; left++)
            {
                int right = left + length - 1;
                if(length == 1)
                {
                    min_cost[left][right] = 0;
                    max_cost[left][right] = 0;
                }

                else
                {
                    // 进行所有中间点的遍历
                    for(int split = left;split < right;split ++)
                    {
                        // 计算左侧的和
                        if(left > 1)
                        {
                            min_cost[left][right] = Math.min(min_cost[left][right], min_cost[left][split] + min_cost[split + 1][right] + prefix_sum[right] - prefix_sum[left - 1]);
                            max_cost[left][right] = Math.max(max_cost[left][right], max_cost[left][split] + max_cost[split + 1][right] + prefix_sum[right] - prefix_sum[left - 1]);
                        }
                        else
                        {
                            min_cost[left][right] = Math.min(min_cost[left][right], min_cost[left][split] + min_cost[split + 1][right] + prefix_sum[right]);
                            max_cost[left][right] = Math.max(max_cost[left][right], max_cost[left][split] + max_cost[split + 1][right] + prefix_sum[right]);
                        }
                    }
                }
            }
        }

        // 开始进行最终结果的查询
        // 枚举所有长度为i的
        int max_cost_of_merge = Integer.MIN_VALUE;
        int min_cost_of_merge = Integer.MAX_VALUE;
        for(int left = 1;left <= n; left++)
        {
            int right = left + n - 1;
            max_cost_of_merge = Math.max(max_cost_of_merge, max_cost[left][right]);
            min_cost_of_merge = Math.min(min_cost_of_merge, min_cost[left][right]);
        }
        System.out.println(min_cost_of_merge);
        System.out.println(max_cost_of_merge);
    }
}
