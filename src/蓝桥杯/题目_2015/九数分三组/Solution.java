package 蓝桥杯.题目_2015.九数分三组;

import java.util.ArrayList;

// 九数分三组
/*
1-9的数字可以组成三个三位数，设为A,B,C，现在要求满足如下的条件
B = 2 * A
C = 3 * A

* */
public class Solution {

    public static boolean[] visited = new boolean[10];

    public static ArrayList<Integer> list = new ArrayList<>();

    // 将1-9进行全排列之后分成三段
    public static void main(String[] args) {
        permutations();
    }

    public static void permutations()
    {
        if(list.size() == 9)
        {
            int a = list.get(0) * 100 + list.get(1) * 10 + list.get(2);
            int b = list.get(3) * 100 + list.get(4) * 10 + list.get(5);
            int c = list.get(6) * 100 + list.get(7) * 10 + list.get(8);
            if(2 * a == b && 3 * a == c)
            {
                System.out.println(a+" "+b+" "+c);
            }
            return;
        }
        for(int i = 1;i<=9;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                list.add(i);
                permutations();
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }

    }
}
