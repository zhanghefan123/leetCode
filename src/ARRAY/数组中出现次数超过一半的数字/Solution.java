package ARRAY.数组中出现次数超过一半的数字;

import java.util.HashMap;

public class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int half = length/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        if(length==1)
        {
            return nums[0];
        }
        for(int i = 0;i< length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int current = map.get(nums[i]);
                if(current+1 > half)
                {
                    return nums[i];
                }
                else
                {
                    map.put(nums[i],current+1);
                }
            }
            else
            {
                if(length-i < half)
                {
                    continue;
                }
                map.put(nums[i],1);
            }
        }
        return 0;
    }

    // 使用摩尔投票解法

    // 原理：
    /*
    摩尔投票算法是基于这个事实：每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），
    最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个。
    * */

    // 简单理解：
    /*
    核心就是对拼消耗。玩一个诸侯争霸的游戏，
    假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能
    一对一同归于尽。最后还有人活下来的国家就是胜利。
            */

    // 过程：
    /*
    遍历nums数组，使用count进行计数，记录当前出现的数字cur
    ，如果遍历到的 num 与 cur 相等，则 count 自增，否则自减，
    当其减为 0 时则将 cur 修改为当前遍历的 num，通过增减抵消的方式，
    最终达到剩下的数字是结果的效果，时间复杂度为 O(n)

     */
    public int mooreVote(int[] nums)
    {
        // 相当是一个隐形的数组，数组中保存的是暂时不能抵消的元素
        int cur = 0;
        // 保存的是数组的元素个数。
        int count = 0;
        for(int num : nums){
            if(count == 0) {
                cur = num;
            }
            if(num == cur) {
                count++;
            } else {
                count--;
            }
        }
        return cur;
    }
}