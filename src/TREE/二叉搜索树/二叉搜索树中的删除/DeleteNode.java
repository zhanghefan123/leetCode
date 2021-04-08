package TREE.二叉搜索树.二叉搜索树中的删除;
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
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        boolean flag = true; // true 代表左子，false代表右子
        while(cur!=null)
        {
            if(cur.val == key)
            {
                // 左子是否为空
                boolean left = cur.left == null;
                // 右子是否为空
                boolean right = cur.right == null;
                // 如果左右子都为空,此时需要让前驱节点的指针指向空
                if(left && right)
                {
                    if(pre == null)
                    {
                        return null;
                    }
                    else
                    {
                        if(flag)
                        {
                            pre.left = null;
                        }
                        else
                        {
                            pre.right = null;
                        }
                    }
                }
                // 只有左子
                else if(!left && right)
                {
                    if(pre == null)
                    {
                        return cur.left;
                    }
                    else
                    {
                        if(flag)
                        {
                            pre.left = cur.left;
                        }
                        else
                        {
                            pre.right = cur.left;
                        }
                    }

                }
                // 只有右子
                else if(left && !right)
                {
                    if(pre == null)
                    {
                        return cur.right;
                    }
                    else
                    {
                        if(flag)
                        {
                            pre.left = cur.right;
                        }
                        else
                        {
                            pre.right = cur.right;
                        }
                    }

                }
                // 左右子都存在的情况
                else
                {
                    //找到右子节点
                    TreeNode right_node = cur.right;
                    if(right_node.left == null)
                    {
                        cur.val = right_node.val;
                        cur.right = right_node.right;
                    }
                    else
                    {
                        TreeNode right_node_pre = cur;
                        while(right_node.left != null)
                        {
                            right_node_pre = right_node;
                            right_node = right_node.left;
                        }
                        System.out.println(right_node.val);
                        System.out.println(right_node_pre.val);
                        cur.val = right_node.val;
                        right_node_pre.left = right_node.right;
                    }
                }
                break;
            }
            else if(cur.val < key)
            {
                pre = cur;
                flag = false;
                cur = cur.right;
            }
            else
            {
                pre = cur;
                flag = true;
                cur = cur.left;
            }
        }

        return root;
    }
}
