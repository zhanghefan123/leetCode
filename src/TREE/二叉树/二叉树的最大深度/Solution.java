package TREE.二叉树.二叉树的最大深度;
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
    public int maxDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        if(root.left == null && root.right == null)
        {
            return 1;
        }
        int depth_left = maxDepth(root.left);
        int depth_right = maxDepth(root.right);
        return Math.max(depth_left,depth_right) + 1;
    }
}
