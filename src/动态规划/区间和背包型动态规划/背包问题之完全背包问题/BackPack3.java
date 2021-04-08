package 动态规划.区间和背包型动态规划.背包问题之完全背包问题;
//题目
/*
 * 给定N个物品，重量分别为A0 --- AN-1
 * 价值分别为V0 --- VN-1
 * 每种物品存在无穷多个。
 * 一个背包最大承重是正整数M
 * 最多能带走多大价值的物品。
* */

//最值型背包

//状态转移方程
/*
  状态
* f[i][w] = 使用前i种物品拼出重量w时候的最大总价值
*
* 方程
  f[i][w] = max(k>=0){f[i-1][w-kAi-1] + kVi-1}
  解析--使用前i种物品拼出重量w时最大总价值 = 使用前i-1种物品
  拼出重量w-kAi-1时的最大总价值+k个第i种物品。k需要进行枚举
*
* */
public class BackPack3 {
    public int backPackIII(int m,int[] A,int[] V)
    {
        int n = A.length;
        if(n == 0)
        {
            return 0;
        }
        int[][] f= new int[n+1][m+1];
        int i,w;
        f[0][0] = 0;
        for(i = 1;i <= m;i++)
        {
            f[0][i] = -1;
        }

        for(i=1;i<=n;i++)
        {
            for(w=0;w<=m;w++)
            {

                f[i][w] = f[i-1][w];

                // 与BackPack2只有f[i-1]变成了f[i]
                if(w>=A[i-1] && f[i][w-A[i-1]]!=-1)
                {
                    f[i][w] = Math.max(f[i][w],f[i-1][w-A[i-1]]+V[i-1]);
                }
            }
        }
        int res = 0;
        for(w=0;w<=m;w++)
        {
            if (f[n][w]!=-1) {
                res = Math.max(res,f[n][w]);
            }
        }
        return res;
    }
}
