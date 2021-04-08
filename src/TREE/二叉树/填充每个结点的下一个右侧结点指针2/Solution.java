package TREE.二叉树.填充每个结点的下一个右侧结点指针2;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Solution {
    public Node connect(Node root) {
        if(root == null)
        {
            return null;
        }
        // 每一层最左侧的结点。
        Node leftMost = root;
        while(leftMost!=null)
        {
            // preLevelNode用来遍历上一层的结点
            Node preLevelNode = leftMost;
            // 让leftMost指向为null
            leftMost = null;
            // 当发现第一个结点的时候将传递引用，接下来的就是更新next值。
            int count = 0;
            // 找到下一层的最左侧结点并传递引用给这个变量
            Node linkNode = null;
            while(preLevelNode!=null)
            {
                if(preLevelNode.left!=null)
                {
                    if(count == 0)
                    {
                        linkNode = preLevelNode.left;
                        leftMost = linkNode;
                    }
                    else
                    {
                        linkNode.next = preLevelNode.left;
                        linkNode = linkNode.next;
                    }
                    count++;
                }
                if(preLevelNode.right!=null)
                {
                    if(count == 0)
                    {
                        linkNode = preLevelNode.right;
                        leftMost = linkNode;
                    }
                    else
                    {
                        linkNode.next = preLevelNode.right;
                        linkNode = linkNode.next;
                    }
                    count++;
                }
                preLevelNode = preLevelNode.next;
            }


        }
        return root;
    }
}
