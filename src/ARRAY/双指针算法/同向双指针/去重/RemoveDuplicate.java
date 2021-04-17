package ARRAY.双指针算法.同向双指针.去重;
//题目：
//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//要求：
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        int start,end;//start索引到0索引指向的是已经去重了的数组
        //start到end之间是重复的数值，end到最后是待检测的数组。
        start = 0;
        end = 1;
        int length = nums.length;
        // 至少会存在一个不同的元素
        int count = 1;
        while(end < length)
            if(nums[start] == nums[end])
            {
                end++;
            }
            else
            {
                nums[++start] = nums[end];
                count++;
            }
        return count;
    }
}

