package TREE.二叉树.isSymmetric.递归实现;
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
    public boolean isSymmetric(TreeNode root) {
        return dfs(root,root);
    }

    // 使用递归方式进行解决
    public boolean dfs(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null)
        {
            return true;
        }
        else if(root1 == null || root2 == null)
        {
            return false;
        }
        else if(root1.val != root2.val)
        {
            return false;
        }
        else{
            // 一个根执行的是根左右的方式
            // 另一个根执行的是根右左的方式
            // 只要每一次访问根节点的时候判断两者是否相等即可。
            boolean flag1 = dfs(root1.left,root2.right);
            boolean flag2 = dfs(root1.right,root2.left);
            return flag1 && flag2;
        }
    }
}
