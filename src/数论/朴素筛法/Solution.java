package 数论.朴素筛法;

import java.util.Scanner;

public class Solution {

    // 1 2 3 4 5 6 7 8 9 10
    // 首先 i = 2，因为2是第一个素数，所以4 6 8 10都不是合数
    // 然后 i = 3,因为3是一个素数，所以6 9 都不是素数是合数
    // 然后 i = 4，因为4是合数，所以略过
    // 然后 i = 5,因为5是素数，所以10不是素数是合数

    // 找到素数
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean [] not_prime = new boolean[n+1];
        int count = 0;
        for(int i = 2;i<=n;i++)
        {
            if(!not_prime[i])
            {
                count++;
            }
            for(int j = 2 * i;j<=n;j+=i)
            {
                not_prime[j] = true;
            }
        }
        System.out.println(count);
    }
}
