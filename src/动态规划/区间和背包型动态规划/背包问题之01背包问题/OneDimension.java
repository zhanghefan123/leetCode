package 动态规划.区间和背包型动态规划.背包问题之01背包问题;

import java.util.*;
public class OneDimension {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int [] volume_of_stuffs = new int[N];
        int [] value_of_stuffs = new int[N];
        int [] helper = new int[V+1];
        for(int i = 0;i < N ; i++)
        {
            volume_of_stuffs[i] = sc.nextInt();
            value_of_stuffs[i] = sc.nextInt();
        }
        // 对于物品进行循环
        for(int i = 1; i <=N; i++)
        {
            for(int j = V;j>=volume_of_stuffs[i-1];j--)
            {
                // 因为是从大到小进行遍历，所以左侧的helper[j]是新生的helper[j]而max之中的helper[j]则是老的helper[j]
                helper[j] = Math.max(helper[j],helper[j-volume_of_stuffs[i-1]] + value_of_stuffs[i-1]);
            }
        }
        System.out.println(helper[V]);
    }
}
