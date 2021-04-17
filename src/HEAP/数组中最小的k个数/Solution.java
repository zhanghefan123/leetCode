package HEAP.数组中最小的k个数;

import java.util.PriorityQueue;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int [] res = new int[k];
        for(int i = 0; i < arr.length;i++)
        {
            heap.add(arr[i]);
        }
        for(int i = 0; i < k; i++)
        {
            res[i] = heap.poll();
        }
        return res;

    }
}
