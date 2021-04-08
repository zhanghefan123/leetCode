package 蓝桥杯.题目_2016.取球博弈;

import java.util.Arrays;
import java.util.Scanner;

// 题目:
/*
取球博弈
两个人玩取球的游戏。
一共有N个球，每人轮流取球，每次可取集合{n1,n2,n3}中的任何一个数目。
如果无法继续取球，则游戏结束。
此时，持有奇数个球的一方获胜。
如果两人都是奇数，则为平局。

假设双方都采用最聪明的取法，
第一个取球的人一定能赢吗？
试编程解决这个问题。

输入格式：
第一行3个正整数n1 n2 n3，空格分开，表示每次可取的数目 (0<n1,n2,n3<100)
第二行5个正整数x1 x2 ... x5，空格分开，表示5局的初始球数(0<xi<1000)

输出格式：
一行5个字符，空格分开。分别表示每局先取球的人能否获胜。
能获胜则输出+，
次之，如有办法逼平对手，输出0，
无论如何都会输，则输出-
例如，输入：
1 2 3
1 2 3 4 5
程序应该输出：
+ 0 + 0 -
再例如，输入：
1 4 5
10 11 12 13 15
程序应该输出：
0 - 0 + +
再例如，输入：
2 3 5
7 8 9 10 11
程序应该输出：
+ 0 0 0 0
* */
public class Solution {

    public static int[]n;
    // 算法思路
    // 假设现在含有N个球,每次可取集合{n1,n2,n3}
    // 那么我可以让对手面对的局面有{N-n1,N-n2,N-n3}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = new int[3];
        for(int i = 0;i<3;i++)
        {
            n[i] = sc.nextInt();
        }
        Arrays.sort(n);
        for(int i = 0;i<5;i++)
        {
            int num = sc.nextInt();
            char res = f(num,0,0);
            System.out.print(res + " ");
        }
        System.out.println();
    }

    public static char f(int num, int me, int you)
    {
        // base case
        if(num < n[0])
        {
            if((me & 1)==1 && (you & 1)==0)
            {
                return '+';
            }
            else if((me & 1) == 0 && (you & 1) == 1)
            {
                return '-';
            }
            else
            {
                return '0';
            }
        }
        boolean ping = false;
        for(int i = 0;i<3;i++)
        {
            if(num >= n[i])
            {
                // 注意身份的交换
                char res = f(num-n[i],you,me+n[i]);
                // 首先判断是否会让对手输，能输则输
                if(res == '-')
                {
                    return '+';
                }
                if(res == '0')
                {
                    ping = true;
                }
            }
        }
        if(ping)
        {
            return '0';
        }
        else
        {
            return '-';
        }
    }
}
