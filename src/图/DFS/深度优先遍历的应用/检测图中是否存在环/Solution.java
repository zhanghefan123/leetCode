package 图.DFS.深度优先遍历的应用.检测图中是否存在环;
import java.util.*;
// 算法思想
/*
遍历每一条边，如果这条边之中的两个节点都在图之中。则判断这两个点之间是否已经存在了一条路径。
如果已经存在了一条路径则返回这条冗余的边。

如果这条边之中存在一个节点不在图之中，则向图中添加这条边。


* */
public class Solution {

    // 邻接表
    private Map<Integer, List<Integer>> graph;
    // 访问过的节点。
    private Set<Integer> visited;

    public int[] findRedundantConnection(int[][] edges) {
        this.graph = new HashMap<>();
        this.visited = new HashSet<>();

        // 遍历每一条边
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (graph.containsKey(u) && graph.containsKey(v)) {
                visited.clear();
                // 深度优先遍历该图，判断 u 到 v 之间是否已经存在了一条路径
                if (dfs(u, v)) {
                    return edge;
                }
            }
            // 所有相邻顶点都找不到回路，才向图中添加这条边，由于是无向图，所以要添加两条边
            addEdge(u, v);
            addEdge(v, u);
        }
        return null;
    }

    private void addEdge(int u, int v) {
        // 当邻接表之中存在u起始v结束的边。
        if (graph.containsKey(u)) {
            graph.get(u).add(v);
            return;
        }
        // 当邻接表之中不存在u起始的边
        List<Integer> successors = new ArrayList<>();
        successors.add(v);
        graph.put(u, successors);
    }


    /**
     * 从 source 开始进行深度优先遍历，看看是不是能够找到一条到 target 的回路
     *
     * @param source
     * @param target
     * @return 找不到回路返回 false
     */
    private boolean dfs(int source, int target) {
        if (source == target) {
            return true;
        }
        visited.add(source);
        // 遍历 source 的所有相邻顶点
        for (int adj : graph.get(source)) {
            if (!visited.contains(adj)) {
                if (dfs(adj, target)) {
                    return true;
                }
            }
        }
        // 所有相邻顶点都找不到，才能返回 false
        return false;
    }
}
