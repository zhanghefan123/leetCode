package 枚举.特别数的和;
import java.util.*;
public class Solution{
    public static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args)
    {
        set.add(2);
        set.add(0);
        set.add(1);
        set.add(9);
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for(int i = 1;i<=n;i++)
        {

            // 将n之中的每一位找出来，看包不包含2,0,1,9
            if(check_if_contains(i))
            {
                res += i;
            }
        }
        System.out.println(res);
    }

    public static boolean check_if_contains(int number)
    {
        while(number > 0)
        {
            // 提取出最后一位
            int last = number % 10;
            if(set.contains(last))
            {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}