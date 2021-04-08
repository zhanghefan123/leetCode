package 动态规划.双序列动态规划;

public class EditDistance {
    public int minDistance(String word1,String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int i,j;
        int m = s1.length;
        int n = s2.length;
        int [][] f = new int[m+1][n+1];
        for(i=0;i<=m;i++)
        {
            for(j = 0;j<=n;j++)
            {
                if(i == 0)
                {
                    f[i][j] = j;
                    continue;
                }
                if(j == 0)
                {
                    f[i][j] = i;
                    continue;
                }
                /*
                  最后一步插入：
                  A : a a
                  B : a a b
                  所以前一步需要保证 a a 一致

                  最后一步替换：
                  A : a a a
                  B : a a b
                  所以前一步需要保证 a a 一致

                  最后一步删除：
                  A : a a b a
                  B : a a b
                  所以前一步需要保证 a a b一致
                 */

                f[i][j] = Math.min(Math.min(f[i-1][j],f[i][j-1]),f[i-1][j-1])+1;

                // 当最后相等的情况，不需要操作
                if(s1[i-1] == s2[j-1])
                {
                    f[i][j] = Math.min(f[i][j],f[i-1][j-1]);
                }
            }
        }
        return f[m][n];
    }
}
