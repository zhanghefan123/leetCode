package 动态规划.最长序列型动态规划.最长连续递增序列;
//动态规划思路
/*
* 1.最后一步
* 不管怎么样，我们的最长子序列一定有最后一个元素a[j]
*
* 2.两种情况
* > 第一种情况--最优策略中最长连续上升子序列就是{a[j]},要么只有一个元素，要么全部都是不相同的
* > 第二种情况--子序列长度大于1，那么最优策略中最长子序列的最后一个元素a[j]前一个元素肯定是a[j-1]
*   因为是最优策略，那么它选中的以a[j-1]结尾的连续上升子序列一定是最长的。
*
* 3.状态的选择
* 以本元素结尾的最长子序列的长度
*
* 4.子问题的选择
* f[j-1] + 1 = f[j]
*
* 5.转移方程
* f[j] = max{1, f[j-1]+1|j>0 and a[j-1] < a[j]}
* 分析，给定的数组为a,f[j]代表以a[j]结尾的最长子序列的长度
* 情况2需要满足 -- a[j]前面还有元素a[j-1],并且a[j-1]<a[j]即保证单调性
* */
public class LongestContinuousSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int[] helper = new int[nums.length];
        int max = 0;
        for(int i = 0;i < nums.length;i++)
        {
            if(i == 0)
            {
                helper[i] = 1;
                max = Math.max(max,helper[i]);
            }
            else
            {
                if(nums[i] > nums[i-1])
                {
                    helper[i] = helper[i-1] + 1;
                    max = Math.max(max,helper[i]);
                }
                else{
                    helper[i] = 1;
                }
            }
        }
        return max;
    }
}
