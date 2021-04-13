package 数论.容斥原理.能被整除的数;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 总共存在1~n个整数
        int n = sc.nextInt();
        // 一共存在m个质数
        int m = sc.nextInt();
        // 创建数组存储m个质数
        int[] array = new int[m];
        for(int i = 0; i < m;i++)
        {
            array[i] = sc.nextInt();
        }
        int res = 0;
        // 一个i代表一种集合,如果集合之中的1为奇数则代表正数
        // 如果集合中的1为偶数则代表为负数
        for(int i = 1; i < 1 << m; i++)
        {
            int t = 1;
            int count = 0;
            for(int j = 0;j<m;j++)
            {
                if(((i >> j) & 1) == 1)
                {
                    count++;
                    if((long)t * array[j] > n)
                    {
                        t = -1;
                        break;
                    }
                    else
                    {
                        t = t * array[j];
                    }
                }
            }
            if(t!=-1)
            {
                if(count % 2 != 0)
                {
                    res += n/t;
                }
                else
                {
                    res -= n/t;
                }
            }
        }
        System.out.println(res);
    }
}
