package 动态规划.记忆化搜索.石子游戏2;

public class Solution {

    //不同的i应该对应不同的M，我一开始没区分M，导致提前结束了，答案出错。
    int[][] memo; int[] sum;
    public int stoneGameII(int[] piles) {
        // 这个piles.length * 2代表的是M的取值范围，我给定的是一个一定包括M范围的范围。
        this.memo = new int[piles.length+1][piles.length*2];
        this.sum = new int[piles.length+1];
        //初始化前缀和,前缀和的作用是更好的进行计算。
        for(int i = 0; i < piles.length; i++) {
            if (i == 0) sum[i + 1] = piles[i];
            else sum[i + 1] = sum[i] + piles[i];
        }
        return dp(piles, 1, 1);
    }

    //定义为当前选手此状态下，能拿到的最多的石头量
    public int dp(int[] piles, int i, int M) {

        //记忆化递归
        if(memo[i][M] != 0)
            return memo[i][M];

        //中止条件:我后面的石头可以全拿了，那我当然全都要了
        if(i + 2*M > piles.length) {
            memo[i][M] = sum[piles.length] - sum[i-1];
            return memo[i][M];
        }

        int max = 0;
        // 遍历当前的选择，可以选择1<=X<=2M堆的石子
        for(int j = i; j < i+2*M; j++) {
            //当前选择下的石头数量 = i以后的石头总量-下一轮对手最佳角色下的石头量
            int next = dp(piles, j+1, Math.max(M, j+1-i));
            max = Math.max(max, sum[piles.length] - sum[i-1] - next);
        }
        //记录答案
        memo[i][M] = max;
        return memo[i][M];
    }
}
