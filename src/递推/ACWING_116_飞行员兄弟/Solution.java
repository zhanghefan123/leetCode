package 递推.ACWING_116_飞行员兄弟;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution{
    // 用来存储初始的开关列表
    public static char[][] table = new char[4][4];

    // 用来存储备份表
    public static char[][] backup = new char[4][4];



    public static int get_index(int x,int y)
    {
        // 假设x=1,y=3,对应的是op之中的第7位
        return x*4 + y;
    }

    public static void backup_table()
    {
        for(int i = 0;i<4;i++)
        {
            for(int j = 0;j<4;j++)
            {
                backup[i][j] = table[i][j];
            }
        }
    }

    public static void turn(char[][] backup,int x,int y)
    {
        // 将x,y位置进行翻转
        backup[x][y] = (backup[x][y] == '+'?'-':'+');

        // 将这一行的元素和这一列的元素全部进行翻转
        for(int i = 0 ; i < 4; i++)
        {
            if(i == x)
            {
                continue;
            }
            backup[i][y] = (backup[i][y] == '+'?'-':'+');
        }
        for(int i = 0; i < 4; i++)
        {
            if(i == y)
            {
                continue;
            }
            backup[x][i] = (backup[x][i] == '+'?'-':'+');
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<4;i++)
        {
            table[i] = sc.nextLine().toCharArray();
        }
        // 遍历每一种情况
        int situations = 2<<16;
        for(int op = 0;op < situations; op++)
        {
            // 用来进行结果的存储
            ArrayList<int[]> res = new ArrayList<>();
            backup_table();
            // 提取出每一位
            for(int i = 0;i < 4;i++)
            {
                for(int j =0;j<4;j++)
                {
                    // 说明我们需要按下这个开关
                    if(((op >> get_index(i,j)) & 1) == 1)
                    {
                        res.add(new int[]{i,j});
                        turn(backup,i,j);
                    }
                }
            }
            // 枚举所有的开关，是否所有的开关都是处于打开的状态
            if(is_open())
            {
                show_res(res);
                break;
            }
        }
    }

    public static void show_res(ArrayList<int[]> res)
    {
        System.out.println(res.size());
        for(int[] tmp_point : res)
        {
            System.out.println((tmp_point[0]+1) + " " + (tmp_point[1]+1));
        }
    }

    public static boolean is_open()
    {
        for(int i = 0;i<4;i++)
        {
            for(int j = 0;j<4;j++)
            {
                if(backup[i][j] == '+')
                {
                    return false;
                }
            }
        }
        return true;
    }
}