package 动态规划.双序列动态规划;

public class InterleavingString {
    public boolean isInterleaving(String ss1,String ss2,String ss3)
    {
        char[] s1 = ss1.toCharArray();
        char[] s2 = ss2.toCharArray();
        char[] s3 = ss3.toCharArray();
        int i,j;
        int m = s1.length;
        int n = s2.length;
        if(m+n != s3.length)
        {
            return false;
        }
        boolean [][] f = new boolean[m+1][n+1];
        for(i = 0;i<=m;i++)
        {
            for(j = 0;j<=n;j++)
            {
                if(i == 0 && j == 0)
                {
                    f[i][j] = true;
                    continue;
                }
                f[i][j] = false;
                if(i>0 && s3[i+j-1] == s1[i-1])
                {
                    f[i][j] |= f[i-1][j];
                }
                if(j>0 && s3[i+j-1] == s2[i-1])
                {
                    f[i][j] |= f[i][j-1];
                }
            }
        }
        return f[m][n];
    }
}
