package 动态规划.双序列动态规划;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] A = text1.toCharArray();
        char[] B = text2.toCharArray();
        int m = A.length;
        int n = B.length;
        int [][] helper = new int [m+1][n+1];
        for(int i = 0;i<=m;i++)
        {
            for(int j = 0;j<=n;j++)
            {
                if(i == 0 || j == 0)
                {
                    helper[i][j] = 0;
                    continue;
                }
                helper[i][j] = Math.max(helper[i-1][j],helper[i][j-1]);
                if(A[i-1] == B[j-1])
                {
                    helper[i][j] = Math.max(helper[i][j],helper[i-1][j-1]+1);
                }
            }

        }
        return helper[m][n];
    }

    // 如果要将最长公共子序列打印出来
    public int longestCommonSubsequenceOptimizer(String text1, String text2) {
        char[] A = text1.toCharArray();
        char[] B = text2.toCharArray();
        int m = A.length;
        int n = B.length;
        // 用来记录每一次的选择，用来从后向前进行打印
        int[][] pi = new int[m+1][n+1];
        int [][] helper = new int [m+1][n+1];
        for(int i = 0;i<=m;i++)
        {
            for(int j = 0;j<=n;j++)
            {
                if(i == 0 || j == 0)
                {
                    helper[i][j] = 0;
                    continue;
                }
                helper[i][j] = Math.max(helper[i-1][j],helper[i][j-1]);
                // 说明保留了B的最后一个，A--
                if(helper[i][j] == helper[i-1][j])
                {
                    pi[i][j] = 0;
                }
                // 否则说明保留了A的最后一个，B--
                else
                {
                    pi[i][j] = 1;
                }
                if(A[i-1] == B[j-1])
                {
                    helper[i][j] = Math.max(helper[i][j],helper[i-1][j-1]+1);
                    if(helper[i][j] == helper[i-1][j-1]+1)
                    {
                        pi[i][j] = 2;
                    }
                }
            }

        }
        // helper[m][n]是结果--即最长公共子序列的长度
        char[] res = new char[helper[m][n]];
        int p = helper[m][n]-1;
        int i = m;
        int j = n;
        while(i>0 && j>0)
        {
            if(pi[i][j] == 0)
            {
                i--;
            }
            else if(pi[i][j] == 1)
            {
                j--;
            }
            else
            {
                res[p] = A[i-1];
                p--;
                i--;
                j--;
            }
        }
        System.out.println(new String(res));

        return helper[m][n];
    }
}
