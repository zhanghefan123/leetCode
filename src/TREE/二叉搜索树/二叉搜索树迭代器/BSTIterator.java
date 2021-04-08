package TREE.二叉搜索树.二叉搜索树迭代器;

import java.util.Deque;
import java.util.LinkedList;

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
public class BSTIterator {
    public Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new LinkedList<>();
        TreeNode current = root;
        while(current!=null)
        {
            this.stack.push(current);
            current = current.left;
        }
    }

    public int next() {

        TreeNode current = this.stack.pop();
        if(current.right!=null)
        {
            // 将右子结点的所有左子全部压入栈中
            TreeNode tmp = current.right;
            while(tmp!=null)
            {
                this.stack.push(tmp);
                tmp = tmp.left;
            }
        }
        return current.val;

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
