package 图.DFS;

import java.awt.font.NumericShaper;
import java.util.ArrayList;

/*
 寒假作业

 现在小学的数学题目也不是那么好玩的。
 看看这个寒假作业：

 □ + □ = □
 □ - □ = □
 □ × □ = □
 □ ÷ □ = □

 (如果显示不出来，可以参见【图1.jpg】)

 每个方块代表1~13中的某一个数字，但不能重复。
 比如：
 6  + 7 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5

 以及：
 7  + 6 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5

 就算两种解法。（加法，乘法交换律后算不同的方案）

 你一共找到了多少种方案？


 请填写表示方案数目的整数。
 注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。

 */
public class Homework {
    private static int result = 0;
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        boolean[] visited = new boolean[14];
        resultList(new ArrayList<>(),visited);
        System.out.print(result);

 }
    //cur表示的是当前的排列。visited是已经用过的元素。
    public static void resultList(ArrayList<Integer> cur,boolean[] visited)
    {
        if(cur.size() == 3)
        {
            if(!testSequence(cur,3))
            {
                return;
            }
        }
        else if(cur.size() == 6)
        {
            if(!testSequence(cur,6))
            {
                return;
            }
        }
        else if(cur.size() == 9)
        {
            if(!testSequence(cur,9))
            {
                return;
            }
        }
        if(cur.size() == 12)
        {
            if(testSequence(cur,12))
            {
                result++;
            }
        }
        for(int i = 1;i<=13;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                cur.add(i);
                resultList(cur,visited);
                visited[i] = false;
                cur.remove(cur.size()-1);
            }
        }
    }

    public static boolean testSequence(ArrayList<Integer> cur,int number) {
        if (number == 3) {
            boolean flag1 = (cur.get(0) + cur.get(1) == cur.get(2));
            if (!flag1) {
                return false;
            } else {
                return true;
            }
        } else if (number == 6) {
            boolean flag2 = (cur.get(3) - cur.get(4) == cur.get(5));
            if (!flag2) {
                return false;
            } else {
                return true;
            }
        } else if (number == 9) {
            boolean flag3 = (cur.get(6) * cur.get(7) == cur.get(8));
            if (!flag3) {
                return false;
            } else {
                return true;
            }
        } else if(number == 12){
            if (cur.get(9) % cur.get(10) == 0) {
                if (cur.get(9) / cur.get(10) == cur.get(11)) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
