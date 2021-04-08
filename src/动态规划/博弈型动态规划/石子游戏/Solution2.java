package 动态规划.博弈型动态规划.石子游戏;

public class Solution2 {
    public int[] piles;

    public int[][] dp;

    // 利用记忆化搜索来解决
    public boolean stoneGame(int[] piles) {
        this.piles = piles;
        this.dp = new int[this.piles.length][this.piles.length];
        if(dfs(0,piles.length-1) > 0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    // 面对i~j的情况
    public int dfs(int i,int j)
    {
        if(i == j)
        {
            return piles[i];
        }
        else if(this.dp[i][j] != 0)
        {
            return dp[i][j];
        }
        else{
            int res = Math.max(this.piles[i] - dfs(i+1,j),this.piles[j] - dfs(i,j-1));
            dp[i][j] = res;
            return res;
        }
    }
}
