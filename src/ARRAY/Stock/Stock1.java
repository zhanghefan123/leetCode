package ARRAY.Stock;
//算法时间复杂度O(n)的算法
//思路：一开始将minPrice设置为无穷大，并且将最大利润置为0，就相当于股市开盘的前一天
//然后进入星期1，星期2，星期3……的循环，首先进入星期1，设置当前自己知道的最低价，并且以这个最低价评估自己在这一天买入的利润，
//然后以此类推完成。
public class Stock1 {
    public int maxProfit(int []prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

}
