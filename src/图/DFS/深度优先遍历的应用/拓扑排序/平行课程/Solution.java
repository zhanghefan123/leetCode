package 图.DFS.深度优先遍历的应用.拓扑排序.平行课程;

import java.util.*;

public class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        // 最后的结果
        int final_res = 0;
        // 还是进行正向邻接表和反向邻接表的创建
        List<HashSet<Integer>> adj = new ArrayList<>();
        List<HashSet<Integer>> rev_adj = new ArrayList<>();
        List<Integer> order = new ArrayList<>();
        // 进行两者的初始化
        for(int i = 0; i < N;i++)
        {
            adj.add(new HashSet<>());
            rev_adj.add(new HashSet<>());
        }
        // 进行边表的添加
        for(int [] side : relations)
        {
            int start = side[1];
            int end = side[0];
            adj.get(start-1).add(end-1);
            rev_adj.get(end-1).add(start-1);
        }
        // 进行队列的创建和开始元素的添加
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < N; i++)
        {
            if(rev_adj.get(i).size() == 0)
            {
                order.add(i);
                queue.offerLast(i);
            }
        }
        if(queue.size()>0)
        {
            final_res++;
        }
        else
        {
            return -1;
        }
        // 当队列非空的时候就进行继续的循环
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int j = 0;j<len;j++)
            {
                int tmp_node = queue.pollFirst();
                // 找到所有的后继节点
                for(int i : adj.get(tmp_node))
                {
                    rev_adj.get(i).remove(tmp_node);
                    if(rev_adj.get(i).size() == 0)
                    {
                        order.add(i);
                        queue.offerLast(i);
                    }
                }
            }
            if(queue.size()==0)
            {
                // 没有一个元素的入度为0的。
            }
            else{
                final_res++;
            }

        }
        if(N == order.size())
        {
            return final_res;
        }
        else{
            return -1;
        }

    }
}
