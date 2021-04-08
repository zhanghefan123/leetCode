package STACK.单调栈.单调栈的应用.网易环形山;
// 题目:
/*
[1 2 4 5 3]
        5
       / \
      3   4
       \   \
        1 - 2

存在一个用数组表示的环形山，我们会在每个山头放置烽火
现在有如下的规则:
rule1:相邻的山头必能看到对方的烽火
rule2:从1走到4可以通过顺时针的方向走到4，也可以通过逆时针的方向走到4
如果两座山头AB不相邻，如果这两条路之中任意一条路出现的值都小于等于A和B的最小值
我们说这两座山头可以相互看见
比如3和4之间可以相互看见，因为3逆时针走到4，经过1，2，而1和2都小于3和4的最小值3

问题:问给定我们一个数组，我们需要求出能够相互看到的山峰有多少对。
* */

// 如果所有的数都是不相等的，那么在O(1)的时间复杂度内就能够解决问题
/*
山峰数量 对数
   1     0
   2     1
   i   (2*i-3)
* */

// 若所有的数都是不相同的情况的思路
// 因为1看到2和2看到1是同一对，所以我们只从小找大，而不从大找小，这样可以避免重复
// 我们首先找到最高点和次高点，然后任意一个位置顺时针以及逆时针进行寻找，发现比自己大的就停止
// 这样必定能够找到两个山峰对，所以是2 * (n-2),然后从次高到最高又是一对，
// 所以总数是2 * i - 3

// 若所有的数可能相同的情况的思路
// 我们先找到全局最大值，然后准备一个单调栈，单调栈从栈底到栈顶从大到小。
// 举例
/*
假设我们的数组是5,4,5,遇到了5的时候将5,1进行压栈，其中5是数值，1是5出现的次数
然后遇到了4的时候将4,1进行压栈，当再次遇到5的时候，将4进行弹栈，现在就是将4为低点
向两边寻找高点进行结算的时候，因为底下存在一个比他大的5，准备压进来的也是比他大的5，
所以找到了2对，4就可以弹出了，为什么以它为起点找不到其他的山峰对了，因为两座山峰已经
将他夹住了，然后栈之中生下来了一个元素(5,2),5出现了两次。

// 特殊情况1-遇到前面多次出现的数要进行弹栈结算

5          5
 \       /
  4 4 4 4
总共存在C4^2 + 4 * 2 对山峰对可以相互之间看见
以此类推，一个栈中记录了k次出现的值要进行弹栈的时候，结果Ck^2 + k * 2

// 特殊情况2-栈最后还不是空的如何进行处理
// 比如数组[5,5,4,4,3,3]】
// 进行上述操作完成后的栈如下所示
// 栈底[(5,2),(4,2),(3,2)]栈顶
// 求解栈中倒数第n>=3的记录的时候按照公式求解，
// 这两个3向两侧一定能够找到大于它的两个山峰。所以结算 C2^2 + 2 * 2

// 特殊情况3-栈最终剩下两条记录
// 栈倒数第二条记录的结算需要考虑，栈倒数第一条记录即最大值的数量，
// 若最大值的数量==1,那么结算为Ck^2 + k * 1
// 若最大值的数量>1，那么结算为Ck^2 + k * 2

// 特殊情况4-栈最终剩下一条记录
// 栈倒数第一条记录如何进行结算--Ck^2


* */

import java.util.Stack;

public class Solution {
    public static class Pair{
        // 记录值
        public int value;
        // 记录值出现的次数
        public int times;
        // 构造函数
        public Pair(int value)
        {
            this.value = value;
            this.times = 1;
        }
    }

    public static int nextIndex(int size,int i)
    {
        return i < (size - 1) ? i + 1 : 0;
    }

    // 简单的Ck^2的实现，从k个数之中选择出两个数的情况数
    public static long getInternalSum(int n)
    {
        return n == 1L ? 0L : (long) n * (long)(n-1) / 2L;
    }

    public static long communications(int [] arr)
    {
        if(arr == null || arr.length < 2)
        {
            return 0;
        }
        int size = arr.length;
        // 最大值的位置
        int maxIndex = 0;
        // 在整个数组之中找到最大值的位置
        for(int i = 0;i < size;i++)
        {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        // 根据最大值位置找到的最大值
        int value = arr[maxIndex];
        // 因为是一个循环数组，所以从最大值位置开始遍历的时候需要进行特殊处理
        // 需要进行取余的操作从而回到头部
        // 从最大值的下一个位置开始进行遍历
        int index = nextIndex(size,maxIndex);
        long res = 0L;
        // 准备一个单调栈
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(value));
        // 回到maxIndex说明遍历结束
        while(index != maxIndex)
        {
            // 拿到了数组中的值
            value = arr[index];
            // 若当前即将压入的数大于栈顶的元素的时候，开始进行结算
            while(!stack.isEmpty() && stack.peek().value < value)
            {
                int times = stack.pop().times;
                res += getInternalSum(times) + 2 * times;
            }
            if(!stack.isEmpty() && stack.peek().value == value)
            {
                stack.peek().times++;
            }
            else
            {
                stack.push(new Pair(value));
            }
            index = nextIndex(size,index);
        }

        // 当结束了栈还是不空的时候进行结算
        while(!stack.isEmpty())
        {
            int times = stack.pop().times;
            res += getInternalSum(times);
            if(!stack.isEmpty())
            {
                res += times;
                if(stack.size() > 1)
                {
                    res += times;
                }
                else
                {
                    // 如果只有一个1
                    res += stack.peek().times > 1 ? times:0;
                }
            }
        }
        return res;
    }

}
