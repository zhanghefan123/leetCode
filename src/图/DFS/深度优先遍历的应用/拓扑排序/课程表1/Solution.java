package 图.DFS.深度优先遍历的应用.拓扑排序.课程表1;

import java.util.*;

public class Solution {
    // 使用广度优先遍历，综合使用正向邻接表和反向邻接表完成
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 首先通过边表构建邻接表--进行广度优先遍历的时候是正向邻接表
        List<HashSet<Integer>> adj = new ArrayList<>();
        List<HashSet<Integer>> rev_adj = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
        {
            adj.add(new HashSet<>());
            rev_adj.add(new HashSet<>());
        }
        // 进行邻接表的建立
        for(int [] tmp_side : prerequisites)
        {
            int start = tmp_side[1];
            int end = tmp_side[0];
            adj.get(start).add(end);
            rev_adj.get(end).add(start);
        }
        // 进行测试 -- 进行邻接表的打印
        /*
        for(HashSet<Integer> set : adj)
        {
            System.out.println(set);
        }
        */
        // 创建队列
        Deque<Integer> queue = new LinkedList<>();
        // 遍历邻接表--将出度为0的节点加入队列之中
        for(int i = 0; i < numCourses;i++)
        {
            if(rev_adj.get(i).size() == 0)
            {
                queue.offerLast(i);
                res.add(i);
            }
        }

        // 逐步将节点出队
        while(!queue.isEmpty())
        {
            int tmp_node = queue.pollFirst();
            // 找到这个节点的所有的后继节点。
            for(int tmp : adj.get(tmp_node))
            {
                rev_adj.get(tmp).remove(tmp_node);
                if(rev_adj.get(tmp).size()==0)
                {
                    res.add(tmp);
                    queue.offerLast(tmp);
                }
            }
        }
        if(res.size() == numCourses)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
