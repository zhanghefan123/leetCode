package 图.DFS.对称二叉树;

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
// 使用递归--深度优先搜索实现。
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root,root);
    }

    public boolean helper(TreeNode rootLeft,TreeNode rootRight)
    {
        if(rootLeft == null && rootRight==null)
        {
            return true;
        }
        if(rootLeft == null || rootRight==null)
        {
            return false;
        }
        else
        {
            return rootLeft.val == rootRight.val && helper(rootLeft.left,rootRight.right) && helper(rootRight.left,rootLeft.right);
        }
    }
}

//使用迭代，广度优先搜索
class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}

