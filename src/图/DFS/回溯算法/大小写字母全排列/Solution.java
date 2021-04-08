package 图.DFS.回溯算法.大小写字母全排列;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public char[] array;
    public int length;
    public List<String> res;

    public List<String> letterCasePermutation(String S) {
        this.array = S.toCharArray();
        this.length = S.length();
        this.res = new ArrayList<>();
        dfs(new StringBuilder(),0);
        return this.res;
    }

    public void dfs(StringBuilder current,int index)
    {
        if(current.length()==this.length)
        {
            this.res.add(new String(current));
            return;
        }
        char tmp = array[index];
        boolean lower = Character.isLowerCase(tmp);
        boolean upper = Character.isUpperCase(tmp);
        // 首先得是一个字母
        if(lower || upper)
        {
            if(lower)
            {
                // 原样输出
                current.append(tmp);
                dfs(current,index+1);
                current.deleteCharAt(current.length()-1);

                // 转换为大写
                char u_tmp = Character.toUpperCase(tmp);
                current.append(u_tmp);
                dfs(current,index+1);
                current.deleteCharAt(current.length()-1);

            }
            else
            {
                // 原样输出
                current.append(tmp);
                dfs(current,index+1);
                current.deleteCharAt(current.length()-1);

                // 转换为小写
                char l_tmp = Character.toLowerCase(tmp);
                current.append(l_tmp);
                dfs(current,index+1);
                current.deleteCharAt(current.length()-1);
            }
        }
        // 如果不是一个字母则直接加入
        else
        {
            current.append(tmp);
            dfs(current,index+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}