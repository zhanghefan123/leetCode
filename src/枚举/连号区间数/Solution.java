package 枚举.连号区间数;

import java.util.Scanner;

public class Solution{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for(int i = 0;i < N;i++)
        {
            array[i] = sc.nextInt();
        }
        // 双重循环
        int res = 0;
        for(int i = 0; i < N; i++)
        {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = i;j < N;j++)
            {
                min = Math.min(min,array[j]);
                max = Math.max(max,array[j]);
                if((max - min) == (j - i))
                {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}

