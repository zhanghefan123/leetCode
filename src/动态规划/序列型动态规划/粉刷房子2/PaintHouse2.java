package 动态规划.序列型动态规划.粉刷房子2;
//题目：
/*
* 有一排N栋房子，每一栋房子要漆成K种颜色之中的一种，
* 任何两栋相邻的房子不能够漆成相同的颜色，房子i染成
* 第i种颜色的花费是cost[i][j]，i和j的编号都是从0开始
* 问：最少需要花费多少钱油漆这些房子
*
*/
//算法思想 == 类比于Paint House
/*
*
* 转移方程 -- f[i][j] = min(k!=j){f[i-1]][k]+cost[i-1][j]}
* f[i][j]的第一个索引代表油漆的房子数，第二个索引代表i-1号房屋的颜色
*
* 动态规划的常见优化方案 \/
*
* 本题需要进行优化的原因：我们每次都需要求f[i-1][1] …… f[i-1][K]中除了一个元素之外其他元素的最小值
*
* 思想：如果最小值是第i个元素，次小值是第j个元素，如果除掉的元素不是第i个，剩下的最小值就是第i个元素，
* 如果除掉的元素是第i个元素，剩下的最小值就是第j个元素
*
* 根据思想实现：我们需要记录下f[i-1][1] …… f[i-1][k]中的最小值和次小值分别是哪个
* 这个时候假设最小值是f[i-1][a] …… 次小值是f[i-1][b],则对于j=1,2,3,……a-1,a+1……k,
* 我们的f[i][j] = f[i-1][a] + cost[i-1][j],如果j=a的时候，f[a] = f[i-1][b] + cost[i-1][a]
* */
class PaintHouse2 {
    public int minCostII(int[][] cost) {
        // 房子的个数
        int m = cost.length;
        // 如果没有房子需要粉刷，不需要花费
        if(m == 0)
        {
            return 0;
        }
        int n = cost[0].length;
        // 初始化辅助数组，数组的元素A[i][j]对前i栋房子染色，且最后一栋房子被染成索引j颜色的花费
        int[][] helper = new int[m+1][n];
        // 如果没有房子需要粉刷，不需要花费
        for(int j = 0; j < n;j++)
        {
            helper[0][j] = 0;
        }
        // 用来记录前i-1栋房子花费的最小值--[应对颜色不冲突的情况]和次小值--[应对颜色冲突的情况]
        int firstMinValue;
        int secondMinValue;
        // 用来记录前i-1栋房子花费的最小值--对应的索引i-2号房子的颜色，用来记录前i-1栋房子花费的次小值--对应的索引i-2号房子的颜色。
        int firstMinIndex = 0;
        int secondMinIndex = 0;

        for(int i = 1; i <= m; i++)
        {
            firstMinValue = Integer.MAX_VALUE;
            secondMinValue = Integer.MAX_VALUE;
            // 当前需要记录粉刷前i-1栋房子的最小值和次小值
            for(int j = 0; j<n ; j++)
            {
                // 注意这个特殊情况
                if(i == 1)
                {
                    firstMinValue = 0;
                    secondMinValue = 0;
                }
                else
                {
                    // 注意这个小于等于号
                    
                    if(helper[i-1][j] <= firstMinValue)
                    {
                        secondMinValue = firstMinValue;
                        secondMinIndex = firstMinIndex;
                        firstMinValue = helper[i-1][j];
                        firstMinIndex = j;
                    }
                    else if(helper[i-1][j] > firstMinValue && helper[i-1][j] < secondMinValue){
                        secondMinValue = helper[i-1][j];
                        secondMinIndex = j;
                    }
                }

            }
            for(int j = 0; j < n; j++)
            {
                // 两种情况都需要加上最后一栋房子的花费
                helper[i][j] += cost[i-1][j];
                // 如果是第一种情况
                if(j != firstMinIndex)
                {
                    helper[i][j] += firstMinValue;
                }
                else
                {
                    helper[i][j] += secondMinValue;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int j = 0; j < n;j++)
        {
            res = Integer.min(res,helper[m][j]);
        }
        return res;
    }
}
