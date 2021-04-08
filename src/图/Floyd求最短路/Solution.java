package 图.Floyd求最短路;

import java.util.*;
public class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // n个点
        int n = sc.nextInt();
        // m条边
        int m = sc.nextInt();
        // k个询问
        int q = sc.nextInt();
        // 创建邻接矩阵
        int[][] neighbour_array = new int[n][n];
        // 进行邻接矩阵的初始化
        for(int i = 0; i < n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(i == j)
                {
                    neighbour_array[i][j] = 0;
                }
                else
                {
                    neighbour_array[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // 进行邻接矩阵的填充
        for(int i = 0;i<m;i++)
        {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int value = sc.nextInt();
            // 对于重边，保留最小边即可
            neighbour_array[start][end] = Math.min(value,neighbour_array[start][end]);
        }
        // 按照k,i,j的顺序进行遍历
        for(int k = 0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(neighbour_array[i][k] != Integer.MAX_VALUE && neighbour_array[k][j]!=Integer.MAX_VALUE)
                    {
                        neighbour_array[i][j] = Math.min(neighbour_array[i][j],neighbour_array[i][k] + neighbour_array[k][j]);
                    }
                }
            }
        }
        // 读取用户的输入
        for(int i = 0; i < q;i++)
        {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            if(neighbour_array[start][end] == Integer.MAX_VALUE)
            {
                System.out.println("impossible");
            }
            else
            {
                System.out.println(neighbour_array[start][end]);
            }
        }
    }
}