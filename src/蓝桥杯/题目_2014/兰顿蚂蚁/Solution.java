package 蓝桥杯.题目_2014.兰顿蚂蚁;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // m行
        int m = sc.nextInt();
        // j列
        int n = sc.nextInt();
        // 矩阵
        int[][] matrix = new int[m][n];
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }
        // 蚂蚁的起始的位置
        int x = sc.nextInt();
        int y = sc.nextInt();
        // 蚂蚁的朝向
        String s = sc.next();
        // 蚂蚁走的步数
        int k = sc.nextInt();
        int d = getDirection(s);
        // 若蚂蚁在黑格，右转90度，将该格改为白色格子，并向前移动一个格子
        for(int count = 0;count<k;count++)
        {
            if(matrix[x][y] == 1)
            {
                d = d % 4 + 1;
                matrix[x][y] = 0;
                // 上
                if(d == 1)x--;
                // 右
                if(d == 2)y++;
                // 下
                if(d == 3)x++;
                // 左
                if(d == 4)y--;
            }
            else{
                d--;
                if(d == 0)
                {
                    d = 4;
                }
                matrix[x][y] = 1;
                // 上
                if(d == 1)x--;
                // 右
                if(d == 2)y++;
                // 下
                if(d == 3)x++;
                // 左
                if(d == 4)y--;
            }
        }
        System.out.println(x + " " + y);
    }

    // 将字符串转换为数值方便进行转向，进行左转的时候，数字逐步的减少
    // 进行右转的时候数字逐渐的增加
    public static int getDirection(String s)
    {
        if(s.equals("U"))
        {
            return 1;
        }
        else if(s.equals("R"))
        {
            return 2;
        }
        else if(s.equals("D"))
        {
            return 3;
        }
        else
        {
            return 4;
        }
    }
}
