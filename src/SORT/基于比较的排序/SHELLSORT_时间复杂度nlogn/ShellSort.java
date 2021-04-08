package SORT.基于比较的排序.SHELLSORT_时间复杂度nlogn;

public class ShellSort {
    public static void shellSort(int[] arr) {
        // 间隔序列，在希尔排序中我们称之为增量序列
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 分组 ,当等于gap的时候就是下一组了。
            for (int groupStartIndex = 0; groupStartIndex < gap; groupStartIndex++) {
                // 插入排序
                for (int currentIndex = groupStartIndex + gap; currentIndex < arr.length; currentIndex += gap) {
                    // currentNumber 站起来，开始找位置
                    int currentNumber = arr[currentIndex];
                    int preIndex = currentIndex - gap;
                    while (preIndex >= groupStartIndex && currentNumber < arr[preIndex]) {
                        // 向后挪位置
                        arr[preIndex + gap] = arr[preIndex];
                        preIndex -= gap;
                    }
                    // currentNumber 找到了自己的位置，坐下
                    arr[preIndex + gap] = currentNumber;
                }
            }
        }
    }
}
