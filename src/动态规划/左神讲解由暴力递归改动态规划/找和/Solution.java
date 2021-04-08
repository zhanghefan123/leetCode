package 动态规划.左神讲解由暴力递归改动态规划.找和;
// 题目
/*
给你一个数组arr和一个整数aim,如果可以任意选择arr中的数字，能不能累加得到aim,返回true或者false
arr之中全部是整数，aim全是正数
* */
public class Solution {

    // step1 分析后效性: 和我之前做了什么选择，怎样到达这个状态的没有关系
    // step2 分析dp的维度，就是可变参数组成的维度，其中一个维度就是可变参数i，另一个维度就是可变参数sum
    // boolean[][] dp = new boolean[i][sum]


    public static boolean money1(int[] arr, int aim) {
        return process1(arr, 0, 0, aim);
    }

    public static boolean process1(int[] arr, int i, int sum, int aim) {
        if (sum == aim) {
            return true;
        }
        // sum != aim
        if (i == arr.length) {
            return false;
        }
        return process1(arr, i + 1, sum, aim) || process1(arr, i + 1, sum + arr[i], aim);
    }

    public static boolean money2(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 8 };
        int aim = 12;
        System.out.println(money1(arr, aim));
        System.out.println(money2(arr, aim));
    }
}
