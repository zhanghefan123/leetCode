package 蓝桥杯.题目_2014.神奇的算式;
// 神奇的算式

/*
由4个不同的数字，组成的一个乘法算式，他们的乘积仍然是由这四个数字组成
比如：
210 * 6 = 1260
8 * 473 = 3784
27 * 81 = 2187
都符合要求。
如果满足乘法交换率的算式算作同一种情况，那么包含上边已经列出的三种情况，一共
有多少种满足要求的算式.
* */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        // 枚举四位数使用四重循环
        // 第一位数只能是1-9而不能是0
        int count = 0;
        for(int i = 1; i <= 9; i++)
        {
            for(int j = 0; j <= 9;j++)
            {
                if(j != i)
                {
                    for(int k = 0;k<=9;k++)
                    {
                        if(k!=i && k !=j)
                        {
                            for(int l = 0;l<10;l++)
                            {
                                if(l != i && l != j && l != k)
                                {
                                    // 验证这个数是否是由i,j,k,l四个数组成
                                    int value  = i * (j * 100 + k * 10 + l);
                                    if(compose(value,i,j,k,l))
                                    {
                                        count++;
                                    }
                                    if(k!=0)
                                    {
                                        value = (i * 10 + j) * (k * 10 + l);
                                        if(compose(value,i,j,k,l))
                                        {
                                            count++;
                                        }
                                    }
                                    if(l!=0) {
                                        value = (i * 100 + j * 10 + k) * l;
                                        if (compose(value, i, j, k, l)) {
                                            count++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count / 2);
    }

    public static boolean compose(int value,int i,int j,int k, int l)
    {
        String tmp = String.valueOf(value);
        char[] tmp_char_array = tmp.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for(int x = 0;x < tmp_char_array.length; x++)
        {
            set.add(tmp_char_array[x]);
        }
        char c1 = (char)('0'+i);
        char c2 = (char)('0'+j);
        char c3 = (char)('0'+k);
        char c4 = (char)('0'+l);
        return set.contains(c1) && set.contains(c2) && set.contains(c3) && set.contains(c4);
    }

}
