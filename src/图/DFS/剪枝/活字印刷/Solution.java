package 图.DFS.剪枝.活字印刷;

import java.util.Arrays;

public class Solution {
    // 记录存在的序列的个数
    public int final_res;

    // 记录当前的序列长度
    public int current_length;

    // 因为字模是可能重复的，所有需要仿照全排列2的做法
    public boolean[] visited;

    // 字符串的拷贝
    public char[] charArray;

    public int numTilePossibilities(String tiles) {
        this.final_res = 0;

        this.current_length = 0;

        this.visited = new boolean[tiles.length()];

        this.charArray = tiles.toCharArray();

        // 仅有排序过后nums[i] == nums[i-1]才会有用
        Arrays.sort(this.charArray);
        // 遍历所有可能的长度
        for(int i=1; i<=tiles.length();i++)
        {
            traceBack(i);
        }
        return final_res;
    }

    public void traceBack(int target_length)
    {
        if(current_length == target_length)
        {
            final_res++;
            return;
        }
        for(int i = 0; i < charArray.length;i++)
        {
            if(!visited[i])
            {
                // 说明在同一层。可能导致重复，需要continue
                if(i>0 && charArray[i] == charArray[i-1] && !visited[i-1])
                {
                    continue;
                }
                else
                {
                    visited[i] = true;
                    this.current_length++;
                    traceBack(target_length);
                    this.current_length--;
                    visited[i] = false;
                }
            }
        }
    }
}