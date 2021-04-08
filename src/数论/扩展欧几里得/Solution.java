package 数论.扩展欧几里得;

import java.util.*;
public class Solution{

    public static int x;

    public static int y;

    public static int exgcd(int a,int b)
    {
        if(b==0)
        {
            x = 1;
            y = 0;
            return a;
        }
        // 进行递归
        // exgcd一定已经求出了b的系数，此时为x，a % b的系数y.
        int d = exgcd(b, a % b);
        // 进行换回的操作
        // -------------
        // 此时bx + a % b * y = gcd(a,b)
        // 但是我们要的是x和y，使得a * x + y * b = gcd(a,b)
        // a % b  = a - (a / b) * b
        // 上式变为 bx + [a - (a/b)*b] * y = gcd(a,b);
        // a前的系数为(y) b 前的系数为(x - (a/b)*y);
        int last_x = x;
        int last_y = y;
        y = last_x - (a/b)*last_y;
        x = last_y;

        return d;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i < n; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            exgcd(a,b);
            System.out.println(x + " " + y);
        }
    }
}