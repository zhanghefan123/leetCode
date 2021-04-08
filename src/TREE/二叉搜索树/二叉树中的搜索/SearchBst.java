package TREE.二叉搜索树.二叉树中的搜索;
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
public class SearchBst {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while(cur!=null)
        {
            if(cur.val == val)
            {
                return cur;
            }
            else if(val < cur.val)
            {
                if(cur.left!=null)
                {
                    cur = cur.left;
                }
                else
                {
                    cur = null;
                }
            }
            else
            {
                if(cur.right!=null)
                {
                    cur = cur.right;
                }
                else{
                    cur = null;
                }
            }
        }
        return null;
    }
}
