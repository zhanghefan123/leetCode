package HASH.ACWING_1221_四平方和;

import java.util.*;
public class Solution{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int c = 0; c * c <= N;c++)
        {
            for(int d = c; c * c + d * d <= N;d++)
            {
                int current_value = c * c + d * d;
                if(!map.containsKey(current_value))
                {
                    map.put(current_value, new int[]{c,d});
                }
            }
        }
        // 然后进行a,b的遍历
        for(int a = 0; a*a <=N;a++)
        {
            for(int b = a; a * a + b * b<=N;b++)
            {
                int fit = N - a * a - b * b;
                if(map.containsKey(fit))
                {
                    int[]array = map.get(fit);
                    show(new int[]{a,b,array[0],array[1]});
                    return;
                }
            }
        }
    }

    public static void show(int[] array)
    {
        for(int i : array)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}