package 数论.质因数分解;

public class Solution {
    public static void divide(int n)
    {
        for(int i = 2; i<=n; i++)
        {
            if(n % i == 0)
            {
                int s = 0;
                while(n % i == 0)
                {
                    n = n / i;
                    s++;
                }
                System.out.println(i+"^"+s);
            }
        }
    }

    public static void divide_optimizer(int n)
    {
        for(int i = 2; i<=n/i; i++)
        {
            if(n % i == 0)
            {
                int s = 0;
                while(n % i == 0)
                {
                    n = n / i;
                    s++;
                }
                System.out.println(i+"^"+s);
            }
        }
        if(n > 1)
        {
            System.out.println(n+"^"+1);
        }
    }

    public static void main(String[] args) {
        divide(4);
        divide_optimizer(5);
    }
}
