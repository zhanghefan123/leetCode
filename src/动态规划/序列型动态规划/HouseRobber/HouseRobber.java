package 动态规划.序列型动态规划.HouseRobber;
//题意:
/*
* 有一排N栋房子(0-(N-1)),房子i里面有A[i]个金币，一个窃贼想要选择一些房子
* 偷金币，但是不能偷任何挨着的两家邻居，否则会被警察逮住，最多偷多少金币。
*
* 输入示例:
* A = {3，8，4}
* 输出结果：
* 8
*
* 最后一步：
* 对于N栋房子，总归要来到最后一家，窃贼有可能不偷第N-1栋房子
* 窃贼有可能偷索引N-1栋房子，若偷则倒数第二栋不能偷，若不偷
* 则倒数第二栋可偷可不偷，若不偷最后一栋房子则倒数第二栋可偷可不偷。
* 所以对应的我们需要知道前N-1栋房子在偷与不偷第N-2号索引房子下的能偷的最多的金币。
*
* 综上所属得出状态：f[i][0]表示不偷房子i-1的前提下，前i栋房子中最多能偷多少金币
*                f[i][1]表示偷房子i-1的前提下，前i栋房子中最多能偷多少金币
*
* 状态转移方程：
* f[i][0] = max{f[i-1][0],f[i-1][1]} 因为不偷房子i-1所以房子i-2可以选择偷或者是不偷。
* f[i][1] = f[i-1][0] + A[i-1] 因为偷房子i-1，所以房子i-2只有一种选择
*
* 简化方式：
* 状态变为f[i]表示前i栋房子最多偷多少
* f[i] = max{f[i-1],f[i-2]+A[i-1]}
* max之中的第一项是不偷i-1号房子f[i-1],
* max之中的第二项是偷i-1号房子,索引i-2号房子不能偷，f[i-2]+A[i-1]
*
* 初始情况:
* 0栋房子的话，结果为0
* f[1] = A[0]
* f[2] = Max(A[0],A[1])
* */
public class HouseRobber {
    // 使用动态规划求解
    public int rob(int[] nums) {
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
