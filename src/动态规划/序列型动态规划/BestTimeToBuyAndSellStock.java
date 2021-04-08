package 动态规划.序列型动态规划;
//题目:
/*
* 已知后面N天一只股票的每天的价格P0，P1,……P(N-1)
* 这几天可以最多买一股，卖一股
* 求最大利润
*
* 例子：
* 输入：[3,2,3,1,2]
* 输出：1(2买入，3卖出)
*
* 优质策略：
* 低买高卖，必须先买后卖
* 如果买卖一股，如果是第i天买，第j天卖(j>i)，获利是Pj-Pi
* */

//动态规划思想
/*
* 从0到N-1枚举j,即第几天卖,即最后一步，总要进行卖出。
* 状态f(i)即为到今天为止的最小值。假设我们要在第N天
* 进行卖出的操作那么我们的状态转移方程就可以变化为
* f(N) = min(f(N-1),今天的股价)
*
*
*
* 时刻保存当前为止(即为0-(j-1)天)的最低价格Pi
*
* 最大的Pj-Pi就是答案
*
*
* */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {

    }
    public static int func(int[] A){
        int n = A.length;
        if(n == 0)
        {
            return 0;
        }
        int res = 0;
        int minV = A[0];
        for(int i = 1;i<n;i++)
        {
            // 时刻更新当前最大差价
            res = Math.max(res,A[i]-minV);
            // 时刻更新当前最小值。
            minV = Math.min(minV,A[i]);
        }
        return res;
    }
}
