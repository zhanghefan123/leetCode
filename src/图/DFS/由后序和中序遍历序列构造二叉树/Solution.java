package 图.DFS.由后序和中序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;
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
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        for(int i=0;i<length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(inorder,postorder,0,length-1,0,length-1);
    }

    public TreeNode helper(int[] inorder,int[] postorder,int inLeft,int inRight,int postLeft,int postRight)
    {
        if(postLeft > postRight)
        {
            return null;
        }
        else
        {
            TreeNode root = new TreeNode(postorder[postRight]);
            // 获取中序遍历序列根结点的位置
            int inorder_root_pos = map.get(postorder[postRight]);
            // 获取左子树的结点个数
            int left_tree_size = inorder_root_pos - inLeft;
            int right_tree_size = inRight - inorder_root_pos;
            // 开始进行递归构造
            root.right = helper(inorder,postorder,inorder_root_pos+1,inRight,postRight-right_tree_size,postRight-1);
            root.left = helper(inorder,postorder,inLeft,inorder_root_pos-1,postRight-right_tree_size-left_tree_size,postRight-right_tree_size-1);
            return root;
        }
    }
}