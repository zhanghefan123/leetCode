package TREE.二叉树.从上到下打印二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
        {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while(!queue.isEmpty())
        {
            // 当前这一层
            ArrayList<Integer> tmp_list = new ArrayList<>();
            // 记录一下层的节点个数
            int len = queue.size();
            // 将当前层pop出来，并将下一层push进去。
            for(int i=0;i<len;i++)
            {
                TreeNode tmp = queue.pollFirst();
                tmp_list.add(tmp.val);
                if(tmp.left!=null)
                {
                    queue.offerLast(tmp.left);
                }
                if(tmp.right!=null)
                {
                    queue.offerLast(tmp.right);
                }
            }
            res.add(tmp_list);
        }
        return res;
    }
}
