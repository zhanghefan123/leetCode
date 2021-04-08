package TREE.树型dp.二叉树最长连续序列;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {

    public int res = Integer.MIN_VALUE;

    public class ReturnType{
        int maxLength;
        public ReturnType(int maxLength)
        {
            this.maxLength = maxLength;
        }
    }

    // process之中返回的是以某个结点为最高结点的最长连续路径的长度
    public ReturnType process(TreeNode root)
    {
        if(root == null)
        {
            return new ReturnType(0);
        }
        if(root.left == null && root.right == null)
        {
            return new ReturnType(1);
        }
        ReturnType left_res = process(root.left);
        ReturnType right_res = process(root.right);
        int maxLength = 1;
        if(!(root.left==null) && (root.val + 1 == root.left.val))
        {
            maxLength = Math.max(maxLength,left_res.maxLength + 1);
        }
        if(!(root.right==null) && (root.val + 1 == root.right.val))
        {
            maxLength = Math.max(maxLength,right_res.maxLength + 1);
        }
        this.res = Math.max(res,maxLength);
        return new ReturnType(maxLength);
    }

    public int longestConsecutive(TreeNode root) {
        ReturnType tmp = process(root);
        return Math.max(res,tmp.maxLength);
    }
}
