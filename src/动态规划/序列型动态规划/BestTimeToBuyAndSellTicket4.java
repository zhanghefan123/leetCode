package 动态规划.序列型动态规划;

public class BestTimeToBuyAndSellTicket4 {
    public int maxProfit(int k,int[] prices) {
        int length = prices.length;
        if(length==0)
        {
            return 0;
        }
        // 如果k>n/2则转换为BestTimeToBuyAndSellStock2
        if(k > length/2)
        {
            return maxProfit(prices);
        }

        // 总共存在2k+1种状态:
        /* 1.首先是清仓状态，一次也没有买卖 -- 0状态
           2.然后是第一次持有股票状态 -- 1状态
           3.接着是清仓状态，买卖了一次 -- 2状态
           4.然后是第二次持有股票状态 -- 3状态
           5.最终是清仓状态，买卖了两次 -- 4状态
           以此类推……………………………………………………………………………………
           */

        // helper[i][j] 表示在第i天处于j状态下的最大收益。

        int[][] helper = new int[length+1][2*k+1];

        // 在第0天的时候，只能处于0状态,并且没有收益
        helper[0][0] = 0;
        // 在第0天处于其他状态是不可能的，所以初始化为-∞
        for(int i = 1; i <= 2*k;i++)
        {
            helper[0][i] = Integer.MIN_VALUE;
        }
        // 接着遍历填充helper数组。
        // 我们要求前N天的最大收益
        /*
        1.此时即索引N-1天若处在状态4，N-2天可能是状态4,N-2天可能是状态3
        情况1：f[N][4] = f[N-1][4]
        情况2：f[N][4] = f[N-1][3] + prices[N-1] - prices[N-2]

        2.此时即索引N-1天若处在状态3,N-2天可能是状态3，N-2天可能是状态2
        // 情况1需要保证不是最后一天，以便卖出
        情况1 --继续获利: f[N][3] = f[N-1][3] + prices[N-1] - prices[N-2]
        情况2：f[N][3] = f[N-1][2]


        */
        for(int i = 1; i <= length;i++)
        {
            // 先形成 0 2 4 ……状态
            for(int j = 0;j<=2*k;j+=2)
            {
                helper[i][j] = helper[i-1][j];
                if (j >= 1 && i >= 2 && helper[i - 1][j - 1] != Integer.MIN_VALUE)
                {
                    helper[i][j] = Integer.max(helper[i][j],helper[i-1][j-1] + prices[i-1] - prices[i-2]);
                }
            }

            // 再形成 1 3 ……状态
            for(int j = 1;j<=2*k-1;j+=2)
            {
                helper[i][j] = helper[i-1][j-1];
                if (i >= 2 && helper[i - 1][j] != Integer.MIN_VALUE)
                {
                    helper[i][j] = Integer.max(helper[i][j],helper[i-1][j] + prices[i-1] - prices[i-2]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i<=2*k;i+=2)
        {
            res = Integer.max(res,helper[length][i]);
        }
        return res;
    }

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
