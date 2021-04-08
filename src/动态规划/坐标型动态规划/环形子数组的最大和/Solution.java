package 动态规划.坐标型动态规划.环形子数组的最大和;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int N = A.length;

        // 进行前缀和的计算，P[0] = 0，前0个数的和是0，P[1]=A[0]，前1个数的和是A[0]
        // Compute P[j] = B[0] + B[1] + ... + B[j-1]
        // for fixed array B = A+A
        int[] P = new int[2*N+1];
        for (int i = 0; i < 2*N; ++i)
            P[i+1] = P[i] + A[i % N];

        // 我们想要得到最大的P[j] - p[i], 并且1<=j-i<=N，因为子数组长度要大于1，并且每个元素只能用一次
        // Want largest P[j] - P[i] with 1 <= j-i <= N
        // 对于每一个j我们想要找到使得P[i]最小的i
        // For each j, want smallest P[i] with i >= j-N
        int ans = A[0];
        // deque: i's, increasing by P[i]
        Deque<Integer> deque = new ArrayDeque();
        // 队列之中存储的是i的坐标
        deque.offer(0);
        //在长度为n以内的区间内，找最小值------>单调队列=滑动窗口中的的最值
        for (int j = 1; j <= 2*N; ++j) {
            // If the smallest i is too small, remove it.
            // 如果i<j-N则发生了元素的重复利用，则i是不可能的。
            if (deque.peekFirst() < j-N)
                deque.pollFirst();

            // 最优的结果就是队列的头部元素
            // The optimal i is deque[0], for cand. answer P[j] - P[i].
            ans = Math.max(ans, P[j] - P[deque.peekFirst()]);

            // 进行递增的单调队列的控制，若压入一个比队尾能让p[i]更小的i则移除队尾
            // Remove any i1's with P[i2] <= P[i1].
            while (!deque.isEmpty() && P[j] <= P[deque.peekLast()])
                deque.pollLast();

            deque.offerLast(j);
        }

        return ans;
    }
}