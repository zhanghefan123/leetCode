package 图.DFS.前序遍历构造搜索二叉树;

import java.util.ArrayList;

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
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,0,preorder.length-1);
    }

    // 与通过前序和中序构建二叉树的思想几乎一致
    public TreeNode build(int[] preorder,int preorderLeft,int preorderRight)
    {
        if(preorderLeft > preorderRight)
        {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        int split = preorderLeft+1;
        int i;
        for(i = preorderLeft+1; i <= preorderRight;i++)
        {
            if(root.val < preorder[i])
            {
                split = i;
                break;
            }
        }
        if(i == preorderRight + 1)
        {
            split = preorderRight + 1;
        }
        root.left = build(preorder, preorderLeft+1,split-1);
        root.right = build(preorder, split,preorderRight);
        return root;
    }
}
