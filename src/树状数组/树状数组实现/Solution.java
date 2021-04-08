package 树状数组.树状数组实现;

import java.util.*;

public class Solution{

    // 原数组
    public static int[] array;

    // 树状数组
    // tree_array[i] 代表的是原数组上区间[i-lowbit(i),i]上元素的和。
    public static int[] tree_array;

    // 元素个数
    public static int n;


    public static int lowbit(int x)
    {
        return x&-x;
    }

    public static void add(int x, int v)
    {
        // +lowbit(x)就是找父结点
        for(int i = x; i <=n ; i+=lowbit(i))
        {
            tree_array[i] += v;
        }
    }

    public static int query(int x)
    {
        int res = 0;
        for(int i = x; i>0;i-=lowbit(i))
        {
            res += tree_array[i];
        }
        return res;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 原数组的长度
        n = sc.nextInt();
        // 总共存在这么多次操作，0代表求区间和，1代表加上一个数
        int q = sc.nextInt();
        // 读入数组
        array=new int[n+1];
        tree_array=new int[n+1];
        for(int i = 1;i<=n;i++)
        {
            array[i] = sc.nextInt();
        }
        // 通过add操作进行树状数组的构建
        for(int i = 1; i <=n;i++)
        {
            add(i,array[i]);
        }
        // 然后读取操作
        for(int i = 0; i < q;i++)
        {
            int k = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(k == 0)
            {
                System.out.println(query(b) - query(a - 1));
            }
            else
            {
                add(a,b);
            }
        }
    }
}