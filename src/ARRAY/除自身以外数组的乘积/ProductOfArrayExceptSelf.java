package ARRAY.除自身以外数组的乘积;
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] arrayLeft = new int[nums.length];
        int[] arrayRight = new int[nums.length];
        arrayLeft[0] = 1;
        for(int i=1;i<arrayLeft.length;i++)
        {
            arrayLeft[i] = nums[i-1]*arrayLeft[i-1];
        }
        arrayRight[arrayRight.length-1] = 1;
        for(int i=arrayRight.length-2;i>=0;i--)
        {
            arrayRight[i] = nums[i+1]*arrayRight[i+1];
        }
        for(int i=0;i<nums.length;i++)
        {
            nums[i] = arrayLeft[i] * arrayRight[i];
        }
        return nums;
    }
}