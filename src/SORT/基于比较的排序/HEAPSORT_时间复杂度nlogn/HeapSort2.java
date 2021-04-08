package SORT.基于比较的排序.HEAPSORT_时间复杂度nlogn;

import java.util.Arrays;
//注意，堆一定是一棵完全二叉树，我们通常使用数组来存储完全二叉树
//举例，给定一个数组，下标依次为 0 1 2 3 4 5 6 7
//对应的完全二叉树即堆为
/*
       0
     1   2
   3 4  5 6
*/
//假设分支结点的索引为i,左孩子的索引是2*i+1,右孩子的索引为2*i+2
//一个结点的索引为i,其父结点的下标为(i-1)/2。

//堆的分类--大根堆，小根堆
/*
大根堆定义：
任何一棵树的最大值就是这棵树的头部(根结点)。

小根堆定义：
任何一棵树的最小值就是这棵树的头部(根结点)。
* */

//我们需要完成的第一步
/*
将一个数组调整成为大根堆，
*/


//插入法建立大根堆的时间复杂度
//当一个结点想要插入进来，它只有可能和它的祖先结点进行比较，且最多和它的所有祖先结点进行比较
//假设前面的0-i-1已经是一个大根堆，现在要插入第i个，代价就是O(log(i-1)),存在N个结点log1+log2+log3+……log(n-1)
//就是O(N);


//堆的应用
/*
有一个吐数器，会不断的吐出数，我们需要在任意时刻能够返回它
吐出的所有数的中位数。

算法思路：
我们需要创建一个大根堆，一个小根堆
大根堆之中存放的是较小的2/N个，小根堆中存放的是较大的2/N个
如果一个数小于等于大根堆的堆顶就进入大根堆，如果一个数大于大根堆的堆顶就进入小根堆
但是可能会出现这样的情况，就是大根堆之中的元素个数!=小根堆中的，更加具体的是
个数的差值超过1，我们就可以将大根堆中的根弹出放到小根堆之中，用大根堆中的最后一
个元素代替，然后将这个元素进行下沉的操作，如果是小根堆也是相同的操作。
*/

public class HeapSort2 {

    //堆排序算法思想
    //让堆顶元素和最后一个堆元素进行交换，然后将堆大小heapsize--,
    //因此我们就唯一确定了数组的最大值
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);//0-(i-1)已经弄成大根堆了,然后我们需要将arr的第i个元素进行插入
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    // 不停的往上跑
    public static void heapInsert(int[] arr, int index) {
        //只有我比我的父位置要大我就和我的父位置进行交换的操作，并且index变换到父位置
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
        //如果小于父位置的话则保持不变
    }

    //不停的向下跑。
    //假设数组原来是大根堆，其中一个值发生了变化，重新调整成为大根堆
    //思想，从变化的地方开始，与其孩子进行比较，如果孩子大于它，则将两个孩子最大的与之交换，
    //然后从交换到的位置开始，继续观察其与孩子的大小，如果小于则与两个孩子中较大的交换
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            //找到左右孩子结之中的大者
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            //找出左右结点的最大值和根结点值中的最大值
            largest = arr[largest] > arr[index] ? largest : index;
            //如果largest即根，左，右中最大的为自己，那么就不用进行继续的下沉。
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);//largest != index
            index = largest;
            left = index * 2 + 1;
        }
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
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }
}
