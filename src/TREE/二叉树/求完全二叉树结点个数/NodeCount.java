package TREE.二叉树.求完全二叉树结点个数;
//先找到完全二叉树左子树的左边界的层数，这是整个完全二叉树的层数
//然后找到完全二叉树右子树的左边界的层数，如果已经到达了最后一层
//则说明完全二叉树左子树是满的，然后就可以求出结点的数目。然后递归的求
//右子树的结点个数。但是如果完全二叉树的右子树的左边界的层数没有到达最后一层
//说明右子树是满的，然后去递归左树。
public class NodeCount {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    //node代表当前结点，l代表当前结点的深度，h代表的是整棵树的深度
    public static int bs(Node node, int l, int h) {
        //如果level来到最后一层，就说明是叶节点，return 1
        if (l == h) {
            return 1;
        }
        //求右子树的层数
        if (mostLeftLevel(node.right, l + 1) == h) {
            //1 << (h-l)代表2^(h-l)次方，代表的就是左子树的结点个数
            return (1 << (h - l)) + bs(node.right, l + 1, h);
        } else {
            //1 << (h-l-1)代表2^(h-l-1)次方，代表的就是右子树的结点个数
            return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
        }
    }

    //算出完全二叉树的深度
    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }

}
