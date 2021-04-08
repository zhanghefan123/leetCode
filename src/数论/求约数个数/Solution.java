package 数论.求约数个数;
import java.util.*;
public class Solution{
    // 分别将a1,a2,……an全部进行分解存到map之中，分解之后再通过公式进行计算。
    public static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int number = 1;
        for(int i = 0;i < n;i++)
        {
            number = sc.nextInt();
            calculate(number);
        }
        long res = 1;
        int mod = 1000000007;
        for(int key : map.keySet())
        {
            res = ((res) * (map.get(key) + 1)) % mod;
        }
        System.out.println(res % mod);
    }

    public static void calculate(int tmp)
    {

        // 分解质因数
        for(int i = 2; i <= tmp/i; i++)
        {
            if(tmp % i == 0)
            {
                int s = 0;
                while(tmp % i == 0)
                {
                    tmp = tmp / i;
                    s++;
                }
                if(map.containsKey(i))
                {
                    map.put(i,map.get(i)+s);
                }
                else
                {
                    map.put(i,s);
                }
            }
        }
        if(tmp > 1)
        {
            if(map.containsKey(tmp))
            {
                map.put(tmp,map.get(tmp)+1);
            }
            else
            {
                map.put(tmp,1);
            }
        }
    }

}
