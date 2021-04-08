package 数论.求乘法逆元;

import java.util.*;
public class Solution
{
    public static int gcd(int a, int b)
    {
        return b!=0?gcd(b,a % b):a;
    }

    public static long quick_pow(int a,int k,int p)
    {
        long a_tmp = (long)a;
        long res = 1;
        while(k!=0)
        {
            if((k & 1) == 1)
            {
                res = (res * a_tmp) % p;
            }
            a_tmp = (a_tmp * a_tmp) % p;
            k = k >> 1;
        }
        return res;
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for(int i = 0;i < count; i++)
        {
            int a = sc.nextInt();
            int n = sc.nextInt();
            if(gcd(a,n) != 1)
            {
                System.out.println("impossible");
            }
            else
            {
                System.out.println(quick_pow(a,n-2,n));
            }
        }
    }
}
