package 蓝桥杯.题目_2015.牌型总数;

import java.util.ArrayList;
import java.util.Arrays;

// 牌型总数
/*
小明被劫持到了X赌城，被迫与其他三个人玩牌
一副扑克牌(去掉大小王，总共52张)，均匀发给4个人，每个人13张
这时，小明脑子里突然冒出一个问题
如果不考虑花色，只考虑点数，也不考虑自己得到的牌的先后顺序，
自己手里拿到的初始牌型组合一共有多少种呢?

这就是求组合数.
 */
public class Solution {

    public int[] visited;

    public ArrayList<Integer> list;

    public int final_res;

    public Solution(){
        // 进行操作
        this.visited = new int[13];
        Arrays.fill(this.visited,4);
        this.list = new ArrayList<>();
        this.final_res = 0;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.dfs();
        System.out.println("结果为:" + s.final_res);
    }

    public void dfs()
    {
        if(list.size() == 13)
        {
            this.final_res++;
            return;
        }

        for(int i = 0 ; i <= 12; i++)
        {
            if(visited[i] > 0)
            {
                if(this.list.isEmpty())
                {
                    this.visited[i] = this.visited[i] - 1;
                    this.list.add(i);
                    dfs();
                    this.list.remove(this.list.size()-1);
                    this.visited[i] = this.visited[i] + 1;
                }
                else if((this.list.get(this.list.size()-1) <= i))
                {
                    this.visited[i] = this.visited[i] - 1;
                    this.list.add(i);
                    dfs();
                    this.list.remove(this.list.size()-1);
                    this.visited[i] = this.visited[i] + 1;
                }
            }
        }
    }
}
