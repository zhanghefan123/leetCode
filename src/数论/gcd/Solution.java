package 数论.gcd;

public class Solution {
    public static int gcd(int a,int b)
    {
        // 如果b为0,那么最大公约数为a,如果b不为0，那么最大公约数为gcd(b, a % b)
        return b != 0 ? gcd(b, a % b) : a;
    }
}
