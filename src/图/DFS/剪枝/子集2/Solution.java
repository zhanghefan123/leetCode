package 图.DFS.剪枝.子集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // 包含重复元素的问题需要参考全排列2的解决方案

    public List<List<Integer>> res;

    public List<Integer> tmp_res;

    public int[] nums;

    public boolean[] visited;

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // 系列初始化的操作
        this.res = new ArrayList<>();

        this.visited = new boolean[nums.length];

        Arrays.sort(nums);

        this.nums = nums;

        // 遍历每一个长度
        for(int i = 0;i<=nums.length;i++)
        {
            this.tmp_res = new ArrayList<>();
            traceBack(0,i);
        }
        return res;
    }

    public void traceBack(int index,int length)
    {
        if(tmp_res.size() == length)
        {
            res.add(new ArrayList<>(tmp_res));
            return;
        }
        for(int i = index; i < nums.length; i++)
        {
            if(!visited[i])
            {
                if(i>0 && nums[i] == nums[i-1] && !visited[i-1])
                {
                    continue;
                }
                else
                {
                    visited[i] = true;
                    tmp_res.add(nums[i]);
                    traceBack(i+1,length);
                    tmp_res.remove(tmp_res.size()-1);
                    visited[i] = false;
                }
            }
        }
    }
}