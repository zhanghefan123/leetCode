package 动态规划.序列型动态规划.粉刷房子2;
// 记忆化搜索思路
public class Solution {
    public int[][] costs;

    public int[][] dp;

    public int minCostII(int[][] costs) {
        this.costs = costs;
        this.dp = new int[costs.length][costs[0].length];
        int res = Integer.MAX_VALUE;
        for(int i = 0;i<costs[0].length;i++)
        {
            res = Math.min(res,dfs(0,i));
        }
        return res;
    }

    // 当前正在涂色的房子的索引为i,要涂的颜色为color
    // 这个函数的返回值是将索引i房子涂为color颜色,并且为i后面的房子涂色的最小花费
    // 递归函数之中存在多少个参数，相应的记忆化搜索就应该是多少维
    public int dfs(int i,int color)
    {
        if(dp[i][color] != 0)
        {
            return dp[i][color];
        }
        // 先记录当前涂索引i房子的花费
        int current_cost = costs[i][color];
        // 如果当前已经来到了最后一栋房子
        if(i == this.costs.length - 1)
        {
            dp[i][color] = current_cost;
            return current_cost;
        }
        else
        {
            // 遍历所有的下一栋房子的颜色
            int res = Integer.MAX_VALUE;
            for(int c = 0;c < costs[0].length;c++)
            {
                if(c != color)
                {
                    res = Math.min(res,dfs(i+1,c));
                }
            }
            dp[i][color] = current_cost + res;
            return current_cost + res;
        }
    }
}
