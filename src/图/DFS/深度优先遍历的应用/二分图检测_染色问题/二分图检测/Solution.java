package 图.DFS.深度优先遍历的应用.二分图检测_染色问题.二分图检测;

import java.util.HashSet;

class Solution {

    // 邻接表的备份
    public int[][] graph;
    // 每个节点的颜色
    public int[] colors;
    // 记录这个节点是否被访问过
    boolean[] visited;

    // 判断是否是二分图的函数
    public boolean isBipartite(int[][] graph) {
        HashSet<String> hash = new HashSet<>();
        this.graph = graph;
        int length = graph.length;
        // 结点的编号是从0开始的
        visited = new boolean[length];
        colors = new int[length];
        for(int i = 0;i < length;i++)
        {
            // 注意在进行深度优先搜索进行洪泛前一定要判断是否访问过。
            if(!visited[i])
            {
                if(!dfs(i,1))
                {
                    return false;
                }
            }

        }
        return true;
    }

    // i是结点,color是颜色
    public boolean dfs(int i,int color)
    {
        //为该节点进行颜色的设置
        colors[i] = color;
        //设置该结点已经被访问
        visited[i] = true;
        // 遍历所有的邻居
        for(int neighbour:graph[i])
        {
            if(!visited[neighbour])
            {
                // 总共只能染成两种颜色
                if(!dfs(neighbour,1-color))
                {
                    return false;
                }
            }
            // 当访问过邻居的时候，发现邻居和自己颜色相同则返回false
            else if (colors[i] == colors[neighbour])
            {
                return false;
            }
        }
        return true;
    }
}
