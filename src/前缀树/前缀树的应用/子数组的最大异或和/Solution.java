package 前缀树.前缀树的应用.子数组的最大异或和;

import java.util.HashMap;

// 题目
/*
给定一个数组，求子数组的最大异或和
一个数组的异或和为，数组中所有的数异或起来的结果
* */
public class Solution {
    // 最无脑的暴力解
    public static int getMaxEor(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length;i++)
        {
            for(int j = i; j < arr.length;j++)
            {
                // 找到i,j的边界之后，求i到j的异或和
                int res = 0;
                int k = i;
                while(k <= j)
                {
                    res ^= arr[k];
                    k++;
                }
                max = Math.max(max,res);
            }
        }
        return max;
    }

    // 稍微用脑的dp解
    // 如果我们要求start-i的异或和
    // 我们可以先求0 - i的异或和A，然后0-(start-1)的异或和B，然后用A异或B就得出结果
    public static int getMaxEor2(int [] arr)
    {
        int max = Integer.MIN_VALUE;
        int [] dp = new int[arr.length];
        int eor = 0;
        for(int i = 0;i<arr.length;i++)
        {
            // eor存储的是0到i的异或和。
            eor ^= arr[i];
            max = Math.max(max,eor);
            // 这里记录的是(0,1,2,……)到i的异或和。
            for(int start = 1; start <= i;start++)
            {
                int curEor = eor ^ dp[start -1];
                max = Math.max(max,curEor);
            }
            dp[i] = eor;
        }
        return max;
    }

    // O(n)的方法
    // 符号位尽量变为0，保证是正数
    // 其他位尽量保证为1
    public static class Node {
        // 一条是1的路，一条是0的路
        public Node[] nexts = new Node[2];
    }

    // 前缀树
    public static class NumTrie {
        public Node head = new Node();

        public void add(int num) {
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                // 拿到最高位
                // 与 1 进行与运算，如果为1则与运算结果为1，如果为0则与运算结果为0
                int path = ((num >> move) & 1);
                // 看路有没有，如果有路则走路，如果没有路则建路
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        // 核心方法,这个num参数是从0到i的异或结果，选出一个最优的结果与他异或，能让异或之后结果最大
        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                // 从高位到低位依次提取出0和1来
                int path = (num >> move) & 1;
                // 选择的最优的路
                // 如果当前考察的是符号位则尽量要求相同让异或结果为0，如果不是符号位则尽量要求不同让异或结果为1
                int best = move == 31 ? path : (path ^ 1);
                // 如果best不为空说明可以选择这个best,如果best这条路没有，只能选择差的路
                // 现在的best变成了实际需要选择的路。
                best = cur.nexts[best] != null ? best : (best ^ 1);
                // 将结果依次设置好
                res |= (path ^ best) << move;
                cur = cur.nexts[best];
            }
            return res;
        }

    }

    public static int maxXorSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int eor = 0;
        NumTrie numTrie = new NumTrie();
        numTrie.add(0);
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            max = Math.max(max, numTrie.maxXor(eor));
            numTrie.add(eor);
        }
        return max;
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int eor = 0;
            for (int j = i; j < arr.length; j++) {
                eor ^= arr[j];
                max = Math.max(max, eor);
            }
        }
        return max;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 30;
        int maxValue = 50;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int res = maxXorSubarray(arr);
            int comp = comparator(arr);
            if (res != comp) {
                succeed = false;
                printArray(arr);
                System.out.println(res);
                System.out.println(comp);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
