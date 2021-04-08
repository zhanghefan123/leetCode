package 数论.X的因子链;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static boolean[] visited;

    public static int[] primes;

    public static int[] min_factors;

    // 获取小于等于n的所有素数
    // 获取小于等于n的所有数的最小质因子
    public static void getPrimes(int n)
    {
        visited = new boolean[n+1];
        primes = new int[n+1];
        min_factors = new int[n+1];
        // 从第一个质数2开始进行遍历
        int count = 0;
        for(int i = 2;i<=n;i++)
        {
            if(!visited[i])
            {
                min_factors[i] = i;
                primes[count++] = i;
            }
            for(int j = 0; primes[j] * i <= n; j++)
            {
                visited[primes[j] * i] = true;
                min_factors[primes[j] * i] = primes[j];
                if(i % primes[j] == 0)
                {
                    break;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x = 0;

        Map<Integer,Integer> factor_to_times = new HashMap<>();
        while(sc.hasNextInt())
        {
            int total = 0;
            x = sc.nextInt();
            getPrimes(x);
            while(x > 1)
            {
                // 取出这个数的最小质因子
                int p = min_factors[x];
                factor_to_times.put(p,0);
                while(x % p==0)
                {
                    x /= p;
                    factor_to_times.put(p,factor_to_times.get(p)+1);
                    total++;
                }
            }
            BigInteger total_factorial = new BigInteger("1");
            for(int i = 1;i<=total;i++)
            {
                total_factorial = total_factorial.multiply(new BigInteger(Integer.toString(i)));
            }
            for(int key: factor_to_times.keySet())
            {
                for(int j = 1; j <= factor_to_times.get(key); j++)
                {
                    total_factorial = total_factorial.divide(new BigInteger(Integer.toString(j)));
                }
            }
            System.out.println(total + " " + total_factorial.toString());
        }
    }
}
