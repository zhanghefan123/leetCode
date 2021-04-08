package 图.DFS.求根到叶子结点的数字之和.递归实现;
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
    public int final_sum;

    public Solution(){
        this.final_sum = 0;
    }

    public int sumNumbers(TreeNode root) {
        process(root,0);
        return final_sum;
    }

    public void process(TreeNode root,int sum)
    {
        if(root == null)
        {
            return;
        }
        if(root.left == null && root.right == null)
        {
            this.final_sum += sum * 10 + root.val;
            return;
        }
        process(root.left,sum * 10 + root.val);
        process(root.right,sum * 10 + root.val);
    }
}
