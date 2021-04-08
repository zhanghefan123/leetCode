package 图.bellman_ford算法;

import java.util.*;
class Side{
    int start;
    int end;
    int value;
    public Side(int start,int end, int value)
    {
        this.start = start;
        this.end = end;
        this.value = value;
    }

}

class Solution{

    static int n;

    static int m;

    static int k;

    static int[] dist;

    static int[] dist_backup;

    static ArrayList<Side> side_list;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 点的数目
        n = sc.nextInt();
        // 边的数目
        m = sc.nextInt();
        // 最多经过k条边
        k = sc.nextInt();
        // dist数组的创建
        dist = new int[n];
        // 初始的时候将dist全部弄成+∞
        Arrays.fill(dist,Integer.MAX_VALUE);
        // 到达本身的距离为0
        dist[0] = 0;
        // dist数组的备份的创建
        dist_backup = new int[n];
        // 进行每条边的记录
        side_list = new ArrayList<>();
        for(int i = 0;i<m;i++)
        {
            int start = sc.nextInt()-1;
            int end = sc.nextInt()-1;
            int value = sc.nextInt();
            Side side = new Side(start,end,value);
            side_list.add(side);
        }
        // 调用bellman_ford算法
        int t = bellman_ford();
        if(t == -1)
        {
            System.out.println("impossible");
        }
        else
        {
            System.out.println(t);
        }
    }

    public static int bellman_ford()
    {
        // 迭代k次，最多经过k条边
        for(int i = 0;i<k;i++)
        {
            // 不进行备份的时候可能发生串联的情况。
            backup(dist_backup,dist);
            for(Side side : side_list)
            {
                if(dist_backup[side.start] == Integer.MAX_VALUE)
                {
                    continue;
                }
                dist[side.end] = Math.min(dist[side.end],dist_backup[side.start] + side.value);
            }
        }
        // 进行每条边的记录
        if(dist[n-1] == Integer.MAX_VALUE)
        {
            return -1;
        }
        else
        {
            return dist[n-1];
        }
    }

    public static void backup(int[] backup, int[] source)
    {
        for(int i = 0;i < source.length;i++)
        {
            backup[i] = source[i];
        }
    }
}