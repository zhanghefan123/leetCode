package 二分.整数二分.ACWING_730_机器人跳跃问题;

import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height_array = new int[n];
        int max_height = Integer.MIN_VALUE;
        for(int i = 0; i < n;i++)
        {
            height_array[i] = sc.nextInt();
            max_height = Math.max(max_height,height_array[i]);
        }
        int L = 0;
        int R = 100001;
        while(L<R)
        {
            int mid = (L+R) / 2;
            if(check_is_ok(mid,height_array,max_height))
            {
                R = mid;
            }
            else
            {
                L = mid+1;
            }
        }
        System.out.println(L);
    }

    public static boolean check_is_ok(int E,int [] array,int max_height)
    {

        int current = E;
        for(int i = 0; i < array.length; i++)
        {
            current = 2 * current - array[i];
            if(current >= max_height)
            {
                return true;
            }
            if(current < 0)
            {
                return false;
            }
        }
        return true;
    }
}