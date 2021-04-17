package 树状数组.数星星;

import java.util.Scanner;

public class Solution {

    public static int[] tree_array;

    public static int[] level_count;

    public static int low_bit(int x)
    {
        return x & -x;
    }

    public static void add(int index,int value)
    {
        for(int i = index;i < tree_array.length; i+=low_bit(i))
        {
            tree_array[i]+=value;
        }
    }

    public static int prefix_sum(int index)
    {
        int result = 0;
        for(int i = index;i>0;i-=low_bit(i))
        {
            result += tree_array[i];
        }
        return result;
    }

    public static void main(String[] args)
    {
        tree_array = new int[32002];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        level_count = new int[N];
        for(int i = 0; i < N; i++)
        {
            // 注意进行+1的操作，因为树状数组不允许索引为1的情况的出现。
            int x = sc.nextInt() + 1;
            int y = sc.nextInt();
            int level = prefix_sum(x);
            level_count[level]++;
            add(x,1);
        }
        for(int item : level_count)
        {
            System.out.println(item);
        }
    }
}
