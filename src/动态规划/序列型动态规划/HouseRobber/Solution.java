package 动态规划.序列型动态规划.HouseRobber;

// 记忆化搜索的思路
public class Solution {
    public int[] nums;

    public int[][] dp;

    public int rob(int[] nums) {

        this.nums = nums;
        this.dp = new int[nums.length][2];
        return Math.max(dfs(0,0),dfs(0,1));
    }

    // steal代表i-1位置的偷与不偷
    // dfs代表从i位置开始偷盗到末尾能获得的最大收益。
    public int dfs(int i,int steal)
    {
        if(this.dp[i][steal] != 0)
        {
            return dp[i][steal];
        }
        else if(i == (nums.length-1))
        {
            // 如果i-1位置没有进行偷窃
            if(steal == 0)
            {
                dp[i][steal] = nums[i];
                return dp[i][steal];
            }
            else{
                dp[i][steal] = 0;
                return dp[i][steal];
            }
        }
        else{
            // 如果i-1位置没有进行偷窃
            // 则i位置可以选择偷与不偷
            if(steal == 0)
            {
                int res = Integer.MIN_VALUE;
                int steal_res = nums[i] + dfs(i+1,1);
                res = Math.max(res,steal_res);
                int not_steal_res = dfs(i+1,0);
                res = Math.max(res,not_steal_res);
                dp[i][steal] = res;
                return dp[i][steal];
            }
            // 如果i-1位置进行了偷窃则之能不偷
            else{
                dp[i][steal] = dfs(i+1,0);
                return dp[i][steal];
            }
        }

    }
}
