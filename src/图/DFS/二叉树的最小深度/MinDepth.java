package 图.DFS.二叉树的最小深度;

import java.util.LinkedList;
import java.util.Queue;

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

// 使用深度优先遍历算法进行实现。
public class MinDepth {
    public int minLength = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        dfs(root,1);
        return minLength;
    }

    // 在向下的时候同时记录当前的深度。
    public void dfs(TreeNode root,int level)
    {
        if(root == null)
        {
            return;
        }

        if(root.left != null)
        {
            dfs(root.left,level+1);
        }
        if(root.right != null)
        {
            dfs(root.right,level+1);
        }
        // 当到达叶子节点的时候返回。
        if(root.right == null && root.left == null)
        {
            minLength = Integer.min(minLength,level);
            return;
        }
    }
}

// 使用广度优先算法进行求解
// 在存储TreeNode的同时要注意存储好结点的深度。
class Solution {
    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }

        return 0;
    }
}