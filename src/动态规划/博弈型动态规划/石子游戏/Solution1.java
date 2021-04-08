package 动态规划.博弈型动态规划.石子游戏;

public class Solution1 {
    public int[][] dp;
    public boolean stoneGame(int[] piles) {

        // step1 创建dp矩阵
        int length = piles.length;

        dp = new int[length][length];

        // step2 进行主对角线base_case的填充
        for(int i = 0; i < length;i++)
        {
            dp[i][i] = piles[i];
        }

        // step3 进行右上三角矩阵的填充
        for(int i = length - 2; i >= 0; i--)
        {
            for(int j = i+1; j<length;j++)
            {
                // 其中dp[i+1][j] 是当先手选择piles[i]后手的得分，其中 dp[i][j-1]是当先手选择piles[j]后手的得分
                dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
            }
        }

        return dp[0][length-1] > 0;
    }
}
