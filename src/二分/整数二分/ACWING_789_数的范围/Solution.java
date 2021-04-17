package 二分.整数二分.ACWING_789_数的范围;

import java.util.Scanner;

public class Solution {

    public static int[] sorted_array;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sorted_array = new int[n];
        for(int i = 0;i < n; i++)
        {
            sorted_array[i] = sc.nextInt();
        }
        for(int i = 0; i < q;i++)
        {
            int x = sc.nextInt();
            int l = 0;
            int r = n-1;
            while(l < r)
            {
                // 寻找
                int mid = (l+r)/2;
                if(sorted_array[mid] >= x)
                {
                    // r位置可能就是我们的左边界
                    r = mid;
                }
                else
                {
                    // mid位置不可能是我们的左边界，mid+1才有可能是我们的左边界
                    l = mid + 1;
                }

            }
            if(sorted_array[r] == x)
            {
                System.out.print(r + " ");
            }
            else
            {
                System.out.println("-1 -1");
                continue;
            }
            l = r;
            r = n-1;
            while(l < r)
            {
                // 因为是l = mid
                int mid = (l+r+1)/2;
                if(sorted_array[mid] <= x)
                {
                    l = mid;
                }
                else
                {
                    r = mid -1;
                }

            }
            if(sorted_array[r] == x)
            {
                System.out.print(r);
                System.out.println();
            }
        }

    }
}
