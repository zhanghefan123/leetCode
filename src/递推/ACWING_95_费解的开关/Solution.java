package 递推.ACWING_95_费解的开关;

import java.util.Scanner;

public class Solution {
    public static int[][] directions;

    public static void main(String[] args)
    {
        // step 0: 进行方向的声明
        directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        // 进行棋盘备份的声明
        char[][] backup = new char[5][5];

        // step1:进行数据的读取
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while((n--) != 0)
        {
            // 读取完整数之后需要连续两次读取换行
            char[][] array = new char[5][5];
            for(int i = 0; i < 5; i++)
            {
                array[i] = sc.nextLine().toCharArray();
            }
            if(sc.hasNextLine())
            {
                sc.nextLine();
            }
            // step2:进行第一行的枚举
            // 1 2 4 8 16

            // 定义最终结果
            int final_res = 10;
            for(int status = 0; status <= 31; status++)
            {
                // step3:进行棋盘的备份
                backup_process(array,backup);
                // 定义其中一种情况的步数
                int step = 0;
                // step4:进行第一行的操作
                for(int i = 0;i<5;i++)
                {
                    if(((status >> i) & 1) == 1)
                    {
                        step++;
                        turn_light(0,i,backup);
                    }
                }
                // step5:前一行决定后一行的开关操作
                for(int i = 0;i < 4; i++)
                {
                    for(int j = 0;j < 5;j++)
                    {
                        if(backup[i][j] == '0')
                        {
                            turn_light(i+1,j,backup);
                            step++;
                        }
                    }
                }
                // step6:查看最后一行
                boolean isAnyDark = false;
                for(int i = 0;i<5;i++)
                {
                    if(backup[4][i] == '0')
                    {
                        // 这种操作无效
                        isAnyDark = true;
                        break;
                    }
                }
                if(!isAnyDark)
                {
                    final_res = Math.min(step,final_res);
                }
            }
            if(final_res > 6)
            {
                final_res = -1;
            }
            System.out.println(final_res);
        }
    }


    public static void turn_light(int x,int y,char[][] board)
    {
        // 改变x,y位置的元素
        board[x][y] = (board[x][y] == '1' ? '0' : '1');
        for(int[] direction:directions)
        {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(inArea(newX,newY))
            {
                board[newX][newY] = (board[newX][newY] == '1' ? '0' : '1');
            }
        }
    }

    public static boolean inArea(int x,int y)
    {
        return x>=0 && x<5 && y>=0 && y <5;
    }

    public static void backup_process(char[][] array,char[][] backup)
    {
        for(int i = 0; i<5; i++)
        {
            for(int j = 0; j<5; j++)
            {
                backup[i][j] = array[i][j];
            }
        }
    }
}

