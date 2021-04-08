package 动态规划.记忆化搜索;

public class LongestPalindromicSubsequence {
    int[][] f = null;
    char[] s = null;
    int n = 0;

    // 记忆化搜索
    private void Compute(int i,int j)
    {
        if(f[i][j] != -1)
        {
            return;
        }
        if(i==j)
        {
            f[i][j] = 1;
            return;
        }
        if(i+1 == j)
        {
            f[i][j] = (s[i] == s[j])?2:1;
            return;
        }
        // 计算f[i+1,j]
        Compute(i+1,j);
        // 计算f[i,j-1]
        Compute(i,j-1);
        // 计算f[i+1,j-1]
        Compute(i+1,j-1);
        f[i][j] = Math.max(f[i+1][j],f[i][j-1]);
        if(s[i] == s[j])
        {
            f[i][j] = Math.max(f[i][j],f[i+1][j-1]+2);
        }
    }

    // 主方法
    public int longestPalindromicSubsequence(String ss)
    {
        s = ss.toCharArray();
        n = s.length;
        if(n == 0)
        {
            return 0;
        }
        if(n == 1)
        {
            return 1;
        }
        // 存储值，若已经算过了直接从其中进行提取
        f = new int[n][n];

        // 全部初始化为-1即没有计算过
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                f[i][j] = -1;
            }
        }


        return f[0][n-1];
    }
}
