package 贪心.买卖股票的最佳时机;
//题目：
/*
* 已知后面N天一只股票的每天价格P0，P1,……PN-1
* 可以买卖一股任意多次，但任意的时刻手中最多只能持有一股
* 求最大的利润
* */

//算法策略:
/*
* 这里不是动态规划
* 这里是贪心，就是如果今天的价格比明天的价格低就今天买，明天卖出，
* 就是尽力的抓住每一段的上升即可
*
* */
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length <= 1)
        {
            return 0;
        }
        int sum = 0;
        for(int i = 0; i < length-1;i++)
        {
            sum += prices[i+1] > prices[i] ? prices[i+1] - prices[i] : 0;
        }
        return sum;
    }
}
