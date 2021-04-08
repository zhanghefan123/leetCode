package TREE.红黑树.红黑树的应用.累加和为aim的最长子数组;
// 题目:
/*
一个数组有正数，负数，0，现在给定一个目标数aim,
我们要找到一个最长的子数组，让这个子数组的和为aim.
* */

import java.util.HashMap;

// 思路
/*
求出每一个位置下必须以这个位置结尾结尾的情况下总和为aim的最长子数组
我们的结果必然在这些结果之中

问题:
如果来到i位置，怎么求必须以i位置结尾的情况下总和为aim的最长的子数组呢?

解决方案:
用一个变量sum记录从0位置到当前位置所有数的累加和

举例:
假设从0位置累加到1000这个位置，累加和为2000，我们的aim为800
我们现在想要求以1000这个位置结尾的情况下总和为aim的最长子数组
我只要知道从0位置到哪一个位置最先累加出1200，我们让后面的累加到i
就能够达到800


* */

// 延申问题
/*
问题:
找到奇数个数和偶数个数相等的最长子数组

思路:
令奇数个数为-1，偶数个数为1，找到aim为0的最长子数组


* */
public class Solution {
    public static int maxLength(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 一个数都没有的时候累加和是0，以索引-1结尾的时候为0
        map.put(0, -1); // important
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // 看map之中是否包含有sum - aim. 即之前例子之中的2000 - 800 = 1200
            if (map.containsKey(sum - aim)) {
                // 如果有的话，则看那个位置到i的长度和当前的最大长度对比，更新最大值
                len = Math.max(i - map.get(sum - aim), len);
            }
            // 不管有没有sum - aim，只要map之中没有sum则将sum以及产生sum的最后一个数的位置添加到map
            // 之中。所以这个map维护的是最先出现这个值的最后一个数的索引。
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }

    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 11) - 5;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = generateArray(20);
        printArray(arr);
        System.out.println(maxLength(arr, 10));

    }

}
