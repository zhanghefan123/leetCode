package 图.Dijkstra算法;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        // 创建set集合，其中包含了已经确定最短路的点
        HashSet<Integer> set = new HashSet<>();
        // 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        // 读取点的个数
        int point_count = sc.nextInt();
        // 读取边的个数
        int side_count = sc.nextInt();
        // 进行邻接矩阵的创建
        int[][] neighbour_array = new int[point_count][point_count];
        for(int[] array : neighbour_array)
        {
            Arrays.fill(array,Integer.MAX_VALUE);
        }
        // 进行距离数组的创建
        // distance[i]表示编号i的点到编号0的点的最小距离
        int[] distance = new int[point_count];
        // 到其他点的距离初始化为正无穷
        // 到自身的距离初始化为0
        distance[0] = 0;
        for(int i = 1; i < point_count;i++)
        {
            distance[i] = Integer.MAX_VALUE;
        }
        // 进行边的读取和邻接矩阵的初始化
        for(int i = 0; i < side_count;i++)
        {
            // 我们的点是从0开始编号，才能对应到邻接矩阵，所以这里将读取到的边上的点的坐标
            // 全部进行减一的操作
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int value = sc.nextInt();
            // 图中可能存在重边和自环
            // 1.对于重边的处理，我们仅仅需要保留最小的一条边即可。
            if(neighbour_array[start][end] != 0)
            {
                neighbour_array[start][end] = Math.min(neighbour_array[start][end],value);
            }
            else
            {
                neighbour_array[start][end] = value;
            }
            // 2.对于自环的处理，我们排除自环即可,因为最短路是必然不会在自环之中跑的
            if(start == end)
            {
                continue;
            }
        }

        // 开始进行n次迭代
        for(int count= 0; count < point_count;count++)
        {
            // step1:找到不在s之中的到起始点距离最小的点
            int point = -1;
            int min_distance = Integer.MAX_VALUE;
            for(int i = 0; i < point_count; i++)
            {
                if(!set.contains(i))
                {
                    if(min_distance > distance[i])
                    {
                        point = i;
                        min_distance = distance[i];
                    }
                }
            }
            if(point == -1)
            {
                System.out.println(-1);
                return;
            }
            distance[point] = min_distance;
            // step2:将t添加到集合s之中
            set.add(point);
            // step3:使用t更新其他点(不在s之中的点)
            // 遍历从t出发的所有边,并进行更新
            for(int j = 0; j < point_count; j++)
            {
                if(!set.contains(j) && neighbour_array[point][j] != Integer.MAX_VALUE)
                {
                    if(distance[point] + neighbour_array[point][j] < distance[j])
                    {
                        distance[j] = distance[point] + neighbour_array[point][j];
                    }
                }
            }
        }
        System.out.println(distance[point_count-1]);
    }
}
