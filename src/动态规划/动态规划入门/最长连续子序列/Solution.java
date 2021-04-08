package 动态规划.动态规划入门.最长连续子序列;

public class Solution {
    public int maxProduct(int[] A)
    {
        int n = A.length;
        if(n == 0)
        {
            return 0;
        }
        // f数组的每个状态的定义是,以f[i]结尾的连续子序列的最大乘积
        int [] f = new int[n];
        // g数组的每个状态的定义是，以g[i]结尾的连续子序列的最小乘积
        int [] g = new int[n];
        int i,j;
        int res = Integer.MIN_VALUE;
        for(i = 0;i<n;i++)
        {
            f[i] = A[i];
            // 先进行f[i]的计算
            if(i > 0)
            {
                f[i] = Math.max(f[i],Math.max(A[i] * f[i-1],A[i] * g[i-1]));
            }
            // 然后进行g[i]的计算
            g[i] = A[i];
            if(i > 0)
            {
                g[i] = Math.min(f[i],Math.min(A[i] * f[i-1],A[i] * g[i-1]));
            }
            res = Math.max(res,f[i]);
        }
        return res;

    }
}
