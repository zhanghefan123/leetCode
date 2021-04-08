package 贪心.项目能获得的最多钱;
// 项目能获得的最多的钱
/*
cost是代价数组
profit是盈利数组
即每个项目需要花多少钱，一个是做了这个项目之后你能够获得多少利润

一次只能做一个项目，最多只能做k个项目，问你最多能剩下多少钱。
* */

// 策略
/*
我们的参数
cost数组，profit数组，w初始资金，K最多K个项目

准备将项目进行打包成一个新的类型
其中有两个成员变量，一个成员变量是项目的花销，一个成员变量是项目的纯利润

准备一个小根堆，这个小根堆是按照花费低谁来到头部的策略。

在小根堆之中将小于等于初始资金的项目全部弹出来，将他们放到大根堆之中
这个大根堆是按照收益高组成的大根堆。

然后将大根堆的头部的项目拿出来做掉这个项目，所以我们的大根堆就是能够做的项目，
大根堆的堆顶就是能赚的最多的项目

然后初始资金增加了，增加之后，我们看小根堆之中还有那些项目能够被弹出放到大根堆之中去。

大根堆弹出k次就停止
* */


import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }

    }

    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }

    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            // 解锁项目，放在大根堆之中
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            // 大根堆为空，就是说明可能没有任务能够被解锁，陷入停止。
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }
}
