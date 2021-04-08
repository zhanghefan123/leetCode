package 动态规划.双序列动态规划;

public class WildcardMatching
{
    public boolean isMatch(String ss,String pp)
    {
        char[] A = ss.toCharArray();
        char[] B = pp.toCharArray();
        int m = A.length;
        int n = B.length;
        boolean [][] f = new boolean[m+1][n+1];
        for(int i = 0;i<=m;i++)
        {
            for(int j =0;j<=n;j++)
            {
                if(i == 0 && j == 0)
                {
                    f[i][j] = true;
                    continue;
                }
                if(j == 0)
                {
                    f[i][j] = false;
                    continue;
                }
                if(B[j-1] != '*')
                {
                    if(i>0 && (A[i-1] == B[j-1] || B[j-1] == '.'))
                    {
                        f[i][j] |= f[i-1][j-1];
                    }
                }
                else
                {
                    f[i][j] |= f[i][j-1];
                    if(i>0)
                    {
                        f[i][j] |= f[i-1][j];
                    }

                }
            }
        }
        return f[m][n];
    }
}
