package 数论.线性筛法;

public class Solution {
    public static int N = 100;
    public static int[] primes = new int[N+1];
    public static boolean[] visited = new boolean[N+1];
    public static int[] min_factors = new int[N+1];

    public static void get_primes(int n)
    {
        int count = 0;
        for(int i = 2;i<=n;i++)
        {
            if(!visited[i])
            {
                min_factors[i] = i;
                primes[count++] = i;
            }
            for(int j = 0;primes[j] * i <= n; j++)
            {
                visited[primes[j] * i] = true;
                min_factors[primes[j] * i] = primes[j];
                if(i % primes[j] == 0)  break;
            }
        }
        for(int i = 0;i<n;i++)
        {
            System.out.println(min_factors[i]);
        }
    }

    public static void main(String[] args) {
        get_primes(20);
    }
}
