package TREE.二叉树.二叉树的最小深度;
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
    public int minDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        return process(root);
    }

    public int process(TreeNode root)
    {
        if(root == null)
        {
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null)
        {
            return 1;
        }
        int left_min_depth = process(root.left);
        int right_min_depth = process(root.right);
        return Math.min(left_min_depth,right_min_depth) + 1;
    }
}
