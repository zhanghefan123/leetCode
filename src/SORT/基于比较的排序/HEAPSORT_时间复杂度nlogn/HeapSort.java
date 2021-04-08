package SORT.基于比较的排序.HEAPSORT_时间复杂度nlogn;

/*
*    1
*  2   3
* 4 5 6 7 length = 7 2*2+1 = 5
* *


 */
//注意，堆一定是一棵完全二叉树，我们通常使用数组来存储完全二叉树
public class HeapSort {

    public static void heapSort(int[] arr) {
        // 构建初始大顶堆
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            // 将最大值放到最后,这个heapSize其实时最后一个位置的索引
            exchange(arr, 0, i);
            // 根节点失去--[被交换到数组的最后一个位置]，所以从根结点开始进行调整。
            maxHeapify(arr, 0, i);
        }
    }

    // 构建初始大顶堆
    public static void buildMaxHeap(int[] arr) {
        // 从最后一个非叶子结点开始调整大顶堆，最后一个非叶子结点的下标就是 arr.length / 2-1
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }

    // 调整大顶堆，第三个参数表示堆的大小
    private static void maxHeapify(int[] arr, int i, int heapSize) {
        // 左子结点下标
        int l = 2 * i + 1;
        // 右子结点下标
        int r = l + 1;
        // 记录根结点、左子树结点、右子树结点三者中的最大值下标
        int largest = i;
        // 与左子树结点比较,l < heapSize的含义是存在左子结点。
        if (l < heapSize && arr[l] > arr[largest]) {
            largest = l;
        }
        // 与右子树结点比较
        if (r < heapSize && arr[r] > arr[largest]) {
            largest = r;
        }
        // 最大的结点不是这个分支结点，则要交换位置。
        if (largest != i) {
            // 将最大值交换为根结点
            exchange(arr, i, largest);
            // 再次调整交换数字后的大顶堆，
            // 有可能一个较大的数被替换了下来，会导致后面的连带替换。
            maxHeapify(arr, largest, heapSize);
        }
    }
    // 交换元素
    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
