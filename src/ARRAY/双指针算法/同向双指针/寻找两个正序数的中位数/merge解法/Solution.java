package ARRAY.双指针算法.同向双指针.寻找两个正序数的中位数.merge解法;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int[] res = new int[length];
        int i = 0;
        int j = 0;
        int count = 0;
        while(i<length1&&j<length2)
        {
            if(nums1[i] <= nums2[j])
            {
                res[count++] = nums1[i++];
            }
            else
            {
                res[count++] = nums2[j++];
            }
        }
        while(i<length1)
        {
            res[count++] = nums1[i++];
        }
        while(j<length2)
        {
            res[count++] = nums2[j++];
        }
        if(length%2==0)
        {
            return (double)(res[length/2] + res[(length/2)-1]) / (double)2;
        }
        else
        {
            return (res[length/2]);
        }
    }
}
