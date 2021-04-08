package 图.DFS.大臣的旅费;
import java.util.*;
import java.math.BigInteger;
public class Solution{

    // 存储最大距离
    public static BigInteger max_distance = new BigInteger("0");

    // 存储距离本点距离最远的一个点
    public static int max_node = 1;

    public static class Neighbour{
        public int node;
        public BigInteger value;
        public Neighbour(int node,BigInteger value)
        {
            this.node = node;
            this.value = value;
        }
    }

    public static HashMap<Integer,HashSet<Neighbour>> map;

    public static void main(String[]args)
    {
        map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 遍历所有的边
        while(sc.hasNextInt())
        {
            int start = sc.nextInt();
            int end = sc.nextInt();
            BigInteger value = new BigInteger(Integer.toString(sc.nextInt()));
            // 记录一条从start出发到end的边
            if(!map.containsKey(start))
            {
                Neighbour cur = new Neighbour(end,value);
                HashSet<Neighbour> set = new HashSet<>();
                set.add(cur);
                map.put(start,set);
            }
            else
            {
                HashSet<Neighbour> set = map.get(start);
                Neighbour cur = new Neighbour(end,value);
                set.add(cur);
            }
            // 记录一条从end出发到达start的边
            if(!map.containsKey(end))
            {
                Neighbour cur = new Neighbour(start,value);
                HashSet<Neighbour> set = new HashSet<>();
                set.add(cur);
                map.put(end,set);
            }
            else
            {
                HashSet<Neighbour> set = map.get(end);
                Neighbour cur = new Neighbour(start,value);
                set.add(cur);
            }
        }
        // 从任意一点开始进行深度优先搜索
        dfs(1,-1,new BigInteger("0"));
        // 然后找到最远的点max_node开始进行查找
        dfs(max_node,-1,new BigInteger("0"));
        // 找到最远的距离之后计算花费
        BigInteger spend = max_distance.multiply(new BigInteger("10")).add(max_distance.multiply(max_distance.add(new BigInteger("1"))).divide(new BigInteger("2")));
        // 输出花销
        System.out.println(spend.toString());
    }

    // 从任意一点开始进行深度优先搜索
    // 为了防止进行重复访问，需要记录父结点是什么
    public static void dfs(int start,int father,BigInteger cur_distance)
    {
        if(max_distance.compareTo(cur_distance) <= 0)
        {
            max_distance = cur_distance;
            max_node = start;
        }
        // 找到这个点对应的邻接表
        HashSet<Neighbour> set = map.get(start);
        // 遍历所有的邻居BigIntger
        for(Neighbour neighbour : set)
        {
            if(neighbour.node!=father)
            {
                dfs(neighbour.node,start,cur_distance.add(neighbour.value));
            }
        }
    }
}
