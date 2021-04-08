package ARRAY.双指针算法.同向双指针.移动0;
//题目：
/*
* 给定一个数组 nums，编写一个函数将所有 0
* 移动到数组的末尾，同时保持非零元素的相对顺序。
*
* 输入输出样例:
* 输入:[0,1,0,3,12]
* 输出：[1,3,12,0,0]
* */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        // i的定义是下一个非0元素存放的位置。
        // j的定义是当前查看的元素的位置。
        int i = 0;
        int j = 0;
        int length = nums.length;
        if(length>1)
        {
            while(j<length&&i<length)
                if(nums[j]==0)
                {
                    j++;
                }
                else
                {
                    int temp;
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j++;
                }
        }
        }

    }

