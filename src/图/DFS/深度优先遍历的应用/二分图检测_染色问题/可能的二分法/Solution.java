package 图.DFS.深度优先遍历的应用.二分图检测_染色问题.可能的二分法;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    // 是否访问过的布尔数组
    public boolean[] visited;
    // 每个人所涂的颜色，总共只能够存在两种颜色
    public int[] colors;
    // 邻接表的创建
    public List<HashSet<Integer>> adj_list;


    public boolean possibleBipartition(int N, int[][] dislikes) {
        // 一系列初始化操作
        this.visited = new boolean[N];
        this.colors = new int[N];
        this.adj_list = new ArrayList<>();
        for(int i = 0;i<N;i++)
        {
            adj_list.add(new HashSet<>());
        }
        for(int[] side : dislikes)
        {
            int i = side[0];
            int j = side[1];
            // 因为是无向图所以邻接表需要两条边
            adj_list.get(i-1).add(j-1);
            adj_list.get(j-1).add(i-1);
        }
        // 遍历所有的洪泛点开始进行洪泛
        for(int i = 0; i < N;i++)
        {
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

    public boolean dfs(int start,int color)
    {
        visited[start] = true;
        colors[start] = color;
        // 遍历所有的邻居
        for(int neighbour : adj_list.get(start))
        {
            // 如果没有访问则进行递归
            if(!visited[neighbour])
            {
                if(!dfs(neighbour,1-color))
                {
                    return false;
                }
            }
            else
            {
                if(colors[neighbour] == (1-color))
                {
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}