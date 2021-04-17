package 图.spfa算法;
import java.util.*;

class End_Point_And_Value{
    public int end;
    public int value;
    public End_Point_And_Value(int end, int value)
    {
        this.end = end;
        this.value = value;
    }

    public String toString()
    {
        return new String(end + " " + value);
    }
}

class Main{

    public static HashMap<Integer,HashSet<End_Point_And_Value>> map;

    public static int[] dist;

    public static boolean[] visited;

    public static void main(String [] args)
    {
        map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n];
        dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        for(int i = 0;i < m; i++)
        {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int value = sc.nextInt();
            End_Point_And_Value item = new End_Point_And_Value(end,value);
            if(!map.containsKey(start))
            {
                HashSet<End_Point_And_Value> set = new HashSet<>();
                set.add(item);
                map.put(start,set);
            }
            else
            {
                map.get(start).add(item);
            }
        }
        Deque<Integer> queue = new LinkedList<>();
        queue.offerLast(0);
        visited[0] = true;
        while(!queue.isEmpty())
        {
            // 在队列之中存储的是从起点到这个点的距离发生了更新的结点
            int point = queue.pollFirst();
            visited[point] = false;
            // 遍历所有的邻居节点
            // 如果没有邻居则结束本次循环，再从队列之中弹出一个元素
            if(!map.containsKey(point))
            {
                continue;
            }
            // 找到这个点的邻居，因为到这个点的距离发生了更新，到邻居的距离可能发生了更新
            HashSet<End_Point_And_Value> set = map.get(point);
            for(End_Point_And_Value item : set)
            {
                // 如果这个点的距离!=Integer.MAX_VALUE，并且到邻居点的距离+到自身的距离 < 原先到达邻居点的距离
                // 就进行更新。
                if(dist[point]!=Integer.MAX_VALUE && item.value + dist[point] < dist[item.end])
                {
                    dist[item.end] = item.value + dist[point];
                    // 如果这个被更新的结点还不在队列之中的话则将其加入队列之中从而更新其他的结点。
                    // 注意：其中的visited数组可以换成queue.contains()
                    if(!visited[item.end])
                    {
                        queue.offerLast(item.end);
                        visited[item.end] = true;
                    }
                }
            }
        }
        // 如果到最后一个结点的距离没有被更新过，则说明无法到达
        if(dist[n-1] == Integer.MAX_VALUE)
        {
            System.out.println("impossible");
        }
        // 否则返回到最后一个结点的拘留
        else
        {
            System.out.println(dist[n-1]);
        }
    }
}