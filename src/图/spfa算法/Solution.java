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
            int point = queue.pollFirst();
            visited[point] = false;
            // 遍历所有的邻居节点
            if(!map.containsKey(point))
            {
                continue;
            }
            HashSet<End_Point_And_Value> set = map.get(point);
            for(End_Point_And_Value item : set)
            {

                if(dist[point]!=Integer.MAX_VALUE && item.value + dist[point] < dist[item.end])
                {
                    dist[item.end] = item.value + dist[point];
                    if(!visited[item.end])
                    {
                        queue.offerLast(item.end);
                        visited[item.end] = true;
                    }
                }
            }
        }
        if(dist[n-1] == Integer.MAX_VALUE)
        {
            System.out.println("impossible");
        }
        else
        {
            System.out.println(dist[n-1]);
        }
    }
}