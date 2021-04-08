package 图.DFS.剪枝.全排列2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;


public class Solution {

    // 存储所有的不重复的可能的情况
    public List<List<Integer>> res;

    // 是否已经访问过了
    public boolean[] visited;

    // 存储一次的结果
    public ArrayList<Integer> tmp_res;

    // 备份nums数组的引用
    public int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {

        // 初始化工作
        this.res = new ArrayList<>();
        this.visited = new boolean[nums.length];
        this.tmp_res = new ArrayList<>();
        Arrays.sort(nums);
        this.nums = nums;
        // 开始进行dfs工作
        dfs();
        return res;
    }

    public void dfs()
    {
        if(tmp_res.size() == nums.length)
        {
            res.add(new ArrayList<>(tmp_res));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(!visited[i])
            {
                // !visited[i-1]的含义是位于同一层，而不是同一分支路径上。
                if(i>0 && nums[i] == nums[i-1] && !visited[i-1])
                {
                    continue;
                }
                else{
                    visited[i] = true;
                    tmp_res.add(nums[i]);
                    dfs();
                    tmp_res.remove(tmp_res.size()-1);
                    visited[i] = false;
                }
            }
        }

    }
}

