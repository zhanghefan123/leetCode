package Queue_Problem.窗口以及窗口内最大值或者最小值的更新结构;
// 窗口以及窗口内最大值或者最小值的更新结构--单调双端队列

import java.util.LinkedList;

// 题目:
// 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边
// 窗口每次向右滑动一个位置，例如
/*
[4 3 5] 4 3 3 6 7  窗口中的最大值为5
4 [3 5 4] 3 3 6 7  窗口中的最大值为5
4 3 [5 4 3] 3 6 7  窗口中的最大值为5
4 3 5 [4 3 3] 6 7 窗口中的最大值为4
4 3 5 4 [3 3 6] 7 窗口中的最大值为6
4 3 5 4 3 [3 6 7] 窗口中的最大值为7
如果数组长度为n,窗口大小为w,则移动将产生n-w+1个窗口的最大值

窗口加数的概念:右指针向右移动
窗口减数的概念:左指针向右移动
窗口的限制:左右指针均不能进行回退

窗口加数的时候双端单调队列如何进行维护:
举例:
5 4 1 2 6
[              ]
队头          队尾
我们始终维护一个从队头到队尾的单调递减的队列
当上述数组，左指针固定不动，窗口右指针持续向右进行滑动单调双端队列的变化过程如下
step1 [5               ]   5 压入
      队头            队尾
step2 [5 4              ]  4 压入
      队头            队尾
step3 [5 4 1            ]  1 压入
      队头            队尾
step4 [5 4 2            ]  1 弹出 2 压入
      队头            队尾
step5 [6                ]  5 4 2 弹出 6 压入
      队头            队尾
注意当遇到相同的元素的时候，要将队列里面更老的元素进行弹出，而将具有更大索引的相同的数
进行压入


窗口减数的时候如何维护一个双端单调队列
如果窗口左指针向右进行移动直接让双端队列的对头元素进行出队


注意，我们在进行入队的时候，要注意也要将下标和值或者只将下标进行入队

*/

// 时间复杂度O(N)
public class Solution {

    public static int [] getMaxWindow(int[] arr,int w)
    {
        if(arr == null || w < 1 || arr.length < w)
        {
            return null;
        }
        // 存储的是入队的元素的索引而非数值
        LinkedList<Integer> qmax = new LinkedList<>();
        // 给的数组的长度为arr.length,总共能够的到的结果数组的长度为arr.length-w+1
        int[] res = new int[arr.length-w+1];
        int index = 0;
        for(int i = 0; i < arr.length;i++)
        {
            // 当双端队列尾部的索引所指向的元素小于等于arr[i]则进行的是尾部的出队
            // 不满足的时候将本索引进行入队的操作
            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i])
            {
                qmax.poll();
            }
            qmax.addLast(i);
            // 头部元素已经过期了就进行头部元素的弹出
            // 因为我们要求的是窗口内的最大值
            if(qmax.peekFirst() == i-w)
            {
                qmax.pollFirst();
            }
            // i 如果小于w-1的时候说明还没有形成一个大小为3的窗口
            if(i >= w-1)
            {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
