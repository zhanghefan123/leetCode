package ARRAY.双指针算法.同向双指针.累加和等于aim的最长子数组;
// 题目
/*
给定一个数组arr,全是正数，一个整数aim，求累加和等于aim的，最长子数组，
要求额外空间复杂度O(1)，时间复杂度O(N)
* */
public class Solution {
    // 算法思想
    /*
    给定两个指针，一个是窗口前指针，一个是窗口尾指针
    当当前窗口的和小于aim的时候，窗口前指针向右进行移动，窗口加数
    当当前窗口的和大于aim的时候，窗口尾指针向右进行移动，窗口减数
    当当前窗口的和等于aim的时候，左边缩一格
    * */


    public static int getMaxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }
        int L = 0;
        int R = 0;
        int sum = arr[0];
        int len = 0;
        while (R < arr.length) {
            if (sum == k) {
                len = Math.max(len, R - L + 1);
                // 等于情况下，左边缩一个
                sum -= arr[L++];
                sum += arr[++R];
            } else if (sum < k) {
                R++;
                if (R == arr.length) {
                    break;
                }
                sum += arr[R];
            } else {
                sum -= arr[L++];
            }
        }
        return len;
    }

    public static int[] generatePositiveArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 10) + 1;
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
        int len = 20;
        int k = 15;
        int[] arr = generatePositiveArray(len);
        printArray(arr);
        System.out.println(getMaxLength(arr, k));

    }
}
