package ARRAY.双指针算法.相向双指针.leetcode1_两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //题目:
    /*
     * 给定一个整数数组 nums 和一个目标值 target，
     * 请你在该数组中找出和为目标值的那 两个整数，
     * 并返回他们的数值。
     * */

    //算法思想--利用双指针。
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        Arrays.sort(nums);
        while(i<j)
        {
            if(nums[j]+nums[i]>target)
            {
                j--;
            }
            else if(nums[j]+nums[i]<target)
            {
                i++;
            }
            else if(nums[j]+nums[i]==target)
            {
                return new int[]{nums[i],nums[j]};
            }
        }
        return null;
    }
    //题目:
    /*
     * 给定一个整数数组 nums 和一个目标值 target，
     * 请你在该数组中找出和为目标值的那 两个 整数，
     * 并返回他们的索引。
     * */

    //算法思想--利用哈希表
    /*
    * 对于每一个元素x,我们需要查找target-x。
    * 而我们的target x需要遍历整个数组进行查找。
    * 这样的话是非常的耗时的，我们如果使用哈希表的时候能够
    * 将O(N)的时间复杂度降为O(1)
    * */
    public int[] twoSum2(int[] nums,int target){
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
    //对于数组[4,2,3] target == 6
    //第一次迭代 -- 因为hash表中不包含6-4 = 2所以放入哈希表之中。
    //第二次迭代 -- 因为hash表中包含6-2 = 4，所以输出结果。
}
