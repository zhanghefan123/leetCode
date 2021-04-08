package TREE.树型dp.二叉树之中的最长交错路径;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class Solution {
    private int maxPath = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    private int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = 1 + left[1];
        res[1] = 1 + right[0];
        maxPath = Math.max(maxPath, Math.max(res[0], res[1]));
        return res;
    }
}