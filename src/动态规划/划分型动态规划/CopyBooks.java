package 动态规划.划分型动态规划;

public class CopyBooks {
    public int copyBooks(int[]A,int K)
    {
        int n  = A.length;
        if(n==0)
        {
            return 0;
        }
        if(K > n)
        {
            K = n;
        }

        int [][] helper = new int[K+1][n+1];
        int i,j,k;
        helper[0][0] = 0;
        for(i = 1;i<=n;i++)
        {
            helper[0][i] = Integer.MAX_VALUE;
        }
        for(k=1;k<=K;k++)
        {
            helper[k][0] = 0;
            for(i=1;i<=n;i++) {
                helper[k][i] = Integer.MAX_VALUE;
                int sum = 0;
                for (j = i; j >= 0; --j) {
                    helper[k][i] = Math.min(helper[k][i], Math.max(helper[k - 1][j], sum));
                    if (j > 0) {
                        sum += A[j - i];
                    }
                }
            }
        }
        return helper[k][n];
    }
}
