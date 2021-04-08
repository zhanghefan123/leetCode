package 数论.高斯消元解线性方程组;

import java.util.*;
public class Solution{

    public static double[][] array;

    public static double eps = 1e-6;

    public static int n;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        array = new double[n][n+1];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0;j < n + 1; j++)
            {
                array[i][j] = sc.nextDouble();
            }
        }
        int t = gauss();
        if(t == 0)
        {
            // 打印最后一列
            for(int i = 0;i < n;i++)
            {
                System.out.printf("%.2f\n",array[i][n]);
            }
        }
        else if (t == 1)
        {
            System.out.println("Infinite group solutions");
        }
        else
        {
            System.out.println("No solution");
        }
    }

    public static int gauss()
    {
        // 遍历每一列(这些列是系数列，不包含b列)
        // 此处的col是当前正在处理的列
        // 此处的row是当前正在处理的行
        int col;
        int row;
        for(col = 0,row = 0;col < n;col++)
        {
            // 找到出现的最大值
            int max_row = row;
            for(int i = row; i < n; i++)
            {
                if(Math.abs(array[i][col]) > Math.abs(array[max_row][col]))
                {
                    max_row = i;
                }
            }
            if(Math.abs(array[max_row][col]) < eps)
            {
                continue;
            }
            // 从col开始进行遍历进行两行的交换,因为col是第一个数
            for(int i = col;i <= n;i++)
            {
                double tmp = array[max_row][i];
                array[max_row][i] = array[row][i];
                array[row][i] = tmp;
            }
            // 将等式两边同时除以第一个数
            for(int i = n;i>=col;i--)
            {
                array[row][i] /= array[row][col];
            }
            // 将其余的式子根据第一个式子将第一个数消为0
            for(int i = row+1;i<n; i++)
            {
                if(Math.abs(array[i][col]) > eps)
                {
                    for(int j = n;j >= col;j--)
                    {
                        array[i][j] -= array[row][j] * array[i][col];
                    }
                }
            }
            row++;
        }

        if(row < n)
        {
            for(int i = row; i < n;i++)
            {
                if(Math.abs(array[i][n]) > eps)
                {
                    // 说明是无解的
                    return 2;
                }
            }
            // 有无穷多组解
            return 1;
        }

        // 倒着将方程消一遍
        for(int i = n -1;i>=0;i--)
        {
            for(int j = i+1;j<n;j++)
            {
                array[i][n] -= array[i][j] * array[j][n];
            }
        }
        // 有唯一解
        return 0;
    }
}
