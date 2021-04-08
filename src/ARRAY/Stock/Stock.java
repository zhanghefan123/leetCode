package ARRAY.Stock;

import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;

public class Stock {
    public int maxProfit(int[] prices) {
        Deque<Integer> deque = new LinkedList<>();

        int minPosition;
        int highPosition;
        int maxProfit= 0;
        for(int i=0;i<prices.length;i++)
        {
            minPosition = i;
            for(int j=i+1;j<prices.length;j++)
            {
                if(prices[minPosition]<prices[j])
                {
                    if(maxProfit < prices[j] - prices[minPosition])
                    {
                        maxProfit = prices[j] - prices[minPosition];
                    }
                }
            }
        }
        return maxProfit;
    }
}
