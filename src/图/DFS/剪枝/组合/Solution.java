package 图.DFS.剪枝.组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int length;
    public List<List<Integer>> res;
    public List<Integer> cur_list;
    public int n;

    public List<List<Integer>> combine(int n, int k) {
        this.length = k;
        this.res = new ArrayList<>();
        this.n = n;
        this.cur_list = new ArrayList<>();
        dfs(1);
        return res;
    }

    public void dfs(int cur_index)
    {
        if(cur_list.size() == this.length)
        {
            this.res.add(new ArrayList(cur_list));
            return;
        }
        for(int i=cur_index; i<=this.n; i++)
        {

            cur_list.add(i);
            dfs(i+1);
            cur_list.remove(cur_list.size()-1);
        }
    }
}
