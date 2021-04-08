package TREE.二叉树.填充每个结点的下一个右侧结点指针;
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
};

public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node leftmost = root;

        // 每次都从最左侧开始进行遍历，当没有左孩子之后，退出循环，返回结果
        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1 -- 当一开始为根节点的时候只需要连接两个结点。
                head.left.next = head.right;

                // CONNECTION 2 -- 当深入到第二层之后就需要连接三个结点了。
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }
        return root;
    }
}
