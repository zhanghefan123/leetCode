package ARRAY.双指针算法.同向双指针.调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args)
    {
        int[] array = new int[]{1,3,2,4,5,1};
        System.out.println(Arrays.toString(exchange(array)));
    }

    public static int[] exchange(int[] nums) {
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
