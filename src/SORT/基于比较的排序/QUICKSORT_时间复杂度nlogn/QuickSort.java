package SORT.基于比较的排序.QUICKSORT_时间复杂度nlogn;
//经典快排
//给定一个数组，将最后一个元素作为分界值
//小于等于x的放在左侧，大于x的放在右侧。
//然后对于两个区域递归的进行相同的操作



import java.util.Arrays;

// 本代码的优点
// 1.通过荷兰国旗进行优化，将大于x  小于x  等于x的分为三个部分
// 2.通过random实现了随机快排
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // 这一行代码是进行随机抽取的代码，随机选一个数和最后一个数交换，实现了随机快排
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);//l-r随机选一个数和最后一个数上进行交换
            int[] p = partition(arr, l, r);//partition返回的是小于区域的右边界，和大于区域的左边界
            // l 到 p[0] - 1 是小于number的区域
            quickSort(arr, l, p[0] - 1);
            // p[1] + 1 是大于number的区域
            quickSort(arr, p[1] + 1, r);
        }
    }

    //荷兰国旗划分，优化的原因在于，经典快排每次只能定位一个元素即最后元素的位置，并且有可能会造成左右
    //规模不一致，所以会导致打偏，会导致快排退变成为O(n^2)的算法
    //而荷兰国旗划分能够将所有等于最后一个元素的值都进行定位，然后我们再使用随机快排即可。
    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;//l这个变量被复用成为了current指针，注意这里的arr[r]就是数组的最后一个元素也就是分区元素
        // 这里的l充当的是current指针的作用。
        while (l < more) {
            // 注意我们是让最后一个元素作为partition的元素。
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        // 让最右侧用来partition的元素和more位置处的元素进行交换。
        swap(arr, more, r);
        // 这里返回的是等于区域的边界。
        return new int[] { less + 1, more };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
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
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
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
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        quickSort(arr);
        printArray(arr);

    }
}
