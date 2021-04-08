package 图.DFS.最近的公共祖先;
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
class Solution {

    private TreeNode ans;

    public Solution() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        // 左子树之中存在p，q之中的一个节点
        boolean lson = dfs(root.left, p, q);
        // 右子树之中存在p,q之中的一个节点
        boolean rson = dfs(root.right, p, q);
        // 只有两种情况可能是最近公共祖先
        // 情况1：p或q是根节点，另一个节点在子树上。
        // 情况2:p在左子树，q在右子树，或者p在右子树，q在左子树
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
            // 这个时候就可以进行返回了，因为找到了从下向上找到的是最近的。
            return true;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}