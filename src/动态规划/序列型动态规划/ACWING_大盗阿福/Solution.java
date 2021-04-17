package 动态规划.序列型动态规划.ACWING_大盗阿福;

import java.util.Scanner;

public class Solution{
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while((T--)!=0)
            {
                int shops_count = sc.nextInt();
                int [] array = new int[shops_count];
                for(int i = 0;i < shops_count;i++)
                {
                    array[i] = sc.nextInt();
                }
                // 进行dp矩阵的创建
                int[][] dp = new int[shops_count+1][2];
                // 进行base_case的搭建
                // 考虑前0家店铺,所得的钱为0
                dp[0][0] = 0;
                // 考虑前0家店铺，状态为1是不可能的
                dp[0][1] = Integer.MIN_VALUE;
                for(int i = 1;i <= shops_count; i++)
                {
                    for(int j = 0;j<=1;j++)
                    {
                        // 如果当前抵达的是0状态，那么可能是从0状态而来
                        // 也可能是从1状态而来
                        if(j == 0)
                        {
                            dp[i][j] = Math.max(dp[i-1][0],dp[i-1][1]);
                        }
                        // 如果当前第大的是1状态，那么只有可能从0状态来
                        else
                        {
                            dp[i][j] = dp[i-1][0] + array[i-1];
                        }
                    }
                }
                // 现在考虑所有的店铺，看最大收益是多少
                System.out.println(Math.max(dp[shops_count][0],dp[shops_count][1]));
            }
        }
}
