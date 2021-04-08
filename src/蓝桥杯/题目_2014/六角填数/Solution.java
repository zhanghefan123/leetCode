package 蓝桥杯.题目_2014.六角填数;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
// https://www.bilibili.com/video/BV1wb411q73x?p=12
// 六角填数
/*
如图所示六角形之中，填入1-12的数字
使得每条直线上的数字之和相同
图中，已经替你填好了三个数字，请你计算星号位置所代表的数字是多少？
* */
public class Solution {

    public static List<List<Integer>> res;
    public static boolean[] visited;
    public static List<Integer> tmp_res;
    public static int count = 0;


    // 思路=将除了已经填好了数字抽离出来然后进行全排列，选出符合要求的即可
    public static void main(String[] args) {
        tmp_res = new ArrayList<>();
        res = new ArrayList<>();
        visited = new boolean[13];
        HashSet<Integer> set_used = new HashSet<>();
        set_used.add(1);
        visited[1] = true;
        set_used.add(3);
        visited[3] = true;
        set_used.add(8);
        visited[8] = true;
        HashSet<Integer> set_unused = new HashSet<>();
        for(int i = 1; i<=12; i++)
        {
            if(!set_used.contains(i)) {
                set_unused.add(i);
            }
        }
        permutations(set_unused);
        System.out.println(count);
    }

    public static void permutations(HashSet<Integer> set) {
        if (set.size() == tmp_res.size())
        {
            if(check(tmp_res))
            {
                System.out.println(tmp_res);
                count++;
            }
            return;
        }
        for(int tmp : set)
        {
            if(!visited[tmp])
            {
                visited[tmp] = true;
                tmp_res.add(tmp);
                permutations(set);
                tmp_res.remove(tmp_res.size()-1);
                visited[tmp] = false;
            }
        }
    }

    // 检验每一种结果是否有效。
    public static boolean check(List<Integer> tmp_res)
    {
        // 带入tmp_res
        // 计算每一条直线，判断是否全部相等，如果全部相等则返回true
        int r1 = 1 + tmp_res.get(0) + tmp_res.get(3) + tmp_res.get(5);
        int r2 = 1 + tmp_res.get(1) + tmp_res.get(4) + tmp_res.get(8);
        int r3 = 8 + tmp_res.get(0) + tmp_res.get(1) + tmp_res.get(2);
        int r4 = 11 + tmp_res.get(3) + tmp_res.get(6);
        int r5 = 3 + tmp_res.get(2) + tmp_res.get(4) + tmp_res.get(7);
        int r6 = tmp_res.get(5) + tmp_res.get(6) + tmp_res.get(7) + tmp_res.get(8);

        return r1 == r2 && r2 == r3 && r3 == r4 && r4 == r5 && r5 == r6;
    }
}
