package 图.DFS.剪枝.组合总和2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> res = new ArrayList<>();

    public List<Integer> tmp_res = new ArrayList<>();

    public boolean[] visited;


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return res;
    }

    public void dfs(int[] candidates,int index,int target)
    {
        if(target == 0)
        {
            res.add(new ArrayList<>(tmp_res));
            return;
        }
        else if(target < 0)
        {
            return;
        }
        for(int i = index; i < candidates.length;i++)
        {
            if(!visited[i])
            {
                if(i>0 && candidates[i-1] == candidates[i] && !visited[i-1])
                {
                    continue;
                }
                else{
                    visited[i] = true;
                    tmp_res.add(candidates[i]);
                    dfs(candidates,i+1,target-candidates[i]);
                    tmp_res.remove(tmp_res.size()-1);
                    visited[i] = false;
                }
            }
        }
    }
}
