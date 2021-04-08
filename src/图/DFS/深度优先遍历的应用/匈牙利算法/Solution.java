package 图.DFS.深度优先遍历的应用.匈牙利算法;

import java.util.*;
public class Solution{

    public static HashMap<Integer,HashSet<Integer>> map;

    public static int[] match;

    public static boolean[] consider;

    public static boolean find(int x)
    {
        // 遍历自己所喜欢的女孩
        HashSet<Integer> set = map.get(x);
        for(int i : set)
        {
            // 如果这个女孩没有考虑过
            if(!consider[i])
            {
                // 那么就考虑这个女孩
                consider[i] = true;
                // 如果这个女孩没有心仪的男生
                if(match[i] == -1 || find(match[i]))
                {
                    match[i] = x;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 左侧男孩个数
        int boys = sc.nextInt();
        // 右侧女孩个数
        int girls = sc.nextInt();
        // 存储变数
        int side_count = sc.nextInt();
        // 所有女孩是否已经被考虑过了
        consider = new boolean[girls];
        // 女孩匹配的男生
        match = new int[girls];
        // 没有一个女生有心仪的男生
        Arrays.fill(match,-1);
        // 存储从左向右的单向邻接表
        map = new HashMap<>();
        for(int i = 0;i < side_count;i++)
        {
            int left = sc.nextInt()-1;
            int right = sc.nextInt()-1;
            if(!map.containsKey(left))
            {
                HashSet<Integer> set = new HashSet<>();
                set.add(right);
                map.put(left,set);
            }
            else
            {
                map.get(left).add(right);
            }
        }
        int res = 0;
        // 从上到下遍历所有的男孩
        for(int i = 0;i<boys;i++)
        {
            Arrays.fill(consider,false);
            // 如果这个男生找到了res++
            if(find(i))
            {
                res++;
            }
        }
        System.out.println(res);
    }
}