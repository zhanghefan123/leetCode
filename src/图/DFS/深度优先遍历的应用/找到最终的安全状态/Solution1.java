package 图.DFS.深度优先遍历的应用.找到最终的安全状态;

import java.util.*;

class Solution1 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // 节点个数
        int nodes_count = graph.length;
        // 安全节点
        boolean[] safe = new boolean[nodes_count];
        // 创建邻接表
        ArrayList<Set<Integer>> adj_list = new ArrayList<>();
        // 创建反向邻接表
        ArrayList<Set<Integer>> rev_adj_list = new ArrayList<>();
        // 初始化
        for(int i = 0; i < nodes_count;i++)
        {
            adj_list.add(new HashSet<>());
            rev_adj_list.add(new HashSet<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nodes_count;i++)
        {
            // 没有出边
            if(graph[i].length == 0)
            {
                // 添加到队列之中
                queue.offer(i);
                continue;
            }
            for(int j : graph[i])
            {
                // 正向邻接表从i到j
                adj_list.get(i).add(j);
                // 反向邻接表从j到i
                rev_adj_list.get(j).add(i);
            }
        }
        // 当队列非空的时候开始进行出队删除节点
        while(!queue.isEmpty())
        {
            int cur = queue.poll();
            safe[cur] = true;
            for(int i : rev_adj_list.get(cur))
            {
                // 删除对应的指向这个节点的边
                adj_list.get(i).remove(cur);
                if(adj_list.get(i).size() == 0)
                {
                    queue.add(i);
                }
            }
        }
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < nodes_count; ++i)
        {
            if (safe[i])
            {
                ans.add(i);
            }
        }
        return ans;
    }
}