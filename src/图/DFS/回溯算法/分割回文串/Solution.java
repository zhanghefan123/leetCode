package 图.DFS.回溯算法.分割回文串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int n;

    public boolean[][] f;

    public List<List<String>> ret = new ArrayList<List<String>>();

    public List<String> ans = new ArrayList<String>();

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        // 填充了矩阵的左下角
        for(int j = 0;j < n;j++)
        {
            for(int i = 0;i<=j;i++)
            {
                // 长度为2的字符串
                if(i == j)
                {
                    f[i][j] = true;
                    continue;
                }
                // 长度为2的字符串
                if(j - i == 1)
                {
                    f[i][j] = (s.charAt(i) == s.charAt(j));
                    continue;
                }
                if((i < n-1) && (j > 0))
                {
                    f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i+1][j-1];
                }
            }
        }
        dfs(s,0);
        return ret;
    }

    public void dfs(String s,int i)
    {
        if(i == n)
        {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for(int j = i;j<n;j++)
        {
            if(f[i][j])
            {
                ans.add(s.substring(i,j+1));
                dfs(s,j+1);
                ans.remove(ans.size()-1);
            }
        }
    }
}

