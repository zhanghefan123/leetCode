package 贪心.货仓选址;

import java.util.*;
public class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0;i < n;i++)
        {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        // 找到中位数
        int mid_index = n / 2;
        int total_distance = 0;
        for(int i = 0; i < n;i++)
        {
            total_distance += Math.abs(array[i] - array[mid_index]);
        }
        System.out.println(total_distance);
    }
}
