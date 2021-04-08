package TREE.红黑树.红黑树的应用.积压订单中的订单总数;

import java.util.TreeMap;

public class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        // 购买记录
        TreeMap<Integer,Integer> buy_records = new TreeMap<>();
        // 卖出记录
        TreeMap<Integer,Integer> sell_records = new TreeMap<>();
        // 进行循环
        for(int[] tmp : orders)
        {
            // 购买记录
            if(tmp[2] == 0)
            {
                // 检查销售记录中有没有可以被抵消的
                // 如果销售记录为空则无法抵消
                if(sell_records.isEmpty())
                {
                    // 购买记录积压
                    if(buy_records.containsKey(tmp[0]))
                    {
                        buy_records.put(tmp[0],buy_records.get(tmp[0]) + tmp[1]);
                    }
                    else
                    {
                        buy_records.put(tmp[0],tmp[1]);
                    }
                }
                else
                {
                    while(true)
                    {
                        // 找到价格最低的销售记录
                        int lowest_key = sell_records.firstKey();
                        // 如果购买大于等于销售则可以抵消
                        if(lowest_key <= tmp[0])
                        {
                            int count = sell_records.get(lowest_key);
                            // 如果count < tmp[1]
                            if(count <= tmp[1])
                            {
                                sell_records.remove(lowest_key);
                                tmp[1] = tmp[1] - count;
                                if(sell_records.isEmpty())
                                {
                                    if(buy_records.containsKey(tmp[0]))
                                    {
                                        buy_records.put(tmp[0],buy_records.get(tmp[0]) + tmp[1]);
                                    }
                                    else
                                    {
                                        buy_records.put(tmp[0],tmp[1]);
                                    }
                                    break;
                                }
                                continue;
                            }
                            else
                            {
                                sell_records.put(lowest_key,count - tmp[1]);
                                break;
                            }
                        }
                        else
                        {
                            if(buy_records.containsKey(tmp[0]))
                            {
                                buy_records.put(tmp[0],buy_records.get(tmp[0]) + tmp[1]);
                            }
                            else
                            {
                                buy_records.put(tmp[0],tmp[1]);
                            }
                            break;
                        }

                    }
                }
            }
            // 销售记录
            else{
                // 检查购买记录中有没有可以用来抵消的
                // 如果购买记录为空则无法抵消
                if(buy_records.isEmpty())
                {
                    // 销售记录积压
                    if(sell_records.containsKey(tmp[0]))
                    {
                        sell_records.put(tmp[0],sell_records.get(tmp[0]) + tmp[1]);
                    }
                    else
                    {
                        sell_records.put(tmp[0],tmp[1]);
                    }

                }
                else
                {
                    while(true)
                    {
                        // 找到价格最高的购买记录
                        int highest_key = buy_records.lastKey();
                        // 如果购买大于销售则可以抵消
                        if(highest_key >= tmp[0])
                        {
                            int count = buy_records.get(highest_key);
                            // 如果count < tmp[1]
                            if(count <= tmp[1])
                            {
                                buy_records.remove(highest_key);
                                tmp[1] = tmp[1] - count;
                                if(buy_records.isEmpty())
                                {
                                    if(sell_records.containsKey(tmp[0]))
                                    {
                                        sell_records.put(tmp[0],sell_records.get(tmp[0]) + tmp[1]);
                                    }
                                    else
                                    {
                                        sell_records.put(tmp[0],tmp[1]);
                                    }
                                    break;
                                }
                                continue;
                            }
                            else
                            {
                                buy_records.put(highest_key,count-tmp[1]);
                                break;
                            }
                        }
                        else
                        {
                            if(sell_records.containsKey(tmp[0]))
                            {
                                sell_records.put(tmp[0],sell_records.get(tmp[0]) + tmp[1]);
                            }
                            else
                            {
                                sell_records.put(tmp[0],tmp[1]);
                            }
                            break;
                        }

                    }

                }
            }
        }
        int sum = 0;
        for(int key:buy_records.keySet())
        {
            System.out.println(key + " " + buy_records.get(key));
            sum = (sum + buy_records.get(key)) % 1000000007;
        }
        for(int key:sell_records.keySet())
        {
            System.out.println(key + " " + sell_records.get(key));
            sum = (sum + sell_records.get(key)) % 1000000007;
        }
        return sum;

    }
}
