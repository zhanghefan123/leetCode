package 动态规划.坐标型动态规划.最大子序和;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1)
        {
            return nums[0];
        }
        // 状态helper[i]表示以索引i结尾的连续子数组的最大和
        int[] helper = new int[nums.length];
        int final_res = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++)
        {
            if(i == 0)
            {
                helper[i] = nums[i];
                final_res = Math.max(final_res,helper[i]);
                continue;
            }
            else
            {
                helper[i] = Math.max(helper[i-1] + nums[i],nums[i]);
                final_res = Math.max(final_res,helper[i]);
            }
        }
        return final_res;
    }
}