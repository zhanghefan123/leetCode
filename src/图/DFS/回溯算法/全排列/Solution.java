package 图.DFS.回溯算法.全排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 访问数组
    public boolean[] visited;
    // 结果
    public List<List<Integer>> res;
    // 数组的拷贝
    public int[] nums;
    // 一种情况
    public ArrayList<Integer> tmp_res;


    public List<List<Integer>> permute(int[] nums) {

        // 访问数组的初始化
        this.visited = new boolean[nums.length];
        // 结果集合的初始化
        this.res = new ArrayList<>();
        // 数组拷贝
        this.nums = nums;
        // 一种情况
        this.tmp_res = new ArrayList<>();
        // 进行回溯
        backTrace();
        // 返回结果
        return res;
    }

    public void backTrace()
    {
        if(tmp_res.size() == nums.length)
        {
            res.add(new ArrayList<>(tmp_res));
            return;
        }
        for(int i = 0; i < nums.length;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                tmp_res.add(nums[i]);
                backTrace();
                tmp_res.remove(tmp_res.size()-1);
                visited[i] = false;
            }
        }
    }
}

