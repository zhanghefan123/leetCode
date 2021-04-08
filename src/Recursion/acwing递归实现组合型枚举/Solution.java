package Recursion.acwing递归实现组合型枚举;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static int total;

    public static int choose;

    public static ArrayList<Integer> tmp_res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tmp_res = new ArrayList<>();
        // 从N个数之中挑选出来M个
        total = sc.nextInt();
        choose = sc.nextInt();
        dfs(1);
    }

    public static void dfs(int index) {
        if (choose == tmp_res.size()) {
            for (int i : tmp_res) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        if (total - index + 1 + tmp_res.size() < choose)
        {
            return;
        }
        if (index == total + 1) {
            return;
        }
        for (int i = index; i <= total; i++) {
            tmp_res.add(i);
            dfs(i + 1);
            tmp_res.remove(tmp_res.size() - 1);
        }
    }
}