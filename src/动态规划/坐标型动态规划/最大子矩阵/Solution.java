package 动态规划.坐标型动态规划.最大子矩阵;

// 这是仅仅求出最大值的过程
public class Solution {

    // 求连续子序列的最大和
    public int maxSubsequence(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] maxSub = new int[array.length];
        maxSub[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            maxSub[i] = (maxSub[i-1] > 0) ? (maxSub[i-1] + array[i]) : array[i];
            if (max < maxSub[i]) {
                max = maxSub[i];
            }
        }
        return max;
    }

    // 求最大子矩阵
    public int subMaxMatrix(int[][] matrix) {

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
                int maximal = maxSubsequence(result);

                if (maximal > maximum) {
                    maximum = maximal;
                }
            }
        }

        return maximum;
    }
}

// 这是求出最大矩阵的坐标的过程
class Solution2{
    public int[] getMaxArray(int[] nums) {
        // 求一维数组的最大子数组和
        int len = nums.length;
        int max = nums[0];
        int maxFromCol = 0;
        // 此最大连续数组的起点
        int maxToCol = 0;
        // 此最大连续数组的终点
        int fromCol = 0;
        // preMax存储的是到目前为止前面序列中连续子数组的最大值
        int preMax = nums[0];
        for (int col = 1; col < len; col++) {
            if (preMax <= 0) {
                if (nums[col] > max) {
                    max = nums[col];
                    maxFromCol = col;
                    maxToCol = col;
                }
                preMax = nums[col];
                fromCol = col;
            } else {
                preMax = preMax + nums[col];
                if (preMax > max) {
                    max = preMax;
                    maxFromCol = fromCol;
                    maxToCol = col;
                }
            }
        }

        return new int[]{max, maxFromCol, maxToCol};
    }

    // 最大子矩阵，最大子矩形
    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ansMax = Integer.MIN_VALUE;
        int[] ansArr = new int[4];
        int[][] colPreSum = new int[m][n];  // 列上的前缀和

        for (int j = 0; j < n; j++) {
            colPreSum[0][j] = matrix[0][j];
            for (int i = 1; i < m; i++) {
                colPreSum[i][j] = colPreSum[i-1][j] + matrix[i][j];
            }
        }

        int[] tmpArr = new int[n];
        for (int fromRow = 0; fromRow < m; fromRow++) {
            for (int toRow = fromRow; toRow < m; toRow++) {
                // 第fromRow行到第toRow行进行合并
                for (int col = 0; col < n; col++) {
                    tmpArr[col] = fromRow == 0 ? colPreSum[toRow][col] : colPreSum[toRow][col] - colPreSum[fromRow - 1][col];
                }

                // 求一维数组的最大子数组和
                int[] maxArrayRes = getMaxArray(tmpArr);
                int max = maxArrayRes[0];
                int maxFromCol = maxArrayRes[1];
                int maxToCol = maxArrayRes[2];

                if (max > ansMax) {
                    ansMax = max;
                    ansArr[0] = fromRow;
                    ansArr[1] = maxFromCol;
                    ansArr[2] = toRow;
                    ansArr[3] = maxToCol;
                }
            }
        }

        return ansArr;
    }
}