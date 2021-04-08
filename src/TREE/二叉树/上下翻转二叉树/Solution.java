package TREE.二叉树.上下翻转二叉树;
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null)
        {
            return root;
        }
        // 因为将结点的左右指针置空了
        // 所以这一步只能这样做
        // ------------------------
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        // ------------------------
        TreeNode p = upsideDownBinaryTree(left);
        left.left = right;
        left.right = root;
        return p;
    }
}
