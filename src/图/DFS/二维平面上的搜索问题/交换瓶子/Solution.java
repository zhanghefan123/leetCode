package 图.DFS.二维平面上的搜索问题.交换瓶子;
import java.util.*;
class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n;i++)
        {
            array[i] = sc.nextInt() - 1;
        }
        // 创建一个布尔数组
        boolean[] visited = new boolean[n];
        // 遍历每一个洪泛点开始进行遍历，将能遍历到的点全部置为true
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            if(!visited[array[i]])
            {
                visited[array[i]] = true;
                count++;
                // 当前的数是current
                int current = array[i];
                // current应该在的位置上的瓶子
                int supposed_to_be = array[current];
                while(supposed_to_be!=current)
                {
                    visited[supposed_to_be] = true;
                    supposed_to_be = array[supposed_to_be];
                }
            }
        }
        System.out.println(n - count);
    }
}