package 动态规划.双序列动态规划;

public class DistinctSubsequences {
    public int numDistinct(String S,String T)
    {
        char[] s1 = S.toCharArray();
        char[] s2 = T.toCharArray();
        int i,j;
        int m = s1.length;
        int n = s2.length;
        int [][] f = new int[m+1][n+1];
        for(i = 0;i<=m;i++)
        {
            for(j=0;j<=n;j++)
            {
                if(j==0)
                {
                    f[i][j] = 1;
                    continue;
                }
                if(i == 0)
                {
                    f[i][j] = 0;
                    continue;
                }
                // 在这里i>0并且j>0
                // 情况1：B[n-1] 不和 A[m-1]结成对子
                f[i][j] = f[i-1][j];
                // 情况2：B[n-1] = A[m-1]
                if(s1[i-1] == s2[j-1])
                {
                    f[i][j] += f[i-1][j-1];
                }
            }

        }
        return f[m][n];
    }
}
