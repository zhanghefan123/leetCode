package 二分.实数二分.数的三次方根;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double L = -10000;
        double R = 10000;
        while(Math.abs(L-R)>1e-8)
        {
            double M = (L + R) / 2;
            if(M * M * M >= n)
            {
                R = M;
            }
            else
            {
                L = M;
            }
        }
        System.out.printf("%.6f\n",L);
    }
}
