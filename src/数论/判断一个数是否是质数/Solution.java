package 数论.判断一个数是否是质数;

public class Solution {
    // 最简单的按照定义的写法
    public static boolean isPrime(int n)
    {
        if(n < 2)
        {
            return false;
        }
        else{
            // 看其除了1和它本身之外还有没有其他的约数
            for(int i = 2; i < n; i++)
            {
                if(n % i == 0)
                {
                    return false;
                }
            }
            return true;
        }
    }

    // 优化代码
    public static boolean isPrime_optimizer(int n)
    {
        if(n < 2)
        {
            return false;
        }
        else
        {
            for(int i = 2;i <= n / i;i++)
            {
                if(n % i == 0)
                {
                    return false;
                }
            }
            return true;
        }
    }
}
