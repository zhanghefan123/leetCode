package 图.DFS;
//找出所有的方案类型的问题一般就是DFS问题，90%DFS的题，要么是排列，要么是组合
//第一类问题--组合搜索问题。

import java.util.ArrayList;
import java.util.List;

//题目：
/*
*
* 给定一组不含重复元素的整数数组 nums，
*返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
*
输入：
* 输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
* */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<1)
        {
            return res;
        }
        helper(res, new ArrayList<>(),nums,0);
        return res;
    }

    //算法思想：
    //每次进行一个元素选与不选的判断即可
    public void helper(List<List<Integer>> res,List<Integer> cur,int[]nums, int index)
    {

        if(index == nums.length)
        {
            res.add(new ArrayList<>(cur));
            return;
        }
        //参数分析:
        //res参数是结果，cur是当前的子集，nums是给的大集合，index是当前正在决定第几个元素选与被选，当决定完成了第三个元素就可以退出了。
        helper(res,cur,nums,index+1);
        cur.add(nums[index]);
        helper(res,cur,nums,index+1);
        cur.remove(cur.size()-1);

    }


}
