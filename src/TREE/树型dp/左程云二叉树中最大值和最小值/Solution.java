package TREE.树型dp.左程云二叉树中最大值和最小值;

// 递归方式进行实现
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

    public static class ReturnData{
        public int max;
        public int min;
        public ReturnData(int min,int max)
        {
            this.min = min;
            this.max = max;
        }
    }

    public static ReturnData process (Node head)
    {
        if(head == null)
        {
            // 有待填充
            return new ReturnData(
                Integer.MAX_VALUE,
                Integer.MIN_VALUE
            );
        }
        // 首先默认能够返回最小和最大
        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);
        // 根据假设已经拥有的信息返回我的最下和最大
        return new ReturnData(
                Math.min(Math.min(leftData.min,rightData.min),head.value),
                Math.max(Math.max(leftData.max,rightData.max),head.value)
        );
    }

}
