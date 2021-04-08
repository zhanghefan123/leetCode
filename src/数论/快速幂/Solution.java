package 数论.快速幂;

import java.util.*;
public class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++)
        {
            long a = sc.nextLong();
            int k = sc.nextInt();
            int p = sc.nextInt();
            System.out.println(quick_pow(a,k,p));
        }
    }

    public static long quick_pow(long a,int k,int p)
    {
        long res = 1;
        while(k!=0)
        {
            if((k & 1) == 1)
            {
                res = (res * a) % p;
            }
            a = (a * a) % p;
            k = k>>1;
        }
        return res;
    }
}
