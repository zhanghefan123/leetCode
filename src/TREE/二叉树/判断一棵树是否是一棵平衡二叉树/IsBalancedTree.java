package TREE.二叉树.判断一棵树是否是一棵平衡二叉树;
//平衡二叉树：任意一个结点的左子树和右子树的高度差不超过1.高度套路化的处理
//递归函数非常好用，我们可以收集左子树上的信息，收集右子树上的信息然后综合进行判断。
//本题的思路，判断左子树是否平衡，判断右子树是否平衡，如果左子树和右子树都平衡则两树的高度差不超过1
public class IsBalancedTree {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.value = data;
        }
    }

    // Recursively obtain the height of a tree. An empty tree has -1 height
    private int height(TreeNode root) {
        // An empty tree has height -1
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        // An empty tree satisfies the definition of a balanced tree
        if (root == null) {
            return true;
        }

        // Check if subtrees have height within 1. If they do, check if the
        // subtrees are balanced
        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left)&& isBalanced(root.right);
    }
}
