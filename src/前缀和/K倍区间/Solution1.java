package 前缀和.K倍区间;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long[] array = new long[N+1];
        array[0] = 0;
        for(int i = 1;i <= N; i++)
        {
            array[i] = array[i-1] + sc.nextLong();
        }

        long count = 0;
        int[] cnt = new int[K];
        cnt[0] = 1;
        for(int i = 1; i <=N;i++)
        {
            count += cnt[(int)(array[i] % K)];
            cnt[(int)(array[i] % K)]++;
        }
        System.out.println(count);
    }
}
