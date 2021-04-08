package 动态规划.双序列动态规划;

public class RegularExpressionMatching {
    public boolean isMatch(String ss,String pp)
    {
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        int m = s.length;
        int n = p.length;
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
                f[i][j] = false;
                if(p[j-1] != '*')
                {
                    if(i>0 && (p[j-1] == '.' || s[i-1] == p[i-1])) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
                else
                {
                    if(j>1)
                    {
                        f[i][j] |= f[i][j-2];
                    }
                    if(i>0 && j > 1)
                    {
                        if(p[j-2] == '.' || s[i-1] == p[j-2])
                        {
                            f[i][j] |= f[i-1][j];
                        }
                    }
                }
            }
        }
        return f[m][n];
    }
}
