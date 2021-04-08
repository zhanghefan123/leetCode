package TREE.二叉树.二叉搜索树的范围和;
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
    public int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
        {
            return 0;
        }
        if(root.val < low)
        {
            rangeSumBST(root.right,low,high);
        }
        else if(root.val > high)
        {
            rangeSumBST(root.left,low,high);
        }
        else{
            sum += root.val;
            rangeSumBST(root.right,low,high);
            rangeSumBST(root.left,low,high);
        }
        return sum;
    }
}
