package 图.DFS.剪枝.组合总和;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 存储结果
    public List<List<Integer>> res;
    // 因为每个元素都可以选择无数次所以不需要布尔数组

    // 候选数组的拷贝
    public int[] candidates;

    // 存储一种结果
    public List<Integer> tmp_res;


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 初始化操作
        this.res = new ArrayList<>();
        this.candidates = candidates;
        this.tmp_res = new ArrayList<>();
        traceBack(target);
        return res;
    }


    // 我们只要能够控制先选择小的后选择大的就可以。
    public void traceBack(int target)
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
        for(int i = 0; i < candidates.length;i++)
        {
            if(tmp_res.isEmpty() || tmp_res.get(tmp_res.size()-1)<=candidates[i])
            {
                tmp_res.add(candidates[i]);
                traceBack(target-candidates[i]);
                tmp_res.remove(tmp_res.size()-1);
            }
            else{
                continue;
            }
        }
    }
}