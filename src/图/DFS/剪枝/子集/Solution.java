package 图.DFS.剪枝.子集;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> res;

    public List<Integer> tmp_res;

    public int[] nums;

    public List<List<Integer>> subsets(int[] nums) {

        // 初始化操作
        this.res = new ArrayList<>();
        this.nums = nums;
        // 寻找所有长度的子集，这里的长度就是i
        for(int i = 0;i <= nums.length;i++)
        {
            tmp_res = new ArrayList<>();
            traceBack(i,0);
        }
        return res;
    }

    public void traceBack(int length,int index)
    {
        if(tmp_res.size() == length)
        {
            res.add(new ArrayList<>(tmp_res));
            return;
        }
        // i = index的编码是因为一个元素只能够选择一次。
        for(int i = index; i < nums.length; i++)
        {
            tmp_res.add(nums[i]);
            traceBack(length,i+1);
            tmp_res.remove(tmp_res.size()-1);
        }
    }
}
