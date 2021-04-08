package 图.DFS.相同的树;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        {
            return true;
        }
        if(p == null || q == null)
        {
            return false;
        }
        else if(p.val != q.val)
        {
            return false;
        }
        else
        {
            boolean flag1 = isSameTree(p.left,q.left);
            boolean flag2 = isSameTree(p.right,q.right);
            return flag1 && flag2;
        }
    }

}
