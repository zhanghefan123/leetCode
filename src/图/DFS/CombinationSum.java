package 图.DFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//题目：
/*
* 给定一个无重复元素的数组 candidates 和一个目标数 target ，
* 找出 candidates 中所有可以使数字和为 target 的组合。
*
* 注意:candidates 中的数字可以无限制重复被选取。
*     所有数字（包括 target）都是正整数。
*     解集不能包含重复的组合。
*
* 输入示例:
* candidates = [2,3,6,7], target = 7
*
* 输出结果:
* [
  [7],
  [2,2,3]
   ]
* */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // -4 -1 1 2
        //target = 1
        // 2
        /*
        * candidates是一个无重复元素的数组
        * target是我们需要达成的目标数
        * */
        List<List<Integer>> results = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
        {
            return results;
        }
        Arrays.sort(candidates);
        helper(candidates,0,target,new ArrayList<>(),results);
        return results;
    }

    private void helper(int[] candidates, int startIndex,int remainTarget,List<Integer> combination,List<List<Integer>> results)
    {
        if(remainTarget == 0)
        {
            results.add(new ArrayList<>(combination));
            return;
        }
        for(int i = startIndex; i< candidates.length; i++)
        {
            if(remainTarget < candidates[i])
            {
                //因为这个candidates是被排序过的，如果连索引i号元素都无法加入
                //那么后面的元素一定无法加入。所以可以直接break掉。
                break;
            }
            if(i!=0 && candidates[i] == candidates[i-1])
            {
                //这个操作是保证不会出现重复计算。
                /*
                *               比如我们的candidates是2 3 6 7
                *                      2 3 6 7
                *    选2          选3            选6             选7
                *  2 3 6 7     2 3 6 7        2 3 6 7        2 3 6 7
                *
                *               若我们不进行去重那么 2 2 3 6 7
                *                   2  2  3  6  7
                *   选2 ✔         选2 ✔             选3            选6          选7
                * 2 2 3 6 7    2 2 3 6 7        2 2 3 6 7    2 2 3 6 7    2 2 3 6 7
                * 发生了重复的计算，耗费时间。
                *
                * */
                continue;
            }
            combination.add(candidates[i]);
            helper(candidates,i,remainTarget-candidates[i],combination,results);
            combination.remove(combination.size()-1);
        }
    }
}
