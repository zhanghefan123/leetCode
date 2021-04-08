package 前缀和.K倍区间;

import java.util.*;
public class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] array = new int[N+1];
        array[0] = 0;
        for(int i = 1;i <= N; i++)
        {
            array[i] = array[i-1] + sc.nextInt();
        }
        int count = 0;
        for(int i = 0; i <=N;i++)
        {
            for(int j = i+1;j<=N;j++)
            {
                if((array[j] - array[i]) % K == 0)
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
