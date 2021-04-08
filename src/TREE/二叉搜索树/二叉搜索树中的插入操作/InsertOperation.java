package TREE.二叉搜索树.二叉搜索树中的插入操作;
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
public class InsertOperation {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
        {
            return new TreeNode(5);
        }
        TreeNode cur = root;
        TreeNode pre = null;
        boolean flag = true;// true代表pre的左孩子是cur,false代表pre的右孩子是cur
        while(true)
        {
            if(cur == null)
            {
                if(flag)
                {
                    pre.left = new TreeNode(val,null,null);
                }
                else
                {
                    pre.right = new TreeNode(val,null,null);
                }
                break;
            }

            if(cur.val < val)
            {
                pre = cur;
                cur = cur.right;
                flag = false;
            }
            else
            {
                pre = cur;
                cur = cur.left;
                flag = true;
            }
        }
        return root;
    }
}
