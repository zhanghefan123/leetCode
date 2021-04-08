package 动态规划.坐标型动态规划.乘积最大子数组;

public class Solution {
    public int maxProduct(int[] nums) {
        // 我们不仅需要记住以nums中索引i元素结尾的乘积最大子数组
        // 还需要记住以nums中索引i元素结尾的乘积最小子数组，以免遇到负数的情况
        int[] max_helper = new int[nums.length];
        int[] min_helper = new int[nums.length];
        int final_res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            if(i == 0)
            {
                max_helper[i] = nums[i];
                min_helper[i] = nums[i];
                final_res = Math.max(final_res,nums[i]);
            }
            else
            {
                if(nums[i] == 0)
                {
                    max_helper[i] = 0;
                    min_helper[i] = 0;
                    final_res = Math.max(final_res,0);
                }
                else if(nums[i] > 0)
                {
                    max_helper[i] = Math.max(max_helper[i-1] * nums[i],nums[i]);
                    min_helper[i] = Math.min(min_helper[i-1] * nums[i],nums[i]);
                    final_res = Math.max(final_res,max_helper[i]);
                }
                else{
                    max_helper[i] = Math.max(min_helper[i-1] * nums[i],nums[i]);
                    if(max_helper[i-1] > 0)
                    {
                        min_helper[i] = Math.min(max_helper[i-1] * nums[i], nums[i]);
                    }
                    else{
                        min_helper[i] = Math.min(min_helper[i-1] * nums[i],nums[i]);
                    }
                    final_res = Math.max(final_res,max_helper[i]);
                }
            }
        }
        return final_res;
    }
}