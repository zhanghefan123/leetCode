package 动态规划.区间和背包型动态规划.区间型动态规划;

public class LongestPalindromicSubsequence {
    public int longestPalindromicSubsequence(String ss)
    {
        char[] s;
        s = ss.toCharArray();
        int n = s.length;
        if(n == 0)
        {
            return 0;
        }
        if(n == 1)
        {
            return 1;
        }
        int [][] f = new int[n][n];
        int i,j,len;
        // 对于长度为1的串
        for(i = 0;i<n;i++)
        {
            f[i][i] = 1;
        }
        // 对于长度为2的串
        for(i=0;i<n-1;i++)
        {
            f[i][i+1] = (s[i] == s[i+1])?2:1;
        }

        // 枚举长度
        for(len = 3;len<=n;len++)
        {
            // 保证长度，所以起点需要小于等于n-len
            for(i = 0;i<=n-len;i++)
            {
                j = i+len-1;
                f[i][j] = Math.max(f[i+1][j],f[i][j-1]);
                if(s[i] == s[j])
                {
                    f[i][j] = Math.max(f[i][j],f[i+1][j-1]+2);
                }
            }
        }
        return f[0][n-1];
    }
}
