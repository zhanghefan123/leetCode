package 图.DFS.深度优先遍历的应用.计算无向图的连通分量;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public ArrayList<ArrayList<Integer>> adj_list;

    public boolean[] visited;

    public int count;

    public int countComponents(int n,int[][] edges)
    {
        // 邻接矩阵的创建
        this.adj_list = new ArrayList<>();
        // 进行布尔数组的初始化,为了保证索引与节点编号一致，所以多声明一个。
        this.visited = new boolean[n];
        // 进行连通分量个数的初始化
        this.count = 0;
        // 进行邻接矩阵的初始化
        for(int i = 0; i < n; i++)
        {
            adj_list.add(new ArrayList<>());
        }
        // 遍历edges进行邻接矩阵的初始化
        for(int [] edge : edges)
        {
            // 没有入点和出点的概念所以要添加两次
            int node1 = edge[0];
            int node2 = edge[1];
            adj_list.get(node1).add(node2);
            adj_list.get(node2).add(node1);
        }
        // 进行洪泛点的遍历
        for(int i = 0; i < n;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                dfs(i);
                this.count++;
            }
        }
        return count;
    }

    // start
    public void dfs(int start)
    {
        // 遍历start的所有邻居
        for(int neighbour : adj_list.get(start))
        {
            if(!visited[neighbour])
            {
                visited[neighbour] = true;
                dfs(neighbour);
            }
        }
    }
}
