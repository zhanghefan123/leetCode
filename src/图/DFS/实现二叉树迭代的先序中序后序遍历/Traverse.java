package 图.DFS.实现二叉树迭代的先序中序后序遍历;

import java.util.Stack;

public class Traverse {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //先序递归遍历，先打印根结点然后打印左子树再打印右子树
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //中序递归遍历，先打印左子树，然后打印根结点，然后打印右子树
    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    //后序递归遍历，先打印左子树，再打印右子树，再打印根结点
    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    //非递归实现先序遍历
    //算法思想
    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            //先将根结点进行压栈处理
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            //当栈非空的时候，进行循环
            while (!stack.isEmpty()) {
                head = stack.pop();//弹出栈顶元素
                System.out.print(head.value + " ");
                //栈是先进后出的，为了正好符合根左右的特点，先压入右孩子，再压入左孩子
                //如果当前弹栈的结点存在右孩子先压入右孩子
                if (head.right != null) {
                    stack.push(head.right);
                }
                //如果当前弹栈的结点存在左孩子则后压入左孩子
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    //非递归实现中序遍历
    //算法思想
    /*
    中序遍历的访问顺序若树为
                A
              B   C
            D E  F G
    则中序遍历序列为D B E A F C G.

    我们的非递归方式便需要模拟这个过程。
    从根结点开始，如果根结点不为空则将根结点的左孩子全部压栈
    直到没有左子树，将栈弹出并将弹出的结点进行访问，然后让当前
    指针指向这个弹出结点的右孩子再将它的左孩子全部压栈。

    遍历方式呈现之字形。
    */
    public static void inOrderUnRecur(Node head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    //将左孩子全部压入栈中。
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();//弹出其父结点。
                    System.out.print(head.value + " ");//访问父结点。
                    head = head.right;//访问右孩子。
                }
            }
        }
        System.out.println();
    }

    //非递归实现后续遍历
    //算法思想
    //我们实现先根再右再左，因为根左右的先序比较简单，然后该进行打印的时候我们不进行打印，而是将要进行打印的数据存到栈之中去
    //然后当我们完成了遍历之后，再将栈中的数据依次的进行弹出即为左右中的遍历次序了
    public static void posOrderUnRecur1(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();//为了实现根右左而建立的辅助栈。
            Stack<Node> s2 = new Stack<Node>();//要打印的序列存储在这个栈。
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                //将要进行打印的数不进行打印压入到栈中
                s2.push(head);
                //如果左孩子非空则先压入左孩子
                if (head.left != null) {
                    s1.push(head.left);
                }
                //如果右孩子非空则后压入右孩子
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().value + " ");
            }
        }

    }

    //仅仅使用一个栈
    public static void posOrderUnRecur2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);

    }
}
