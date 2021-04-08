package TREE.二叉树.将二叉树展开为单链表;

import java.util.ArrayList;

// 简单解法
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public class Solution {
        public ArrayList<TreeNode> list;

        public void flatten(TreeNode root) {
            this.list = new ArrayList<>();
            pre_dfs(root);
            TreeNode cur = root;
            int count = 0;
            for (TreeNode tmp : list) {
                if (count == 0) {
                    count++;
                    continue;
                } else {
                    cur.left = null;
                    cur.right = tmp;
                    cur = cur.right;
                }
            }
        }

        public void pre_dfs(TreeNode root) {
            if (root == null) {
                return;
            } else {
                list.add(root);
                pre_dfs(root.left);
                pre_dfs(root.right);
            }
        }
    }
}
