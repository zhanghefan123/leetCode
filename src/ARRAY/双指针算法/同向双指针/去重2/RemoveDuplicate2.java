package ARRAY.双指针算法.同向双指针.去重2;
/*
给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
* */
public class RemoveDuplicate2 {
    public static void main(String[] args) {
        RemoveDuplicate2 removeDuplicate2 = new RemoveDuplicate2();
        int length = removeDuplicate2.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
    }
    public int removeDuplicates(int [] nums)
    {
        if(nums.length == 0)
        {
            return 0;
        }
        int count = 1;
        int i = 1;
        int j = 1;
        int val = nums[0];

        while(i < nums.length) {
            if (nums[i] == val)
            {
                if(count < 2)
                {
                    //着重注意点，当nums[i]与val相同并且count<2的时候
                    // 并不代表已经存在了两个相同的值。我们的位置上需要
                    // 放置好这两个重复的值。
                    nums[j] = val;
                    i++;
                    j++;
                    count++;
                }
                else
                {
                    i++;
                    count++;
                }
            }
            else
            {
                count = 1;
                val = nums[i];
                nums[j] = val;
                i++;
                j++;
            }
        }
        return j;
    }
}
