package ARRAY.双指针算法.相向双指针;
/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 */
public class MaxWater {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = Integer.MIN_VALUE;
        while(i<j)
        {
            int width = j-i;
            max = Integer.max(width*Integer.min(height[i],height[j]),max);
            //由于区域面积受限于最短的边，所以我们让最短的边向中间移动
            if(height[i]<=height[j])
            {
                i++;
            }
            else
            {
                j--;
            }

        }
        return max;
    }
}
