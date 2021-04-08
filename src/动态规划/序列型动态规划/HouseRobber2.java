package 动态规划.序列型动态规划;
//题目：
/*
* 存在一圈N栋房子，房子i-1里面存在A[i]个金币，一个窃贼
* 想要选择一些房子来偷金币，但是不能偷任何挨在一起的两个
* 邻居，否则就会被警察逮捕，最多偷多少个金币。
*
* 例子：
* 输入A={3，8，4}
* 输出8
* */

//算法思想：
/*
* 我们可以枚举盗贼是没有偷房子0还是没有偷房子N-1-->所有情况都被包括在内。
* 上述的任何一种情况都必将导致环的断开，形成HouseRobber1。
* 总结：圈的情况比序列的情况复杂，我们需要会将圈的情况化为序列的情况
*
*
* */
public class HouseRobber2 {
    public static void main(String[] args) {

    }
    // HouseRobber2的求解
    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0)
        {
            return 0;
        }
        // 注意只有一个元素的情况下返回首元素。
        if(n == 1)
        {
            return nums[0];
        }
        int[] A = new int[n-1];
        int res = Integer.MIN_VALUE;
        int i;
        // 不偷房子N-1
        for(i = 0; i < n-1;i++)
        {
            A[i] = nums[i];
        }
        res = Integer.max(res,rob1(A));
        // 不偷房子0
        for(i = 0;i<n-1;i++)
        {
            A[i] = nums[i+1];
        }
        res = Integer.max(res,rob1(A));
        return res;
    }


    // HouseRobber1的求解
    public int rob1(int[] nums) {
        int length = nums.length;
        if(length == 0)
        {
            return 0;
        }
        int[] helper = new int[length+1];
        helper[0] = 0;
        helper[1] = nums[0];
        for(int i = 2; i <= length; i++)
        {
            helper[i] = Integer.max(helper[i-2]+nums[i-1],helper[i-1]);
        }
        return helper[length];
    }
}
