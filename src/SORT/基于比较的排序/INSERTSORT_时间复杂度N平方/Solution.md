# 1.插入排序

插入排序的思想非常简单，生活中有一个非常常见的场景：在打扑克牌时，我们一边抓牌一边给扑克牌排序，每次摸一张牌，就将它插入手上已有的牌中合适的位置，逐渐完成整个排序。我们从第二张牌开始进行插牌，先记住我们这张牌，让前面所有大于这张牌的牌向后进行移动，然后再将这张牌插入其应该插入的位置。

```java
public static void insertSort(int[] arr) {
    // 从第二个数开始，往前插入数字
    for (int i = 1; i < arr.length; i++) {
        // 先将要进行插入的数保存下来。
        int currentNumber = arr[i];
        int j = i - 1;
        // 寻找插入位置的过程中，不断地将比 currentNumber 大的数字向后挪
        while (j >= 0 && currentNumber < arr[j]) {
            arr[j + 1] = arr[j];
            j--;
        }
        // 两种情况会跳出循环：1. 遇到一个小于或等于 currentNumber 的数字，跳出循环，currentNumber 就坐到它后面。
        // 2. 已经走到数列头部，仍然没有遇到小于或等于 currentNumber 的数字，也会跳出循环，此时 j 等于 -1，currentNumber 就坐到数列头部。
        arr[j + 1] = currentNumber;
    }
}
```

插入数据时，不仅可以用这种移动元素的方式，还可以使用交换元素的方式。代码如下：

```java
public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr, i, minIndex);
		}
	}

public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
}
```

# 2.插入排序的稳定性

不稳定

# 3.时间复杂度



## 3.1 插入排序时间复杂度和数据状况有关。

数据越有序，需要交换的和检查的次数越少。

极端情况：当数组已经有序，代价O(n)

极端情况：当数组逆序，代价O(n^2)

## 3.2 选择排序和冒泡排序和时间复杂度和数据状况无关

都是O(n^2)

## 3.3 大O表示法的含义

时间复杂度为一个算法流程中，在最差情况下常数操作数量的指标，常用O(读作Big O)来表示，具体来说

在常数操作数量的表达式中，只要高阶项，不要低阶项，也不要高阶项的系数，剩下的部分如果即为f(N)

那么时间复杂度为O(f(N))