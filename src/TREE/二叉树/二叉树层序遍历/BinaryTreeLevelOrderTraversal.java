package TREE.二叉树.二叉树层序遍历;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
    /*
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list_error = new ArrayList<>();
        if(root == null)
        {
            return list_error;
        }
        List<List<Integer>> return_list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> array_root = new ArrayList<>();
        array_root.add(root.val);
        return_list.add(array_root);
        deque.offerFirst(root);
        int size;
        while(deque.size()>0)
        {
            size = deque.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<size;i++) //size即为父结点的数目，就相当于用所有的父结点将所有的子结点抓出来。
            {
                TreeNode node_temp = deque.pollLast();
                if(node_temp.left!=null)
                {
                    deque.offerFirst(node_temp.left);//位于一层
                    temp.add(node_temp.left.val);
                }
                if(node_temp.right!=null)
                {
                    deque.offerFirst(node_temp.right);//位于一层
                    temp.add(node_temp.right.val);
                }
            }
            if(temp.size()>0)
            {
                return_list.add(temp);
            }

        }
        return return_list;

    }*/
}
