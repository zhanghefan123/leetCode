package 贪心.糖果传递;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] array = new long[n+1];
        long sum = 0;
        int avg = 0;
        for(int i = 1;i <= n; i++)
        {
            array[i] = sc.nextInt();
            sum += array[i];
        }
        avg = (int)(sum / n);
        long[] C = new long[n+2];
        // 然后进行的是递归求解C[i];
        C[1] = 0;
        for(int i = n;i>1;i--)
        {
            C[i] = C[i+1] + avg - array[i];
        }
        Arrays.sort(C, 1, n + 1);
        int mid = (n + 1) / 2;
        long final_res = 0;
        for(int i = 1; i < n+1; i++)
        {
            final_res += Math.abs(C[i] - C[mid]);
        }
        System.out.println(final_res);
    }
}
