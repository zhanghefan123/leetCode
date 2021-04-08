package TREE.二叉树.判断一棵树是否是一棵平衡二叉树.自顶向下进行递归的思路;
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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        // 使用自顶向下的方法进行解决
        // 即先判断根节点，然后递归的判断左子树和右子树
        int left = height(root.left);
        int right = height(root.right);
        boolean is_left = isBalanced(root.left);
        boolean is_right = isBalanced(root.right);
        return is_left && is_right && (Math.abs(left-right)<=1);
    }

    public int height(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        else
        {
            int left = height(root.left);
            int right = height(root.right);
            return Math.max(left,right)+1;
        }
    }
}
