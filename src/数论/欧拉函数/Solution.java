package 数论.欧拉函数;

import java.util.*;
class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> prime_factor = new ArrayList<>();
        for(int count = 0;count < n;count++)
        {
            // 获取要求欧拉函数的值
            int back_up_number = sc.nextInt();
            int number = back_up_number;
            // 将这个值进行分解质因数
            for(int i = 2;i<=number/i; i++)
            {
                if(number % i == 0)
                {
                    while(number % i == 0)
                    {
                        number = number / i;
                    }
                    prime_factor.add(i);
                }
            }
            if(number>1)
            {
                prime_factor.add(number);
            }
            // 得到分解出的质因数之后使用公式进行计算
            int fai_n = back_up_number;
            for(int i : prime_factor)
            {
                fai_n = fai_n / i * (i-1);
            }
            System.out.println(fai_n);
            prime_factor.clear();
        }

    }
}
