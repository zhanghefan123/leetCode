package 动态规划.坐标型动态规划.矩形区域不超过K的最大数值和;

public class Solution {
    // 解体思路同最大子矩阵。
    public int dpmax(int[] arr, int k) {
        int rollSum = arr[0], rollMax = rollSum;
        // O(rows)
        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) rollSum += arr[i];
            else rollSum = arr[i];
            if (rollSum > rollMax) rollMax = rollSum;
        }
        if (rollMax <= k) return rollMax;
        // O(rows ^ 2) 如果按照上述的动态规划找到的rollMax>K就有问题了
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) max = sum;
                if (max == k) return k; // 尽量提前
            }
        }
        return max;
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {

        // total是matrix的拷贝
        // 第0行不变
        // 第1行等于第0行加上原来的第一行
        // 第二行等于新的第一行加上原来的第二行
        int[][] total = matrix;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                total[i][j] += total[i-1][j];
            }
        }

        // 最大值
        int maximum = Integer.MIN_VALUE;
        // 这两个for循环是用来遍历矩阵的那两行之间构成的矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                // matrix[0].length是矩阵的列数
                //result 保存的是从 i 行 到第 j 行 所对应的矩阵上下值的和
                int[] result = new int[matrix[0].length];
                for (int f = 0; f < matrix[0].length; f++) {
                    if (i == 0) {
                        result[f] = total[j][f];
                    } else {
                        result[f] = total[j][f] - total[i - 1][f];
                    }
                }
                int maximal = dpmax(result,k);
                if (maximal > maximum && maximal <= k) {
                    maximum = maximal;
                    if(maximum == k)
                    {
                        return k;
                    }
                }
            }
        }

        return maximum;
    }
}
