package 动态规划.最长序列型动态规划.最长公共子序列;

import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 第一个字符串的长度
        int N = sc.nextInt();
        // 第二个字符串的长度
        int M = sc.nextInt();
        // 读掉多余的回车
        sc.nextLine();
        // 第一个字符串
        char[] first_array = sc.nextLine().toCharArray();
        // 第二个字符串
        char[] second_array = sc.nextLine().toCharArray();
        // 创建dp数组
        int[][] dp = new int[N+1][M+1];
        // 进行dp数组的填充
        for(int i = 1; i <= N;i++)
        {
            for(int j = 1; j <= M; j++)
            {
                dp[i][j] = 0;
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                if(first_array[i-1] == second_array[j-1])
                {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }
        // 输出最终结果
        System.out.println(dp[N][M]);
    }
}
