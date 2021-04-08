package TREE.树型dp.最长同值路径;
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

    // 整棵树之中的最长同值路径
    public int res;

    public class ReturnType{
        // 以本结点结尾的最长路径
        int longestSameValueLength;
    }

    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        else{
            this.res = 1;
        }
        process(root);
        return res - 1;
    }

    // 这个递归函数返回的是以本结点结尾的最长同值路径
    public int process(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int left_res = process(root.left);
        int right_res = process(root.right);
        int endByMe = 1;
        if(root.left == null && root.right == null)
        {
            endByMe = 1;
        }
        else if(root.left != null && root.right == null)
        {
            if(root.left.val == root.val)
            {
                endByMe = Math.max(endByMe,left_res+1);
                res = Math.max(res,left_res+1);
            }
            else{
                endByMe = 1;
            }
        }
        else if(root.left == null && root.right != null)
        {
            if(root.right.val == root.val)
            {
                endByMe = Math.max(endByMe,right_res+1);
                res = Math.max(res,right_res+1);
            }
            else{
                endByMe = 1;
            }
        }
        else{
            if(root.val == root.left.val && root.val == root.right.val)
            {
                endByMe = Math.max(left_res+1,right_res+1);
                res = Math.max(res,left_res + right_res + 1);
            }
            else if(root.val == root.left.val && root.val != root.right.val)
            {
                endByMe = Math.max(endByMe,left_res + 1);
                res = Math.max(res,left_res + 1);
            }
            else if(root.val == root.right.val && root.val != root.left.val){

                endByMe = Math.max(endByMe,right_res+1);
                res = Math.max(res,right_res + 1);
            }
            else
            {
                endByMe = 1;
            }
        }
        return endByMe;
    }
}