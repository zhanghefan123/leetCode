package TREE.树型dp.左程云判断一棵树是否是平衡二叉树;

public class Solution {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

    }

    // 需要的信息
    /*
     * 1.这棵树是否是平衡二叉树
     * 2.这棵树的高度
     * */

    public static class ReturnData {
        public boolean isBalance;
        public int height;

        public ReturnData(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public static ReturnData process(Node head)
    {
        if(head == null)
        {
            return new ReturnData(true,0);
        }
        // 使用黑盒提前欠账获取信息
        ReturnData leftData = process(head.left);
        // 一旦返回是false,返回什么结果都是可以的
        if(!leftData.isBalance)
        {
            return new ReturnData(false,0);
        }
        ReturnData rightData = process(head.right);
        if(!rightData.isBalance)
        {
            return new ReturnData(false,0);
        }
        if(Math.abs(leftData.height - rightData.height) > 1)
        {
            return new ReturnData(false,0);
        }
        else
        {
            return new ReturnData(true,Math.max(leftData.height,rightData.height) + 1);
        }

    }

    public static boolean isBalance(Node head)
    {
        return process(head).isBalance;
    }

    public static void main(String[] args) {

    }
}
