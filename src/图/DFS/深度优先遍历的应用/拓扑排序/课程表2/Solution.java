package 图.DFS.深度优先遍历的应用.拓扑排序.课程表2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 步骤 1：构建邻接表，反向邻接表
        Set<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }
        int pLen = prerequisites.length;
        for (int i = 0; i < pLen; i++) {
            // 后继课程
            int second = prerequisites[i][0];
            // 先行课程
            int first = prerequisites[i][1];
            // 注意 dfs 中，后继课程作为 key，前驱课程作为 value，这种方式不符合邻接表的习惯，邻接表总是通过前驱得到后继
            adj[second].add(first);
        }

        // 步骤二：对每一个结点执行一次深度优先遍历
        // 0 表示没有访问过，对应于 boolean 数组里的 false
        // 1 表示已经访问过，新增状态，如果 dfs 的时候遇到 1 ，表示当前遍历的过程中形成了环
        // 2 表示当前结点的所有后继结点已经遍历完成，对应于 boolean 数组里的 true
        int[] visited = new int[numCourses];

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            // 对每一个结点执行一次深度优先遍历，如果存在环，则直接返回空数组，即不可能存在一个正常的序列
            if (dfs(i, adj, visited, res)) {
                return new int[]{};
            }
        }
        // 如果不存在环的话，则返回res,这里是一种将list转换称为array的方式
        return res.stream().mapToInt(i -> i).toArray();
    }

    /**
     * @param current
     * @param adj
     * @param visited
     * @param res
     * @return true 表示有环，false 表示没有环
     */
    private boolean dfs(int current, Set<Integer>[] adj,
                        int[] visited, List<Integer> res) {

        //1 表示已经访问过，如果碰到1，则说明已经形成了环。
        if (visited[current] == 1) {
            return true;
        }

        // 碰到2说明这个节点的后继节点已经遍历完成。
        if (visited[current] == 2) {
            return false;
        }

        // 当这个节点visited[current] == 0的时候，将其置为1
        visited[current] = 1;
        // 遍历所有的后继节点
        for (Integer successor : adj[current]) {
            if (dfs(successor, adj, visited, res)) {
                // 如果有环，返回空数组
                return true;
            }
        }

        // 当后继节点都不会出现环的时候，这个节点就是安全的。
        // 注意：在「后序」这个位置添加到结果集
        res.add(current);
        visited[current] = 2;
        // 所有的后继结点都遍历完成以后，都没有遇到重复，才可以说没有环
        return false;
    }

}
