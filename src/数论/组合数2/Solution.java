package 数论.组合数2;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        int N = 100001;
        int mod = (int)1e9 + 7;
        Scanner sc = new Scanner(System.in);
        // fact[i] 表示的是 i! % mod
        int[] fact = new int[N+1];
        // infact[i]表示的是i! % mod的乘法逆元
        int[] infact = new int[N+1];
        // 进行更新
        for(int i = 0;i<=N;i++)
        {
            // base_case 0!为1,0!的逆元为1
            if(i == 0)
            {
                fact[i] = 1;
                infact[i] = 1;
                continue;
            }
            fact[i] =(int) ((long)fact[i - 1] * i % mod);
            infact[i] = (int) ((long) infact[i - 1] * quick_pow(i, mod - 2, mod ) % mod);
        }
        int n = sc.nextInt();
        for(int i = 0;i < n; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int res = (int) ((long) (fact[a] % mod) * (infact[a - b] % mod) % mod * infact[b] % mod);
            System.out.println(res) ;
        }
    }

    public static long quick_pow(int a,int k,int p)
    {
        long res = 1;
        while( k > 0){
            if( (k & 1) != 0 ) res = res * a % p;
            a =(int) ((long) a * a % p);
            k >>= 1;
        }
        return (int) res;
    }
}
