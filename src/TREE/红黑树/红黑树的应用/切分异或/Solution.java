package TREE.红黑树.红黑树的应用.切分异或;
// 题目:
/*
现在有一个数组，我们想要求得一种切分方式，使得切分出来得子数组中
有最多得子数组，能够使得这些子数组内的所有元素全部异或起来为0，
求最多能出现多少个这样的子数组 。
* */

// 前提条件
// 1.异或运算满足交换率
// 2.异或运算满足结合率
// 3.0和任何数异或都是那个数
// 4.任何数和自己异或都是0

// 两种情形
/*
原问题:求0-i上最多能够切分出多少个异或和为0的子数组

最后一步:最后一个子数组
> 可能性1:包含i在内的最后一个子数组异或和不为0，此时0-i上最多能够切分出多少个异或和为0的子数组等价于0-i-1上最多能够切分出多少个异或和为0的子数组
> 可能性2:最后一个子数组异或和为0，假设是最优化分，那么从划分点到i这个子数组的异或和为0，中间不可能再出现一个j使得j位置到i位置的异或和为0，
否则就不是最优划分。

转移方程:
其中k是距离i最近的并且从k位置到i位置构成的子数组异或和为0的k.
dp[i] = Max(dp[i-1],dp[k-1]+1)
* */


import java.util.HashMap;

public class Solution {

    public static int mostEOR(int[] arr) {
        int ans = 0;
        int xor = 0;
        int[] mosts = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            // xor计算的是0~i的异或和
            xor ^= arr[i];
            // 如果map之中包含这个异或和
            if (map.containsKey(xor)) {
                // 找到这个异或和最晚出现的位置
                int pre = map.get(xor);
                mosts[i] = pre == -1 ? 1 : (mosts[pre] + 1);
            }
            if (i > 0) {
                mosts[i] = Math.max(mosts[i - 1], mosts[i]);
            }
            // 求最晚的位置
            map.put(xor, i);
            ans = Math.max(ans, mosts[i]);
        }
        return ans;
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] eors = new int[arr.length];
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            eors[i] = eor;
        }
        int[] mosts = new int[arr.length];
        mosts[0] = arr[0] == 0 ? 1 : 0;
        for (int i = 1; i < arr.length; i++) {
            mosts[i] = eors[i] == 0 ? 1 : 0;
            for (int j = 0; j < i; j++) {
                if ((eors[i] ^ eors[j]) == 0) {
                    mosts[i] = Math.max(mosts[i], mosts[j] + 1);
                }
            }
            mosts[i] = Math.max(mosts[i], mosts[i - 1]);
        }
        return mosts[mosts.length - 1];
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
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
        int maxSize = 300;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int res = mostEOR(arr);
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
