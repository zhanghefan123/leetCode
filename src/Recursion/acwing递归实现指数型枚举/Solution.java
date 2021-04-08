package Recursion.acwing递归实现指数型枚举;

import java.util.Scanner;
import java.util.ArrayList;
public class Solution {

        // false代表不选，true代表选。
        public static boolean[] choose;

        public static int n;

        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            choose = new boolean[n];
            dfs(0);
        }

        public static void dfs(int index)
        {
            // 当已经枚举完所有的数时候结束
            if(index == n)
            {
                // 将方案进行输出
                for(int i = 0; i < n; i++)
                {
                    if(choose[i])
                    {
                        System.out.print((i+1) + " ");
                    }
                }
                System.out.println();
                return;
            }
            // 分治的过程,回溯到之前需要进行恢复现场
            choose[index] = true;
            dfs(index+1);
            choose[index] = false;

            choose[index] = false;
            dfs(index+1);
            choose[index] = true;
        }
}

