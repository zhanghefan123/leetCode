package STACK.单调栈.单调栈的应用.求最大子矩阵的大小;
// 求最大子矩阵的大小

import javax.swing.text.MaskFormatter;
import java.util.Stack;

/*
题目:
给定一个整型矩阵map，其中的值只有0和1两种，求其中全是1的
所有矩形区域中，最大的矩形区域为1的数量。

例如:
1 0 1 1
1 1 1 1
1 1 1 0
其中，最大的矩形区域之中含有6个1，所以返回的是6

直方图思路:
假设直方图如下:
        *
      * *
*     * *
* *   * *
* * * * *
* * * * *
4 3 2 5 6 数值
0 1 2 3 4 索引

我们以每一直条向两边进行扩充，找到最大的矩形即可
其中我们可以使用单调栈的思路。

构建一个单调栈--这个单调栈由栈底到栈顶逐渐变大。

首先将0->4压入栈底，然后检测1->3，发现小于栈顶，开始进行弹出并进行结算
发现是索引1，让索引0弹出的，并且索引0弹出之后栈空，所以以4为高度的最大矩形
的底长为1，之后再压入1->2的时候，发现2小于栈顶3，然后将栈顶进行弹栈，所以以
3为高度的最大矩形的底长为2，依此类推……


利用直方图的思路:
每次以一行为底向上进行直方图的构建，并得到最大值
假设我们的矩阵如下:
1 0 1 1
1 1 1 1
1 1 1 0
step1:我们以第一行为底，构建直方图数组为(1,0,1,1) ,然后以这个直方图数组去求最大值
step2:我们以第二行为底，构建直方图数组为(2,1,2,2) ,然后以这个直方图数组去求最大值
step3:我们以第三行为底，构建直方图数组为(3,2,3,0) ,然后以这个直方图数组去求最大值
* */
public class Solution {
    // 求解原问题的函数
    public static int maxRecSize(int[][] map)
    {
        if(map == null || map.length == 0 || map[0].length == 0)
        {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for(int i = 0;i<map.length;i++)
        {
            for(int j = 0;j<map[0].length;j++)
            {
                // 如果是0则直接变成0，如果是1，则等于上一行+1
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height),maxArea);
        }
        return maxArea;
    }
    // 通过直方图求最大矩形面积
    public static int maxRecFromBottom(int [] height)
    {
        if(height == null || height.length == 0)
        {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length;i++)
        {
            // 进行结果的结算，从栈底到栈顶是从小到大的
            // 当栈不为空，且当前的数小于等于栈顶。
            while(!stack.isEmpty() && height[i] <= height[stack.peek()])
            {
                // 弹出来的数
                int j = stack.pop();
                // k是弹出之后底下的东西，就是当前这个弹出来的数的左边界
                int k = stack.isEmpty()? -1 : stack.peek();
                // i-k-1是底部
                int curArea = (i-k-1) * height[j];
                // 更新最大值
                maxArea = Math.max(maxArea,curArea);
            }
            stack.push(i);
            System.out.println(stack);
            System.out.println(maxArea);
        }
        while(!stack.isEmpty())
        {
            int j = stack.pop();
            int k = stack.isEmpty()?-1:stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea,curArea);
        }
        return maxArea;

        // 3 3 3
        // step1: 0 入栈
        // step2: 0 出栈，左边界为-1，右边界为1,计算得出最大值为(1-(-1)-1) * 3 = 3
        // step3: 1 入栈
        // step4: 1 出栈, 左边界为-1，右边界为2,计算得出最大值为(2-(-1)-1) * 3 = 6
        // step5: 2 入栈
        // step6: 最后一个while循环进行出栈操作，右边界为3，左边界为-1,计算得出最大值为(3-(-1)-1) * 3 = 9

    }

    public static void main(String[] args) {
        System.out.println(maxRecFromBottom(new int[]{3,3,3}));
    }
}
