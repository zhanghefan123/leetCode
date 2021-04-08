package 图.DFS.路径总和;

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // base_case
        if(root == null)
        {
            return false;
        }
        if(root.left == null && root.right == null)
        {
            if(targetSum == root.val)
            {

                return true;
            }
            else
            {
                return false;
            }
        }
        boolean flag1 = false;
        boolean flag2 = false;
        if(root.left != null)
        {
            flag1 =  hasPathSum(root.left,targetSum-root.val);
        }
        if(root.right != null)
        {
            flag2 =  hasPathSum(root.right,targetSum-root.val);
        }
        return flag1 || flag2;
    }
}