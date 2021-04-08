package SORT.非基于比较的排序.MAXGAP;

import java.util.Arrays;
//题目:给定一个数组，求如果排序之后，相邻两个数的最大差值，要求时间复杂度为O(N),
//并且要求不能用非基于比较的排序

//算法思想--利用了桶的概念，但是没有进行桶排序
/*
第一步:进行桶的准备，如果数组之中存在N个数，则创建N+1个桶。
第二步:遍历整个数组找到最大值和最小值，如果最大值和最小值相等，说明整个数组就是一个数，最大差值是0
如果最大值和最小值不相等，我们将最小值放在0号桶，最大值放在N号桶，然后将最小值到最大值之间的数等分成为N+1份
一个数属于哪一个范围就进入哪一个桶。
假设存在10个数的数组，最小值为0，最大值为99
分为N+1个区间 0-9 10-19 20-29 …… 90-99
然后我们需要注意到，我们总共有N个数，其中min放在了0号桶之中，max放在了N号桶之中，剩余N-1个桶，剩余N-2个数
所以必然会存在一个或者一个以上的空桶，
然后我们找到空桶的左侧最近非空桶中的最大值，然后找到右侧最近非空桶中的最小值，这两者的差值一定会大于桶的范围

结论：相邻的两个数可以来自于一个桶，也可以来自于跨桶，但是最大的差值肯定不来自于一个桶，而是来自于跨桶。

算法流程：
对于任何一个桶，我们仅仅收集进入这个桶的所有数的最大值和最小值，以及这个桶有没有数进入过。
当遍历完一遍后，每个桶就有了相应的信息。然后我们从1号桶开始，如果它是空桶，直接跳下一个桶
如果它不是空桶，则向前找到最近的非空桶的最大值，将最大值和本桶的最小值相减，以此类推持续更新
一个全局变量，最终可以找到最大值。
* */
public class MaxGap {
    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        // 遍历整个数组-找到整个数组的最大最小值
        // 如果遍历完成后min == max return 0
        // --------------------------------
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        // --------------------------------

        // 桶之中是否有数
        boolean[] hasNum = new boolean[len + 1];//桶是否有数
        // 桶之中的最大值
        int[] maxs = new int[len + 1];//桶中的最大值数组
        // 桶之中的最小值
        int[] mins = new int[len + 1];//桶中的最小值数组
        int bid = 0;
        //重新遍历整个数组，从而更新每个桶的三个信息
        for (int i = 0; i < len; i++) {
            //bucket函数用来确定当前这个数属于几号桶
            bid = bucket(nums[i], len, min, max);
            // 更新最小值
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];//更新那个桶的最小值
            // 更新最大值
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];//更新那个桶的最大值
            hasNum[bid] = true;//标识桶有数
        }
        int res = 0;
        // 上一个非空桶的最大值
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
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
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
