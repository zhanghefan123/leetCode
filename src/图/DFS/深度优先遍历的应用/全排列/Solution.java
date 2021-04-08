package 图.DFS.深度优先遍历的应用.全排列;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.*;

public class Solution {
    public boolean[] used;

    public int[] nums;

    public Deque<Integer> single = new LinkedList<>();

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.used = new boolean[nums.length];
        this.nums = nums;
        dfs();
        return res;
    }
    public void dfs()
    {
        if(nums.length == single.size())
        {
            res.add(Arrays.asList(single.toArray(new Integer[single.size()])));
        }

        for(int i = 0;i<nums.length;i++)
        {
            if(!used[i])
            {
                single.offerLast(nums[i]);
                used[i] = true;
            }
            else
            {
                continue;
            }
            dfs();
            if(used[i])
            {
                single.pollLast();
                used[i] = false;
            }
        }
    }
}

