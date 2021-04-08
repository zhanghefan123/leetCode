package ARRAY.双指针算法.同向双指针.调整数组顺序使奇数位于偶数前面;

import HASH.Hash;

import java.util.HashMap;

public class Solution {
    public int[] exchange(int[] nums) {
        int split = -1;
        int cur = 0;
        while(cur!=nums.length)
        {
            // 如果是奇数
            if(nums[cur] % 2 == 1)
            {
                split = split + 1;
                int tmp = nums[split];
                nums[split] = nums[cur];
                nums[cur] = tmp;
            }
            cur++;
        }
        return nums;
    }
}
