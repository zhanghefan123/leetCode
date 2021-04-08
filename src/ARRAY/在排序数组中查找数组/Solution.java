package ARRAY.在排序数组中查找数组;
/*
题目描述
统计一个数字在排序数组中出现的次数。

示例 1:输入: nums = [5,7,7,8,8,10], target = 8，输出2

示例2：输入: nums = [5,7,7,8,8,10], target = 6，输出0
 */
public class Solution {
    public int search(int[] nums, int target) {
        return getRightMargin(nums, target) - getRightMargin(nums, target - 1);
    }
    // 每次查找的都是右侧边界。
    int getRightMargin(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
