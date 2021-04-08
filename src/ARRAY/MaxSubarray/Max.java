package ARRAY.MaxSubarray;
//算法思想：动态规划思想，就是从数组中第二个元素遍历到最后一个元素，如果前一个元素的值<0就将其
//附加在本元素上，以此类推
public class Max {
    public int maxSubArray(int[] nums) {
        for(int i=1;i<=nums.length-1;i++)
        {
            if(nums[i-1]>0)
            {
                nums[i] += nums[i-1];
            }
        }
        int max = nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(max<nums[i])
            {
                max = nums[i];
            }
        }
        return max;
    }
}
