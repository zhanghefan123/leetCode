package STRING.回文子串个数;

public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        char[] chas = s.toCharArray();
        int res = 0;
        // 大的回文串需要小的回文串作为支撑
        // 所以这是区间型动态规划--长度从长到短进行遍历
        for(int len = 1;len<=n;len++)
        {
            for(int i = 0; i<n; i++)
            {
                int j = i + len - 1;
                if(j>=n)
                {
                    continue;
                }
                if(len == 1)
                {
                    f[i][j] = 1;
                }
                else if(len == 2)
                {
                    f[i][j] = chas[i] == chas[j] ? 1 : 0;
                }
                else{
                    f[i][j] = chas[i] == chas[j] && f[i+1][j-1] == 1 ? 1 : 0;
                }
                res += f[i][j];
            }
        }
        return res;
    }
}
