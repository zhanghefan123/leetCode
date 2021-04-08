package 图.prim最小生成树算法;
import java.util.*;

class In_Point{
    public int end;
    public int value;
    public In_Point(int end,int value)
    {
        this.end = end;
        this.value = value;
    }
    public String toString()
    {
        return this.end + " " + this.value;
    }
}

public class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 总共有n个点
        int n = sc.nextInt();
        // 总共有m条边
        int m = sc.nextInt();
        // 开始进行prim算法
        // sum存储的是最小生成树的总边长
        int sum = 0;
        // 记录在生成树之中的点
        HashSet<Integer> points_in_tree = new HashSet<>();
        // 初始化到集合的距离为+∞
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        // 开始读取每一条边
        HashMap<Integer,HashSet<In_Point>> map = new HashMap<>();
        for(int i = 0; i < m;i++)
        {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int value = sc.nextInt();
            if(!map.containsKey(u))
            {
                HashSet<In_Point> set = new HashSet<>();
                set.add(new In_Point(v,value));
                map.put(u,set);
            }
            else
            {
                map.get(u).add(new In_Point(v,value));
            }
            if(!map.containsKey(v))
            {
                HashSet<In_Point> set = new HashSet<>();
                set.add(new In_Point(u,value));
                map.put(v,set);
            }
            else
            {
                map.get(v).add(new In_Point(u,value));
            }
        }
        // 开始进行prim算法

        // 遍历n次因为总共存在n个点
        for(int count = 0;count < n; count++)
        {
            // 首先非集合元素到集合的距离最小的点
            int min_point = 0;
            int min_distance = Integer.MAX_VALUE;
            for(int i = 0;i < n;i++)
            {
                if(!points_in_tree.contains(i) && dist[i] < min_distance)
                {
                    min_point = i;
                    min_distance = dist[i];
                }
            }
            // 说明是不连通的图，因为最短距离为+∞
            if(count>0 && min_distance == Integer.MAX_VALUE)
            {
                System.out.println("impossible");
                return;
            }
            if(count > 0)
            {
                sum += min_distance;
            }
            // 将这个点添加到集合之中去
            points_in_tree.add(min_point);
            // 遍历所有其他的不在集合之中的,由min_point发出的边
            HashSet<In_Point> set = map.get(min_point);
            for(In_Point item : set)
            {
                if(!points_in_tree.contains(item.end))
                {
                    dist[item.end] = Math.min(dist[item.end],item.value);
                }
            }
        }
        System.out.println(sum);
    }
}