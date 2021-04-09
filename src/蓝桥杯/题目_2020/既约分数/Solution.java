package 蓝桥杯.题目_2020.既约分数;

public class Solution {
    public static int gcd(int a,int b)
    {
        return b!=0?gcd(b,a%b):a;
    }

    public static void main(String[] args)
    {
        int res = 0;
        for(int i = 1; i <= 2020; i++)
        {
            for(int j = i;j <= 2020;j++)
            {
                int gcd_number = gcd(i,j);
                if(gcd_number == 1 && i!=j)
                {
                    res+=2;
                }
                else if(gcd_number == 1)
                {
                    res+=1;
                }
            }
        }
        System.out.println(res);
    }
}
