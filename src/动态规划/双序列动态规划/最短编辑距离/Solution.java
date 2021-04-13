package 动态规划.双序列动态规划.最短编辑距离;

import java.util.*;
public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int first_sequence_length = sc.nextInt();
        sc.nextLine();
        char[] first_sequence = sc.nextLine().toCharArray();
        int second_sequence_length = sc.nextInt();
        sc.nextLine();
        char[] second_sequence = sc.nextLine().toCharArray();
        int [][] dp = new int[first_sequence_length+1][second_sequence_length+1];
        for(int i = 0; i <= first_sequence_length;i++)
        {
            dp[i][0] = i;
        }
        for(int i = 0;i <= second_sequence_length; i++)
        {
            dp[0][i] = i;
        }
        // 然后进行其余位置的dp填充
        for(int i = 1;i <= first_sequence_length;i++)
        {
            for(int j = 1; j <= second_sequence_length;j++)
            {
                dp[i][j] = Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                if(first_sequence[i-1]!=second_sequence[j-1])
                {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + 1);
                }
                else
                {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                }
            }
        }
        System.out.println(dp[first_sequence_length][second_sequence_length]);
    }
}