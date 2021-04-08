package SORT.小和问题和逆序对问题;
//小和问题
//在一个数组中，每一个数左边比当前数小的数累加起来叫做这个数组的小和
/*
[1,3,4,2,5]
1左边比1小的数没有，
3左边比3小的数1
4左边比4小的数1，3
2左边比2小的数1
5左边比5小的数1 3 4 2
所以小和为1+1+3+1+1+3+4+2 = 16
*/

// 最直白的逻辑
/*
对每个数遍历一遍左边。
*/


/*

使用归并排序的方法
            1 3 4 2 5
              /   \
           1 3 4  2 5
            / \    /\
          1 3  4  2  5
  当 1和3 进行比较的时候产生1小和 当 2 5 进行比较的时候产生 2小和
  当 1 3 和 4 进行merge 的时候产生 1+3小和
  当 1 3 4 和 2 5 进行merge的时候当两个指针分别指向1和2的时候，我们可以发现产生的小和为2*1,
  然后左侧数组指针后移，3和2进行比较，右侧部分小，不产生任何小和，此时右侧数组指针后移，
  5 > 3 产生一个小和3，然后左侧指针后移，4 和 5进行比较，产生一个小和4
*/
//小贴士
//mid = (L+R)/2 可能会发生溢出
//mid = L+(R-L)/2 不会发生溢出

public class SmallSum {

	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return mergeSort(arr, 0, arr.length - 1);
	}

	//左侧排好序算小和，覆盖原数组，右侧排好序算小和，然后覆盖原数组，然后总体算小和。
	public static int mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		int mid = l + ((r - l) >> 1);
		return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
	}

	public static int merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		int res = 0;//res是这一次merge之中榨取出来的小和
		while (p1 <= m && p2 <= r) {
			// 若右侧指针指向的数大于左侧的数，则右侧指针的所有数个数乘以左侧指针指向的数
			// 等于被榨取的小和。
			res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;//比如前一个数组为1 2  后一个数组为 3 4 5 这两个数组都是排好序的，然后3和1进行比较的时候我们就会知道1会被这三个数榨取3次(3,4,5)都会榨取3次
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
		return res;
	}

	// for test
	public static int comparator(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int res = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				res += arr[j] < arr[i] ? arr[j] : 0;
			}
		}
		return res;
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
			if (smallSum(arr1) != comparator(arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

}
