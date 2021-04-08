package 数论.等差数列;

import java.util.Arrays;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int max_value = Integer.MIN_VALUE;
        int min_value = Integer.MAX_VALUE;
        int number_count = sc.nextInt();
        int[] array = new int[number_count];
        for(int i = 0; i < number_count;i++)
        {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);
        // 找到最大值和最小值
        for(int i = 0; i < number_count;i++)
        {
            max_value = Math.max(array[i],max_value);
            min_value = Math.min(array[i],min_value);
        }
        // 如果最大值和最小值相等，说明数全部相等
        if(max_value == min_value)
        {
            System.out.println(number_count);
            return;
        }
        int[] difference = new int[number_count - 1];
        // 进行差值的计算
        for(int i = number_count-1;i>=1;i--)
        {
            difference[i - 1] = array[i] - array[0];
        }
        // 进行最终的结果的返回
        System.out.println((max_value - min_value) / calculate_gcd_from_array(difference) + 1);
    }

    public static int gcd(int a,int b)
    {
        return b!=0 ? gcd(b,a%b) : a;
    }


    // o(nlogn)的时间复杂度
    public static int calculate_gcd_from_array(int [] difference)
    {
        int res = 0;
        for(int i = 0;i < difference.length;i++)
        {
            res = gcd(res,difference[i]);
        }
        return res;
    }
}
