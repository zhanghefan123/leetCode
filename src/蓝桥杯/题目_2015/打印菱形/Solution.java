package 蓝桥杯.题目_2015.打印菱形;

// 打印菱形
/*
给出菱形的边长
在控制台上打印出一个菱形来
为了便于比对空格，我们将空格使用句点来进行代替
当边长为8时，菱形为:


*/
public class Solution {
    public static void f(int n)
    {
        // 先行打印中间的一行
        // -----------------------------------
        String s = "*";
        for(int i = 0;i<2 * n-3;i++) s += ".";
        s += "*";
        // -----------------------------------


        String s1 = s + "\n" ;
        String s2 = "";
        for(int i = 0; i < n-1;i++)
        {
            // 填空,
            s = "." + s.substring(0,s.length()-3) + "*";
            // s 是中心行的上一行，若边长为8，则上一行为. * 11个点 *，因为只有单单的一行，所以需要使用s来生成。
            s1 = s + "\n" + s1;
            s2 += s + "\n";
        }
        System.out.println(s1+s2);
    }

    public static void main(String[] args) {
        f(8);
    }
}
