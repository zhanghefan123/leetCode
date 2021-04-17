package ARRAY.双指针算法.同向双指针.原地移除元素;
/*
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
*
* */

public class LocalRemove {
    public int removeElement(int[] nums, int val) {
        // 同向双指针算法
        // i 指针存储的是当前判断的数
        int i = 0;
        // j 指针指向的以及j指针指向的之前的数一定!=val
        int j = 0;
        while(i<=nums.length-1)
        {
            if(nums[i] == val)
            {
                i++;
            }
            else
            {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
                j++;
            }
        }
        return j;
    }
}
