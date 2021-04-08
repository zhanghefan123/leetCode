package 动态规划.区间和背包型动态规划.背包型动态规划;
//题目：
/*
 * 给定N个正整数 -- A0 -----AN-1
 * 一个正整数Target
 * 求存在多少个组合加起来是target
 * 每个Ai能够使用无限多次。
 *
 * 输入：
 * A = [1,2,4] Target = 4
 * 输出6=(1+1+1+1=4,2+2=4,1+1+2=4，1+2+1=4，2+1+1=4，4=4)
 * */

//题目分析
//和BackPackV的唯一区别是，组合数之中的数字可以按照不同的顺序，比如1+1+2和1+2+1算两种组合


//算法分析
/*
* 最后一步:因为物品已经不存在加入的顺序了--可以重复加入，所以我们不能说关注最后的一步是加入最后一个物品，
* 而是应该关注最后一个物品的重量是多少了。
*
* 关键点1--任何一个正确的组合之中，所有物品的总重量为Target-k
* 关键点2--如果最后一个物品的重量为k,则前面的物品的重量为Target-k
*
* 状态转移方程设f[i]表示有多少种组合能够拼出重量i
* f[i] = f[i-A0] + f[i-A1] + …… f[i-An]
* 分别为当最后重量为A0，A1，A2……An的和。
* 初始条件
* f[0] = 1
*
* 计算顺序
* f[1] f[2] …… f[target]
* */
public class BackPackVI {

    public int backPackVI(int[]A,int m)
    {
        int[] helper = new int[m+1];
        int i,j;
        helper[0] = 1;
        // 生成每个helper
        for(i = 1; i <= m;i++)
        {
            helper[i] = 0;
            // 遍历最后一个元素
            for(j = 0;j<A.length;j++)
            {
                if(i>=A[j])
                {
                    helper[i] += helper[i-A[j]];
                }
            }
        }
        return helper[m];
    }
}
