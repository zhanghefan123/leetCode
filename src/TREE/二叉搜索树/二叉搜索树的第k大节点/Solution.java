package TREE.二叉搜索树.二叉搜索树的第k大节点;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

// 注意：递归函数的return并不能一步跳出。
// 而是只能回到上一层。
public class Solution {
    public int count;
    public int k;
    public int res;

    public int kthLargest(TreeNode root, int k) {
        this.count = 1;
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        dfs(root.right);
        if(this.k == count)
        {
            this.res = root.val;
            count++;
            return;
        }
        else
        {
            count++;
        }
        dfs(root.left);
    }
}
