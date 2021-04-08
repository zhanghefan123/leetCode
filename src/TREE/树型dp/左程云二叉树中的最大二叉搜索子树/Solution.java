package TREE.树型dp.左程云二叉树中的最大二叉搜索子树;
// 题目:
// 给定一棵二叉树，现在要我们求这棵二叉树之中最大二叉搜索子树的结点的个数


// 思路:
/*
我们只要找到包含每个结点的子树中的最大二叉搜索数即可，最终的结果就在其中

给定一棵二叉树，总共含有三种情况。
情况1:最大搜索二叉树在右子树中
情况2:最大搜索二叉树在左子树之中
情况3:最大搜索二叉树就是这棵二叉树

为了判断这三种情况我们需要求得6个信息
信息1:左子树之中最大二叉搜索子树大小
信息2:右子树之中最大二叉搜索子树大小
信息3:左子树之中最大二叉搜索子树的头部
信息4:右子树之中最大二叉搜索子树的头部
信息5:左子树之中的最大值
信息6:右子树之中的最小值


精简后的信息--不进行左右的区分
信息1:本树之中最大二叉搜索子树的大小
信息2:本树之中最大二叉搜索子树的头部
信息3:本树之中的最大值
信息4:本树之中的最小值
* */
public class Solution {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data)
        {
            this.value = data;
        }
    }

    public static class ReturnType{
        public int size;
        public Node head;
        public int min;
        public int max;

        public ReturnType(int a,Node b,int c,int d)
        {
            this.size = a;
            this.head = b;
            this.min = c;
            this.max = d;
        }
    }

    public static ReturnType process(Node head)
    {
        if(head == null)
        {
            return new ReturnType(0,null,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Node left = head.left;
        ReturnType leftSubTressInfo = process(left);
        Node right = head.right;
        ReturnType rightSubTressInfo = process(right);

        int includeItSelf = 0;
        if(leftSubTressInfo.head == left
            && rightSubTressInfo.head == right
                && head.value > leftSubTressInfo.max
                    && head.value < rightSubTressInfo.min)
        {
            includeItSelf = leftSubTressInfo.size + 1 + rightSubTressInfo.size;
        }
        int p1 = leftSubTressInfo.size;
        int p2 = rightSubTressInfo.size;
        int maxSize = Math.max(Math.max(p1,p2),includeItSelf);
        Node maxHead = p1 > p2 ? leftSubTressInfo.head : rightSubTressInfo.head;
        if(maxSize == includeItSelf)
        {
            maxHead = head;
        }
        return new ReturnType(maxSize,maxHead,Math.min(Math.min(leftSubTressInfo.min,rightSubTressInfo.min),head.value),
                Math.max(Math.max(leftSubTressInfo.max,rightSubTressInfo.max),head.value));

    }


}
