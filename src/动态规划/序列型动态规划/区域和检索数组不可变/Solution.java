package 动态规划.序列型动态规划.区域和检索数组不可变;

// 开两个数组的解法
public class Solution {
    public int[][] helper;


    public Solution (int[] nums) {
        int length = nums.length;
        this.helper = new int[length][length];

        for(int i = 0;i < length;i++)
        {
            for(int len = 0;len <= (length-i-1) ;len++)
            {
                int j = i + len;
                if(len == 0)
                {
                    helper[i][j] = nums[i];
                }
                else
                {
                    helper[i][j] = helper[i][j-1] + nums[j];
                }
            }
        }

    }

    public int sumRange(int i, int j) {
        return helper[i][j];
    }
}

// 开一个数组的解法
class Solution1{

    public int[] helper;


    public Solution1(int[] nums) {
        int length = nums.length;
        this.helper = new int[length];

        for(int i = 0;i < length;i++)
        {
            if(i == 0)
            {
                helper[i] = nums[i];
            }
            else
            {
                helper[i] = helper[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if((i-1)<0)
        {
            return helper[j];
        }
        else{
            return helper[j] - helper[i-1];
        }

    }
}