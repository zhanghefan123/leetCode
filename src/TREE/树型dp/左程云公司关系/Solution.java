package TREE.树型dp.左程云公司关系;
// 题目

/*
一个公司的上下节关系是一棵多叉树，这个公司要举办晚会，你作为组织者已经摸清了大家的
心理：一个员工的直接上级如果到场，这个员工肯肯定不回来，每个员工都有一个活跃度的值，
你可以决定谁来，怎样让舞会的气氛最活跃，返回最大的活跃值

举例:
给定一个matrix来表述这种关系
matrix = {
1,6
1,5
1,4
}
这个矩阵的含义是
matrix[0] = {1,6}，表示0这个员工的直接上级为1，0这个员工自己的活跃度为6
matrix[1] = {1,5}，表示1这个员工的直接上级为1(他的上级是他自己，他是公司的boss),5是这个员工自己的活跃度
matrix[2] = {1,4}，表示2这个员工的直接上级为1，2这个员工的活跃度为4
为了让晚会的活跃度最大，应该让1不来，让0和2来，最后返回活跃度为10

* */


import java.util.ArrayList;
import java.util.List;

// 思路
/*
1.找到所有的以这个结点为根节点的树的最大活跃度
2.本结点可以来或者不来。
3.如果本结点来，那么就是邻居结点不来的活跃度之和
4.如果本结点不来，那么就是邻居结点来与不来中活跃度最大的之和
* */
public class Solution {

    public static class Node{
        public int huo;
        public List<Node> nexts;
        public Node(int huo)
        {
            this.huo = huo;
            nexts = new ArrayList<>();
        }
    }


    public static class ReturnData{
        public int lai_huo;
        public int bu_lai_huo;
        public ReturnData(int lai_huo,int bu_lai_huo)
        {
            this.lai_huo = lai_huo;
            this.bu_lai_huo = bu_lai_huo;
        }
    }

    public static ReturnData process(Node head)
    {
        int lai_huo = head.huo;
        int bu_lai_huo = 0;
        for(int i = 0;i<head.nexts.size();i++)
        {
            Node next = head.nexts.get(i);
            ReturnData nextData = process(next);
            lai_huo += nextData.bu_lai_huo;
            bu_lai_huo += Math.max(nextData.lai_huo,nextData.bu_lai_huo);
        }
        return new ReturnData(lai_huo,bu_lai_huo);
    }

    public static int getMaxHuo(Node head)
    {
        ReturnData returnData = process(head);
        return Math.max(returnData.lai_huo,returnData.bu_lai_huo);
    }
}
