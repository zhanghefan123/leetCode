package ARRAY.荷兰国旗;

//快速排序的基本partition版本
//给定一个数组arr和一个数num，请将小于等于num的数放在数组
//的左边，大于num的数放在数组的右边，要求空间复杂度为O（1），时间复杂度为O(n)


//算法思想
/*
1.首先指定一个x指针指向-1位置。0-x存储的是<=num的数
给定的值为-1说明小于等于区域还不存在

2.然后我们开始遍历整个数组，如果遇到小于num的数则直接和
小于等于区域的下一个数进行交换，并且将x指针进行递增。

3.经历完了整个数组的遍历之后，我们会发现小于等于num的数组
在左侧，大于等于num的数组在右侧

*/
// 如果是二分区，那么我们仅仅需要一个指针来划分即可，
// 还有一个current指针进行遍历

//荷兰国旗算法思想
/*
1.首先定义两个指针，一个指针less指向-1位置，表示当前小于num的元素没有，
另一个指针more指向数组.length位置，表示当前大于num的元素没有
2.然后开始整个数组的遍历，定义一个cur指针
3.然后我们开始遍历整个数组，如果遇到等于num的直接跳下一个
如果遇到小于num的数则直接和小于等于区域的下一个数进行交换，
并且将x指针进行递增，并且让cur++;
如果遇到大于num的直接跳到下一个，如果遇到大于num的数则直接和
大于区域的下一个数进行交换，但是cur指针不变进一步考察交换过来的数
4.停止条件
cur和more撞上的时候

* */
public class Flag {
    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        int cur = l;
        while (cur < more) {
            if (arr[cur] < p) {
                //这里的cur需要进行++的原因是从左侧换过来的数是等于number的数
                // 小于number区域 ][等于number区域][待定区域][大于number区域
                swap(arr, ++less, cur++);
            } else if (arr[cur] > p) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }

        //注意这里是将等于区域进行了返回
        //less+1是等于区域的第一个数，more-1是等于区域的最后一个数
        return new int[] { less + 1, more - 1 };
    }

    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
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

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
