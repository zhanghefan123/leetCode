package 二分.整数二分.ACWING_1227_分巧克力;
import java.util.*;
public class Solution{

    public static int[][] height_width_array;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        height_width_array = new int[N][2];
        for(int i = 0;i < N;i++)
        {
            height_width_array[i][0] = sc.nextInt();
            height_width_array[i][1] = sc.nextInt();
        }
        // 最小边长为1
        int l = 1;
        // 最大的话不会超过H,W的最大值
        int r = (int)1e5;
        while(l < r)
        {
            int mid = (l + r + 1) >> 1;
            if(check(mid,k))
            {
                l = mid;
            }
            else
            {
                r = mid - 1;
            }
        }
        System.out.println(l);
    }
    public static boolean check(int mid,int k)
    {
        int sum = 0;
        // 遍历每一块巧克力
        for(int[] array : height_width_array)
        {
            sum += (array[0] / mid) * (array[1] / mid);
            if(sum >= k)
            {
                return true;
            }
        }
        return false;
    }
}