package TREE.完全二叉树.如何判断一棵树是否是完全二叉树;

import java.util.LinkedList;
import java.util.Queue;

// 解决方案
/*
层序遍历所有节点:
条件1:有右孩子没有左孩子返回false
条件2:如果一个结点只有左孩子没有右孩子，或者是叶节点
那么接下来的所有结点都只能是叶节点
* */
public class Solution {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data)
        {
            this.value = data;
        }
    }
    public static boolean isCBT(Node head)
    {
        if(head == null)
        {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        // 代表了条件2
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while(!queue.isEmpty())
        {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if(((leaf && (l != null || r!= null)) || (l == null && r!= null)))
            {
                return false;
            }
            if(l != null)
            {
                queue.offer(l);
            }
            if(r != null)
            {
                queue.offer(r);
            }
            if(l == null || r == null)
                // 只有左孩子但是没有右孩子，或者是叶节点,阶段开启
                leaf = true;
            }
            return true;
    }

}
