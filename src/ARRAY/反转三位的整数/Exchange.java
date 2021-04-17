package ARRAY.反转三位的整数;

import java.util.Arrays;

public class Exchange {
    public static void main(String[] args) {
        int[] array = new int[2];
        array[0] = 1;
        array[1] = 2;
        exchange_func(array);
        System.out.println(Arrays.toString(array));
        System.out.println(exchange_three_number(321));
    }
    public static void exchange_func(int[]a)
    {
        int tmp = a[0];
        a[0] = a[1];
        a[1] = tmp;
    }
    public static int exchange_three_number(int n)
    {
        int[] array = new int[3];
        int result = 0;
        for(int i=0;i<3;i++)
        {
            array[i] = n%10;
            n/=10;
            result += array[i]*Math.pow(10,array.length-i-1);
        }
        return result;

    }

}
