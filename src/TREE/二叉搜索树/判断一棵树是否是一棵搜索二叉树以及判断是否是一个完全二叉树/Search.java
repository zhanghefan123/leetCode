package TREE.二叉搜索树.判断一棵树是否是一棵搜索二叉树以及判断是否是一个完全二叉树;

import java.util.LinkedList;
import java.util.Queue;
//二叉树的中序遍历结果是依次升序的就是一个搜索二叉树，通过这种方式进行判断即可
public class Search {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isValidBST(Node node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.value <= lower || node.value >= upper) {
            return false;
        }
        // 当递归左子树的时候上界是根节点，下界是lower,左子树的结点需要在-∞到根节点之间
        // 当递归右子树的时候下界是根节点，上界时higher，右子树的结点需要在根节点到+∞之间
        return isValidBST(node.left, lower, node.value) && isValidBST(node.right, node.value, upper);
    }


    //判断是否是完全二叉树，二叉树按层进行遍历，如果一个结点存在右孩子没有左孩子则直接退出
    //并且返回false，如果一个结点不是左右两个孩子都全就是要么只有左孩子或者左右孩子都没有，
    //其后的所有节点都需要是叶结点，否则一定不是完全二叉树。
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        //用来进行层序遍历
        Queue<Node> queue = new LinkedList<Node>();
        boolean leaf = false;//是否开启了第二种情况的阶段。
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            //如果开启了叶结点的阶段，后续拿到的所有结点都将是叶子结点。
            //如果一个结点的左孩子为空，右孩子不为空则直接return false
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            }
            //即左右孩子都为空，或者左孩子不为空，右孩子为空
            if(l==null || r==null)
            {
                leaf = true;
            }
        }
        return true;
    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isValidBST(head,Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println(isCBT(head));

    }
}
