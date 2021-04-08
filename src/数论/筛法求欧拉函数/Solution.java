package 数论.筛法求欧拉函数;

import java.util.Scanner;

public class Solution {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean [] visited = new boolean[n+1];
        int[] primes = new int[n+1];
        int count = 0;
        int[] phi = new int[n+1];
        phi[1] = 1;
        for(int i = 2; i <= n;i++)
        {
            if(!visited[i])
            {
                primes[count++] = i;
                phi[i] = i-1;
            }
            for(int j = 0; primes[j] * i <= n; j++)
            {
                visited[primes[j] * i] = true;
                if(i % primes[j] == 0)
                {
                    phi[primes[j] * i] = phi[i] * primes[j];
                    break;
                }
                phi[primes[j] * i] = phi[i] * (primes[j] - 1);
            }
        }
        long res = 0;
        for(int i = 1;i<=n;i++)
        {
            res += phi[i];
        }
        System.out.println(res);
    }
}
