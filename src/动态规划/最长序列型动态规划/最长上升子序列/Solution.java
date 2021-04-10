package 动态规划.最长序列型动态规划.最长上升子序列;

import java.util.*;
public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 元素个数
        int N = sc.nextInt();
        // 创建数组
        int[] array = new int[N];
        for(int i = 0;i < N;i++)
        {
            array[i] = sc.nextInt();
        }
        // 最终结果
        int final_res = Integer.MIN_VALUE;

        // 开始进行状态定义
        int[] dp = new int[N];
        for(int i = 0; i < N; i++)
        {
            int res = 1;
            for(int j = i;j>=0;j--)
            {
                if(array[i] > array[j])
                {
                    res = Math.max(res,dp[j] + 1);
                }
            }
            dp[i] = res;
            final_res = Math.max(final_res, res);
        }
        System.out.println(final_res);
    }
}
