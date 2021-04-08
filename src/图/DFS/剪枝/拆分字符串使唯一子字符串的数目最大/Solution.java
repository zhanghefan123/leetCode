package 图.DFS.剪枝.拆分字符串使唯一子字符串的数目最大;

import java.util.HashSet;

public class Solution {

    public HashSet<String> tmp_set;

    public int final_res;

    public int maxUniqueSplit(String s) {
        if(s.equals(""))
        {
            return 0;
        }
        // 初始化操作
        this.tmp_set = new HashSet<>();
        this.final_res = Integer.MIN_VALUE;
        traceBack(s);
        return final_res;
    }

    public void traceBack(String currentString)
    {
        // 终止条件
        if(currentString.length() == 0)
        {
            final_res = Math.max(final_res,tmp_set.size());
            return;
        }

        // 最少都需要拆分出一个字母来
        for(int i = 1; i <= currentString.length(); i++)
        {
            String subString = currentString.substring(0,i);
            if(!tmp_set.contains(subString))
            {
                tmp_set.add(subString);
                traceBack(currentString.substring(i));
                tmp_set.remove(subString);
            }
            else
            {
                continue;
            }
        }
    }
}
