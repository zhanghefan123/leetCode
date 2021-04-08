package 蓝桥杯.题目_2015.循环节长度;

// 循环节长度

//两个整数做除法，有时会产生循环小数，其循环部分称为：循环节。
//比如，11/13=6=>0.846153846153.....  其循环节为[846153] 共有6位。
//下面的方法，可以求出循环节的长度。


// 请仔细阅读代码，并填写划线部分缺少的代码。

import java.util.Vector;

public class Solution {
    public static int f(int n,int m)
    {
        n = n % m;
        Vector v = new Vector();
        for(;;)
        {
            v.add(n);
            n *= 10;
            n = n % m;
            if(n == 0) return 0;
            // 当余数重新出现的时候
            if(v.indexOf(n) > 0)
            {
                // 填空
                return v.size() - v.indexOf(n);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(f(7,18));
    }
}
