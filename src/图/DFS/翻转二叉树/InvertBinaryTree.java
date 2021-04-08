package 图.DFS.翻转二叉树;


// 每个节点都进行了翻转。
public class InvertBinaryTree {

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

      public TreeNode invertTree(TreeNode root) {
            //将根结点的左右子树进行交换
            if(root == null)
            {
                return null;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }

}
