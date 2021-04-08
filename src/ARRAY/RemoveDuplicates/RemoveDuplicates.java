package ARRAY.RemoveDuplicates;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        //因为是排序数组所以相同的元素肯定聚在一起
        if(nums.length!=0)
        {
            int same = nums[0];
            int size = 1;
            for(int i =1;i<nums.length;i++)
            {
                if(nums[i] == same)
                {
                }
                else
                {
                    same = nums[i];//一旦发现不匹配
                    nums[size] = same;
                    size += 1;
                }
            }
            return size;
        }
        else{
            return 0;

        }

    }
}
