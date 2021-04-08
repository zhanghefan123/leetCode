package 蓝桥杯.题目_2015.垒骰子;

// 垒骰子

/*

赌圣atm晚年迷恋上了垒骰子，就是把骰子一个垒在另一个上边，不能歪歪扭扭，要垒成方柱体。
经过长期观察，atm 发现了稳定骰子的奥秘：有些数字的面贴着会互相排斥！
我们先来规范一下骰子：1 的对面是 4，2 的对面是 5，3 的对面是 6。
假设有 m 组互斥现象，每组中的那两个数字的面紧贴在一起，骰子就不能稳定的垒起来。 
atm想计算一下有多少种不同的可能的垒骰子方式。
两种垒骰子方式相同，当且仅当这两种方式中对应高度的骰子的对应数字的朝向都相同。
由于方案数可能过多，请输出模 10^9 + 7 的结果。

不要小看了 atm 的骰子数量哦～

「输入格式」
第一行两个整数 n m
n表示骰子数目
接下来 m 行，每行两个整数 a b ，表示 a 和 b 数字不能紧贴在一起。

「输出格式」
一行一个数，表示答案模 10^9 + 7 的结果。

「样例输入」
2 1
1 2

「样例输出」
544

「数据范围」
对于 30% 的数据：n <= 5
对于 60% 的数据：n <= 100
对于 100% 的数据：0 < n <= 10^9, m <= 36

* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public int dice_counts;
    public int restriction_counts;
    public HashMap<Integer, HashSet<Integer>> restrictions;
    public ArrayList<Integer> tmp_res;
    public int final_res;
    public HashMap<Integer,Integer> opposite;

    public Solution(){
        Scanner sc = new Scanner(System.in);
        // 初始化参数
        this.dice_counts = sc.nextInt();
        this.restriction_counts = sc.nextInt();
        this.restrictions = new HashMap<>();
        this.tmp_res = new ArrayList<>();
        this.final_res = 0;
        // 初始化对面
        this.opposite = new HashMap<>();
        this.opposite.put(1,4);
        this.opposite.put(4,1);
        this.opposite.put(2,5);
        this.opposite.put(5,2);
        this.opposite.put(3,6);
        this.opposite.put(6,3);
        // 相当于建立一个骰子面的限制性邻接表
        for(int i = 1; i <= 6; i++)
        {
            restrictions.put(i,new HashSet<>());
        }
        // 为邻接表进行赋值
        for(int i = 0; i < this.restriction_counts;i++)
        {
            int face1 = sc.nextInt();
            int face2 = sc.nextInt();
            this.restrictions.get(face1).add(face2);
            this.restrictions.get(face2).add(face1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.dfs();
        System.out.println(solution.final_res * 16 % 1000000007);
    }


    public void dfs()
    {
        if(tmp_res.size() == this.dice_counts * 2)
        {
            this.final_res++;
            if(this.final_res > 1000000007)
            {
                this.final_res = this.final_res % 1000000007;
            }
            return;
        }
        // 遍历第一面的位置和第二面的位置
        for(int i = 1; i <= 6; i++)
        {
            if(this.tmp_res.isEmpty())
            {
                this.tmp_res.add(i);
                this.tmp_res.add(this.opposite.get(i));
                dfs();
                this.tmp_res.remove(this.tmp_res.size()-1);
                this.tmp_res.remove(this.tmp_res.size()-1);
            }
            else
            {
                // 将最后一面提取出来
                int last_face = this.tmp_res.get(this.tmp_res.size()-1);
                if(restrictions.get(i).contains(last_face)) {
                    continue;
                }
                else
                {
                    this.tmp_res.add(i);
                    this.tmp_res.add(this.opposite.get(i));
                    dfs();
                    this.tmp_res.remove(this.tmp_res.size()-1);
                    this.tmp_res.remove(this.tmp_res.size()-1);
                }
            }
        }
    }
}
