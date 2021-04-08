package 动态规划.划分型动态规划;

public class NumSquares {
    public int numSquares(int n) {
        // helper[i] 表示组成i的最小的完全平方数个数
        int[] helper = new int[n+1];
        // 初始条件,0需要0个最小的完全平方数组成
        helper[0] = 0;
        // 循环从左向右计算辅助数组
        int res;
        for(int i = 1; i<=n ;i++)
        {
            res = Integer.MAX_VALUE;
            // 枚举最后一个数
            for(int j = 1;j*j <= i;j++)
            {
                res = Integer.min(res,helper[i-j*j]+1);
            }
            helper[i] = res;
        }
        return helper[n];
    }
}
