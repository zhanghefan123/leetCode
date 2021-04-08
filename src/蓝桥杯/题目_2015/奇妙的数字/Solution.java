package 蓝桥杯.题目_2015.奇妙的数字;

import java.util.HashSet;

// 奇妙的数字
/*
小明发现了一个奇妙的数字，它的平方和立方正好把0-9的10个数字每个用且仅用了一次。
你能猜出这个数字是多少吗。



* */
public class Solution {
    public static void main(String[] args) {
        for(int i = 1;i<100000;i++)
        {
            String s1,s2;
            s1 = String.valueOf(i * i);
            s2 = String.valueOf(i * i * i);
            if(check(s1 + s2))
            {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean check(String s)
    {
        char[] array = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < array.length;i++)
        {
            set.add(array[i]);
        }
        for(int i = 0; i <=9;i++)
        {
            char c = (char)('0' + i);
            if(!set.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
