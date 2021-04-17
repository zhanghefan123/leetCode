package 动态规划.树型动态规划.树的最长路径;

import java.util.*;

class End_Point_And_Value{
    int end_point;
    int value;
    public End_Point_And_Value(int end_point,int value)
    {
        this.end_point = end_point;
        this.value = value;
    }
}

class Solution{

    public static int ans = 0;

    public static HashMap<Integer,HashSet<End_Point_And_Value>> adj_list = new HashMap<>();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 总共存在n个节点
        int n = sc.nextInt();
        // 存储无向有权图
        adj_list = new HashMap<>();
        // 然后进行边的读取
        for(int i = 0; i < n - 1; i++)
        {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            if(!adj_list.containsKey(start))
            {
                HashSet<End_Point_And_Value> set = new HashSet<>();
                set.add(new End_Point_And_Value(end,value));
                adj_list.put(start,set);
            }
            else
            {
                adj_list.get(start).add(new End_Point_And_Value(end,value));
            }
            if(!adj_list.containsKey(end))
            {
                HashSet<End_Point_And_Value> set = new HashSet<>();
                set.add(new End_Point_And_Value(start,value));
                adj_list.put(end,set);
            }
            else
            {
                adj_list.get(end).add(new End_Point_And_Value(start,value));
            }
        }
        // 接着进行的是树型dp
        dfs(1, -1);
        System.out.println(ans);
    }

    // 因为是无向图，走出去了还可以走回来，所以使用father来保证不会走回头路
    public static int dfs(int start_node,int father)
    {
        // 不包含根节点在内的最长路径
        int d1 = 0;
        // 不包含根节点在内的次长路径
        int d2 = 0;
        for(End_Point_And_Value son_point : adj_list.get(start_node))
        {
            // 不走回头路
            if(son_point.end_point == father)
            {
                continue;
            }
            int current = dfs(son_point.end_point,start_node) + son_point.value;
            if(d1 < current)
            {
                d2 = d1;
                d1 = current;
            }
            else if(current > d2)
            {
                d2 = current;
            }
        }
        // 然后找到包含这个节点的根节点在内的最长路径
        ans = Math.max(ans, d1 + d2);
        return d1;
    }
}

