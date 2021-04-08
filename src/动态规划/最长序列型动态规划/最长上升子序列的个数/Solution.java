package 动态规划.最长序列型动态规划.最长上升子序列的个数;

import java.util.Arrays;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        // lengths存储的是以nums[i]结尾的最长的子序列的长度
        //lengths[i] = length of longest ending in nums[i]
        int[] lengths = new int[N];
        // counts存储的是以nums[i]结尾的最长子序列的个数
        //count[i] = number of longest ending in nums[i]
        int[] counts = new int[N];
        // counts最少都是1
        Arrays.fill(counts, 1);

        for (int j = 0; j < N; ++j) {
            // 向前进行寻找，看有没有元素小于自己，
            for (int i = 0; i < j; ++i)
                if (nums[i] < nums[j]) {
                    // 如果发现元素小于自己
                    // 则进行进一步的判断，如果以i结尾的子序列长度>=以j结尾的子序列长度
                    // 那么个数直接过渡，并且最长子序列的长度+1
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    // 如果以i结尾的子序列长度+1等于以j结尾的子序列长度，
                    } else if (lengths[i] + 1 == lengths[j]) {
                        counts[j] += counts[i];
                    }
                }
        }

        int longest = 0, ans = 0;
        // 最长长度
        for (int length: lengths) {
            longest = Math.max(longest, length);
        }
        // 累计拥有最长长度的序列的个数
        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }
}
