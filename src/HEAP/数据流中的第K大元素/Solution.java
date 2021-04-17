package HEAP.数据流中的第K大元素;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int k;
    // 当我们需要查找第k大元素的时候，我们让小根堆保持拥有k个元素
    public PriorityQueue<Integer> minHeap;
    public Solution(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++)
        {
            minHeap.add(nums[i]);
            if(minHeap.size() > k)
            {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > k)
        {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}