package TREE.树型dp.二叉树中最长的连续序列2;
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

    public int res;

    public class ReturnType{
        // 以这个结点为结尾的最长的降序序列的长度
        int down_max_length;
        // 以这个结点为结尾的最长的升序序列的长度
        int up_max_length;
        // 构造函数
        public ReturnType(int down_max_length,int up_max_length)
        {
            this.down_max_length = down_max_length;
            this.up_max_length = up_max_length;
        }
    }

    public ReturnType process(TreeNode root)
    {
        if(root == null)
        {
            return new ReturnType(0,0);
        }
        if(root.left == null && root.right == null)
        {
            return new ReturnType(1,1);
        }
        ReturnType left_res = process(root.left);
        ReturnType right_res = process(root.right);
        int down_max_length = 1;
        int up_max_length = 1;
        // 左树降序
        if(root.left != null && (root.left.val == root.val + 1))
        {
            down_max_length = Math.max(down_max_length,left_res.down_max_length + 1);
        }
        // 左树升序
        if(root.left != null && (root.left.val + 1 == root.val))
        {
            up_max_length = Math.max(up_max_length,left_res.up_max_length + 1);
        }
        // 右树降序
        if(root.right != null && (root.right.val == root.val + 1))
        {
            down_max_length = Math.max(down_max_length,right_res.down_max_length + 1);
        }
        // 右树升序
        if(root.right != null && (root.right.val + 1 == root.val))
        {
            up_max_length = Math.max(up_max_length,right_res.up_max_length + 1);
        }
        res = Math.max(Math.max(up_max_length,down_max_length),res);
        if(!(root.left == null) && !(root.right == null))
        {
            if(root.val == root.left.val+1 && root.val+1 == root.right.val)
            {
                res = Math.max((left_res.up_max_length + right_res.down_max_length + 1), res);
            }
            if(root.val+1 == root.left.val && root.val == 1 + root.right.val)
            {
                res = Math.max((left_res.down_max_length + right_res.up_max_length + 1),res);
            }
        }
        return new ReturnType(down_max_length,up_max_length);
    }

    public int longestConsecutive(TreeNode root) {
        if(root != null)
        {
            res = 1;
        }
        process(root);
        return res;
    }
}