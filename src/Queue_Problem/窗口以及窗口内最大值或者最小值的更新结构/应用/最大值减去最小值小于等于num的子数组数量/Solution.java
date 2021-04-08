package Queue_Problem.窗口以及窗口内最大值或者最小值的更新结构.应用.最大值减去最小值小于等于num的子数组数量;
// 题目:
// 给定数组arr和整数num,返回一共有多少个子数组满足如下的情况
// max(arr[i……j]) - min(arr[i……j]) <= num

// 分析:
// 遍历子数组的起始位置，遍历子数组的终止位置，所以总共有O(N^2)个子数组
// 如果一个大数组满足条件，那么其内部任何一个子数组也满足条件
// 如果一个子数组不满足条件，那么任何一个包含它的更大的数组也不满足条件。


import java.util.LinkedList;

public class Solution {
    public static int getNum(int[] arr,int num)
    {
        if(arr == null || arr.length == 0)
        {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int start = 0;
        int end = 0;
        int res = 0;
        while(start < arr.length)
        {
            while(end < arr.length)
            {
                // 最小值结构更新
                while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[end])
                {
                    qmin.pollLast();
                }
                qmin.addLast(end);
                // 最大值结构更新
                while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[end])
                {
                    qmax.pollLast();
                }
                qmax.addLast(end);
                // 不达标就break
                if(arr[qmax.getFirst()] - arr[qmin.getFirst()] > num)
                {
                    break;
                }
                // 否则end++继续循环
                end++;
            }
            // 因为此时左边界要向右进行移动一个位置，所以我们要检查队头元素是否失效。
            if(qmin.peekFirst() == start)
            {
                qmin.pollFirst();
            }
            if(qmax.peekFirst() == start)
            {
                qmax.pollFirst();
            }
            res += end - start;
            start++;
        }
        return res;
    }

}
