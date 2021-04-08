package Recursion.汉诺塔问题;

public class Solution {
    // from to help三根杆
    // 我们现在要将n个圆盘从from杆挪动到to这根杆子上

    // 上述的原问题如何划分为子问题
    // step1:将from上面的n-1个圆盘移动到help上
    // step2:将from上面的最后一个圆盘移动到to上，
    // step3:再将help上的n-1个圆盘移动到to上。

    public static void hanoi(int n) {
        if (n > 0) {
            func(n,  "left", "mid", "right");
        }
    }

    public static void func(int rest, String from, String help, String to) {
        // 如果只剩下一个直接移动。
        if (rest == 1) {
            System.out.println("move " + "1" + " from " + from + " to " + to);
        } else {
            func(rest - 1, from, to, help);
            func(1, from, help, to);
            func(rest - 1, help, from, to);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }

}
