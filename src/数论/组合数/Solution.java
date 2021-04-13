package 数论.组合数;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        int mod = 1000000007;
        Scanner sc = new Scanner(System.in);
        int[][] dp = new int[2001][2001];
        // i进行的是底数的遍历
        for(int i = 0; i <= 2000; i++)
        {
            // j进行的是指数的遍历
            for(int j = 0; j <=i; j++)
            {
                // Ci^0必定为0
                if(j == 0 )
                {
                    dp[i][j] = 1;
                }
                else
                {
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % mod;
                }
            }
        }
        int n = sc.nextInt();
        for(int i = 0; i < n;i++)
        {
            int down = sc.nextInt();
            int up = sc.nextInt();
            System.out.println(dp[down][up]);
        }
    }
}
