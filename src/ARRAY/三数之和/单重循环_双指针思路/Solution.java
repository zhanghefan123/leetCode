package ARRAY.三数之和.单重循环_双指针思路;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 特殊情况的特判
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length <= 2)
        {
            return ans;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++)
        {
            // 如果我们开始遍历的第一个数都是大于0的那么加上后面的肯定也大于0
            // 所以必然是不成立的
            if(nums[i] > 0)
            {
                break;
            }
            if(i > 0 && nums[i] == nums[i-1])
            {
                continue;
            }
            // b + c 需要凑出来-a
            int target = -nums[i];
            // b从a的下一个开始进行枚举
            int left = i+1;
            int right = nums.length - 1;
            while(left < right)
            {
                if(nums[left] + nums[right] == target)
                {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    // 然后b索引进行++
                    // c索引进行--
                    left++;
                    right--;
                    // 然后进行去重的操作
                    while(left < right && nums[left] == nums[left-1])
                    {
                        left++;
                    }
                    // 进行去重的操作
                    while(left < right && nums[right] == nums[right+1])
                    {
                        right--;
                    }
                }
                else if(nums[left] + nums[right] < target)
                {
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return ans;
    }
}
