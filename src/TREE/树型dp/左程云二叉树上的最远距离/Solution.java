package TREE.树型dp.左程云二叉树上的最远距离;
// 题目
/*
二叉树之中，一个结点可往上走和往下走，那么从结点A总能够走到B，结点A走到结点B的距离为
A走到B最短路径上的结点个数，求一棵二叉树上的最远距离。
* */

// 大的思路
/*
求以每个结点为头结点的树之中的最远距离 ,最终的结果一定在其中。
* */

// 三种可能性
/*
A.最远路径在左子树上
B.最远路径经过根节点连接左子树和右子树，此时的的最远路径为左子树的深度+右子树的深度+1
C.最远路径在右子树上

举例:
                    1
                   / \
                  2  2
                 /\
                3  4
               /    \
              5      6
             /        \
            7          8
* */
public class Solution {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data)
        {
            this.value = data;
        }
    }

    public static class ReturnType{
        public int maxDistance;
        public int h;

        public ReturnType(int maxDistance,int h)
        {
            this.maxDistance = maxDistance;
            this.h = h;
        }
    }

    public static ReturnType process(Node head)
    {
        if(head == null)
        {
            return new ReturnType(0,0);
        }
        ReturnType leftReturnType = process(head.left);
        ReturnType rightReturnType = process(head.right);
        int includeHeadDistance = leftReturnType.h + 1 + rightReturnType.h;
        int p1 = leftReturnType.maxDistance;
        int p2 = rightReturnType.maxDistance;
        int resultDistance = Math.max(Math.max(p1,p2),includeHeadDistance);
        int hitself = Math.max(leftReturnType.h,rightReturnType.h) + 1;
        return new ReturnType(resultDistance,hitself);
    }

    public static int getMaxDistance(Node head)
    {
        return process(head).maxDistance;
    }
}
