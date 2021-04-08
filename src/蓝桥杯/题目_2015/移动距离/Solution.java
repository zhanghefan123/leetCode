package 蓝桥杯.题目_2015.移动距离;
// 移动距离
/*


X星球居民小区的楼房全是一样的，并且按矩阵样式排列。其楼房的编号为1,2,3…
当排满一行时，从下一行相邻的楼往反方向排号。
比如：当小区排号宽度为6时，开始情形如下：

1 2 3 4 5 6
12 11 10 9 8 7
13 14 15 …..

我们的问题是：已知了两个楼号m和n，需要求出它们之间的最短移动距离（不能斜线方向移动）

输入为3个整数w m n，空格分开，都在1到10000范围内
w为排号宽度，m,n为待计算的楼号。
要求输出一个整数，表示m n 两楼间最短移动距离。

例如：
用户输入：
6 8 2
则，程序应该输出：
4

再例如：
用户输入：
4 7 20
则，程序应该输出：
5
* */


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 我们可以为每一个楼栋定位出来它的坐标
        helper();
    }

    public static void helper()
    {
        Scanner sc = new Scanner(System.in);
        double w = sc.nextInt();
        double m = sc.nextDouble();
        double n = sc.nextDouble();
        // 首先计算这个点的横坐标
        int x_of_m = (int)Math.ceil(m/w)-1;
        int x_of_n = (int)Math.ceil(n/w)-1;
        double y_of_m = 0;
        double y_of_n = 0;
        if(x_of_m % 2 == 0)
        {
            y_of_m = m - x_of_m * w - 1;
        }
        else
        {
            y_of_m = (w) - (m - x_of_m * w);
        }
        if(x_of_n % 2 == 0)
        {
            y_of_n = n - x_of_n * w - 1;
        }
        else
        {
            y_of_n = (w) - (n - x_of_n * w);
        }
        int x_distance = Math.abs(x_of_m - x_of_n);
        int y_distance = Math.abs((int)(y_of_m - y_of_n));
        System.out.println(x_distance+y_distance);
    }
}
