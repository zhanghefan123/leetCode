package 图.DFS.由前序和中序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 首先构建一个map,将中序序列的值作为键，将中序序列的值对应的索引作为值，方便待会儿进行索引的查找。
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        // 一开始的原问题是通过两条完整的序列构建出树
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }


    public TreeNode build(int[] preorder,int[] inorder,int preorderLeft,int preorderRight,int inorderLeft,int inorderRight)
    {
        if(preorderLeft > preorderRight)
        {
            return null;
        }
        else
        {
            // 先序遍历序列的最左侧就是我们的根结点
            TreeNode root = new TreeNode(preorder[preorderLeft]);
            // 然后我们需要找到这个根节点在中序遍历序列之中的位置，从而划分开左右子树的范围。
            int root_pos = map.get(preorder[preorderLeft]);
            // 因为中序遍历序列是左根右，所以左侧的就是左子树结点，右侧的就是右子树结点
            int left_tree_size = root_pos - inorderLeft;
            // 然后进行递归的创建
            // 进行左子树的构建
            root.left = build(preorder,inorder,preorderLeft+1,preorderLeft+left_tree_size,inorderLeft,root_pos-1);
            // 进行右子树的构建
            root.right = build(preorder,inorder,preorderLeft+left_tree_size+1,preorderRight,root_pos+1,inorderRight);
            return root;
        }
    }
}