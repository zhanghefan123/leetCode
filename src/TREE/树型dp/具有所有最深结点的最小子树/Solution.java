package TREE.树型dp.具有所有最深结点的最小子树;

import java.util.HashMap;
import java.util.Map;

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
    Map<TreeNode, Integer> depth;
    int max_depth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = new HashMap();
        depth.put(null, -1);
        dfs(root, null);
        max_depth = -1;
        for (Integer d: depth.values())
            max_depth = Math.max(max_depth, d);

        return answer(root);
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            // 记录每个结点的深度，结点作为key，结点的值作为value
            depth.put(node, depth.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public TreeNode answer(TreeNode node) {
        // 如果root == null 或者这个结点的深度==最大的深度，返回这个结点
        if (node == null || depth.get(node) == max_depth)
            return node;
        // answer函数返回的是这棵树之中的最深的结点，如果没有最深的结点则返回null
        TreeNode L = answer(node.left),
                R = answer(node.right);
        // 如果左右子树中都含有最深的结点，直接返回
        if (L != null && R != null) return node;
        if (L != null) return L;
        if (R != null) return R;
        return null;
    }
}
