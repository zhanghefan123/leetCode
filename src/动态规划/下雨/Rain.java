package 动态规划.下雨;

import java.util.Arrays;

public class Rain {
    public int trap(int[] height) {
        //算法思想
        /*
        直接按问题描述进行。对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
        */
        //先进行某一点左侧最高元素的计算
        int length = height.length;
        if(length==0)
        {
            return 0;
        }
        int[] dp_left_max = new int[length];
        int[] dp_right_max = new int[length];
        //找出某一点左侧的最大值。
        int cur_left_max = height[0];
        for(int i = 0;i < length;i++)
        {
            cur_left_max = Integer.max(cur_left_max,height[i]);
            dp_left_max[i] = cur_left_max;
        }
        int cur_right_max = height[length-1];
        for(int i = length-1 ;i >= 0;i--)
        {
            cur_right_max = Integer.max(cur_right_max,height[i]);
            dp_right_max[i] = cur_right_max;
        }
        System.out.println(Arrays.toString(dp_left_max));
        System.out.println(Arrays.toString(dp_right_max));
        //最后进行整个数组的遍历
        int res = 0;
        for(int i = 0; i < length;i++)
        {
            if((Integer.min(dp_left_max[i],dp_right_max[i]) - height[i]) > 0)
                res += Integer.min(dp_left_max[i],dp_right_max[i]) - height[i];
        }
        return res;
    }
}
