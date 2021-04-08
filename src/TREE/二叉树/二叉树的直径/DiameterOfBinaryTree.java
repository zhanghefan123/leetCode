package TREE.二叉树.二叉树的直径;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class DiameterOfBinaryTree {

    private int max_length = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        Depth(root);
        return max_length;
    }
    public int Depth(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        if(root.left==null&root.right==null)
        {
            return 1;
        }
        int leftDepth = Depth(root.left);
        int rightDepth = Depth(root.right);
        if(max_length < (leftDepth+rightDepth))
        {
            max_length = leftDepth+rightDepth;
        }
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
