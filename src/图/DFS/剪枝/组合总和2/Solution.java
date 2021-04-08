package 图.DFS.剪枝.组合总和2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public boolean[] visited;

    public List<List<Integer>> res;

    public List<Integer> tmp_res;

    public int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.visited = new boolean[candidates.length];
        this.res = new ArrayList<>();
        this.tmp_res = new ArrayList<>();
        Arrays.sort(candidates);
        this.candidates = candidates;
        traceBack(target);
        return res;
    }

    public void traceBack(int target)
    {
        if(target == 0)
        {
            this.res.add(new ArrayList<>(tmp_res));
            return;
        }
        else if(target < 0)
        {
            return;
        }
        for(int i = 0; i < candidates.length;i++)
        {
            if(!visited[i])
            {
                // 这部分的思想是参考全排列2的思想，全排列2剪枝的地方是同一层出现相同的值，这样肯定会出现重复
                if(i>0 && candidates[i] == candidates[i-1] && !visited[i-1])
                {
                    continue;
                }
                // 这部分的思想是避免出现相同值但是不同元素的选择，所以按照顺序进行选择。
                else if(!tmp_res.isEmpty() && tmp_res.get(tmp_res.size()-1)>candidates[i])
                {
                    continue;
                }
                else{
                    visited[i] = true;
                    this.tmp_res.add(candidates[i]);
                    traceBack(target - candidates[i]);
                    this.tmp_res.remove(this.tmp_res.size()-1);
                    visited[i] = false;
                }
            }
        }
    }
}
