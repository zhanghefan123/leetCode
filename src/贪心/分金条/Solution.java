package 贪心.分金条;
// 分金条
/*
一块金条切成两部分，是需要花费和长度数值一样的铜板的，比如长度为20的金条，不管切成多大的两部分
都要花费20个铜板，一群人想要整分整块金条，怎么分最省铜板

例如：给定数组[10,20,30]，代表一共三个人，整条金条长度为10+20+30=60,金条要分成10，20，30
三个部分，如果，先将长度为60的金条分成10和50，花费60，再将长度50的金条分成20和30，花费50，
一共花费110铜板。

但是如果，先将长度为60的金条分成30和30，花费60，再将长度为30的金条分成10和20，花费30，一共
花费90铜板，

输入一个数组，返回切割的最小代价

* */


import java.util.PriorityQueue;

// 哈夫曼树也称之为最优二叉树，含有n个带权叶子结点带权路径长度最小的二叉树
// 哈夫曼编码经典问题
// 思路
// 使用数组之中所有的元素创建一个小根堆
// 从小根堆之中弹出两个最小的元素
// 将弹出的最小的两个元素相加之后放回小根堆之中。
// 重复上述过程，直到小根堆之中仅仅剩下一个元素，返回这个元素就是代价
public class Solution {

    public static void main(String[] args) {
        int[] array = new int[]{10,20,30};
        // 默认是小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // 将所有的元素放入小根堆之中
        for(int tmp : array)
        {
            priorityQueue.add(tmp);
        }
        // 弹出最小的元素
        while(priorityQueue.size()!=1)
        {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            priorityQueue.add(first+second);
        }
        System.out.println(priorityQueue.poll());
    }

}
