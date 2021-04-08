package TREE.二叉树.翻转二叉树以匹配先序遍历;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    int i = 0;
    List<Integer> res = new ArrayList<>();
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (dfs(root, voyage)) {
            return res;
        }
        return Arrays.asList(-1);
    }

    boolean dfs(TreeNode root, int[] v) {
        if (root == null) return true;
        if (root.val != v[i++]) return false;
        if (root.left != null && root.left.val != v[i]) {
            res.add(root.val);
            // 因为左右子树进行了交换所以先左子再右子
            return dfs(root.right, v) && dfs(root.left, v);
        }
        // 因为左右子树没有进行交换所以先左子再右子
        return dfs(root.left, v) && dfs(root.right, v);
    }
}
