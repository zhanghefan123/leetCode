package 蓝桥杯.题目_2015.方程整数解;
// 方程整数解

import java.lang.annotation.Target;
import java.util.ArrayList;

// 方程:a^2 + b^2 + c^2 = 1000
// 这个方程有正整数解吗？有a,b,c=6，8，30就是一组解，你能算出另一组合适的解吗?
// 请填写解之中最小的数字
// 答案为10
public class Solution {

    public static ArrayList<Integer> list = new ArrayList<>();


    public static void main(String[] args) {
        backTrace(1000);
    }

    public static void backTrace(int target)
    {
        if(target == 0 && list.size() == 3)
        {
            System.out.println(list);
            return;
        }
        else if(target > 0 && list.size() == 3)
        {
            return;
        }
        else if(target < 0)
        {
            return;
        }

        for(int i = 1; i<=31; i++)
        {
            list.add(i);
            backTrace(target - i*i);
            list.remove(list.size()-1);
        }
    }
}
