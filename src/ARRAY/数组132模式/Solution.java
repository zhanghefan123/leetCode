package ARRAY.数组132模式;

import java.util.TreeMap;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        // 左侧最小值
        int leftMin = nums[0];
        // 右侧所有元素
        TreeMap<Integer, Integer> rightAll = new TreeMap<Integer, Integer>();

        // 将2-(n-1)全部放入TreeMap之中
        for (int k = 2; k < n; ++k) {
            // getOrDefault思想：getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
        }

        for (int j = 1; j < n - 1; ++j) {
            if (leftMin < nums[j]) {
                // 在右侧的TreeMap之中寻找刚刚大于leftMin的数值,ceilingKey返回的是大于等于的值
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            // 当j位置不能作为132序列的3的时候，j+1位置的元素就应该被舍弃。
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }

        return false;
    }
}
