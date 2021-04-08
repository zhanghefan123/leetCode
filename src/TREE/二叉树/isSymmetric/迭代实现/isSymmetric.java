package TREE.二叉树.isSymmetric.迭代实现;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class isSymmetric {

        public boolean isSymmetric(TreeNode root) {
            if(root==null)
            {
                return true;
            }
            return check(root.left, root.right);
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
                //将左子树的左子和右子树的右子对比
                //将右子树的左子和左子树的右子对比
            }
            return true;
        }

}
