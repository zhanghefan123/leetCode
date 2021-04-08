package TREE.二叉树.Moris遍历;
// 问题
/*
我们之前进行的二叉树的遍历都需要使用到额外空间复杂度O(h),因为我们需要回到上一级
而我们没有指向上一级的指针，现在我们想做到额外空间复杂度O(1)，怎么进行操作。
* */

// 解决方案 -- 类似于线索二叉树的思想利用二叉树多余的空间。
/*
moris遍历流程
step1:来到的当前结点即为cur(引用)
step2:如果cur没有左孩子，cur向右进行移动(cur = cur.right)
      如果cur有左孩子，找到cur左子树上最右的结点，记为mostright
        > 如果mostright的right指针指向空，让其指向cur,cur向左移动
        > 如果mostright的right指针指向cur,让其指回空，cur向右移动
* */

// 举例:
/*
        1
       / \
      2  3
     /\  /\
    4 5 6 7
遍历的结果为:1 2 4 2 5 1 3 6 3 7
* */


// moris遍历的本质
/*
如果一个结点有左子树，那么moris遍历会遍历这个结点两次
如果一个结点没有左子树，那么moris遍历只会到达这个结点一次
* */



class Node {
      int val;
      Node left;
      Node right;
      Node(int x) { val = x; }
}

public class Solution {

    public static void process(Node head)
    {
        if(head == null)
        {
            return;
        }
        // 将打印行为放到第一次来到这个结点的时候就是先序遍历
        // 将打印行为放到第二次来到这个结点的时候就是中序遍历
        // 将打印行为放到第三次来到这个结点的时候就是后序遍历

        // 第一次到达
        System.out.println(head.val);
        process(head.left);
        // 第二次到达
        System.out.println(head.val);
        process(head.right);
        // 第三次到达
        System.out.println(head.val);
    }

    public static void morris(Node head)
    {
        if(head == null)
        {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null)
        {
            mostRight = cur.left;
            // 如果左孩子不为空则执行下面的代码
            if(mostRight != null)
            {
                // 找到左子树上最右的结点，两个条件都满足才可以向右
                // 否则就不能够往右了
                while(mostRight.right !=null && mostRight.right != cur)
                {
                    mostRight = mostRight.right;
                }

                // 如果mostright的right指针指向空，让其指向cur,cur向左移动
                if(mostRight.right == null)
                {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                // 如果mostright的right指针指向cur,让其指回空，cur向右移动
                else
                {
                    mostRight.right = null;
                }
            }
            // System.out.print(cur1.value + " ");
            // 如果左孩子为空则执行下面的代码
            cur = cur.right;
        }
        // System.out.println();
    }


    // moris遍历改先序
    public static void morrisPre(Node head)
    {
        if(head == null)
        {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null)
        {
            mostRight = cur.left;
            // 如果左孩子不为空则执行下面的代码
            if(mostRight != null)
            {
                // 找到左子树上最右的结点，两个条件都满足才可以向右
                // 否则就不能够往右了
                while(mostRight.right !=null && mostRight.right != cur)
                {
                    mostRight = mostRight.right;
                }

                // 如果mostright的right指针指向空，让其指向cur,cur向左移动
                if(mostRight.right == null)
                {
                    mostRight.right = cur;
                    // 当左子树不为空，什么时候是第一次来到这个结点的时候
                    // 是来到左子树最右侧结点，且最右侧结点的右指针为空的时候
                    System.out.print(cur.val + " ");
                    cur = cur.left;
                    continue;
                }
                // 如果mostright的right指针指向cur,让其指回空，cur向右移动
                else
                {
                    mostRight.right = null;
                }
            }
            else{
                // 当没有左子树的时候再也不会回到该结点。
                System.out.print(cur.val + " ");
            }
            // 如果左孩子为空则执行下面的代码
            cur = cur.right;
        }
        System.out.println();
    }

    // moris改中序
    public static void morrisIn(Node head)
    {
        if(head == null)
        {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null)
        {
            mostRight = cur.left;
            // 如果左孩子不为空则执行下面的代码
            if(mostRight != null)
            {
                // 找到左子树上最右的结点，两个条件都满足才可以向右
                // 否则就不能够往右了
                while(mostRight.right !=null && mostRight.right != cur)
                {
                    mostRight = mostRight.right;
                }

                // 如果mostright的right指针指向空，让其指向cur,cur向左移动
                if(mostRight.right == null)
                {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                // 如果mostright的right指针指向cur,让其指回空，cur向右移动
                else
                {
                    mostRight.right = null;
                }
            }
            // 最后一次来到该节点的时候打印
            System.out.print(cur.val + " ");
            // 如果左孩子为空则执行下面的代码
            cur = cur.right;
        }
        System.out.println();
    }

    // morisPos 后序遍历
    public static void morrisPos(Node head){
        if(head == null)
        {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null)
        {
            mostRight = cur.left;
            // 如果左孩子不为空则执行下面的代码
            if(mostRight != null)
            {
                // 找到左子树上最右的结点，两个条件都满足才可以向右
                // 否则就不能够往右了
                while(mostRight.right !=null && mostRight.right != cur)
                {
                    mostRight = mostRight.right;
                }

                // 如果mostright的right指针指向空，让其指向cur,cur向左移动
                if(mostRight.right == null)
                {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                // 如果mostright的right指针指向cur,让其指回空，cur向右移动
                else
                {
                    mostRight.right = null;
                    // 逆序打印左子树的右边界
                    printEdge(cur.left);
                }
            }
            // 最后一次来到该节点的时候打印
            System.out.print(cur.val + " ");
            // 如果左孩子为空则执行下面的代码
            cur = cur.right;
        }
        // 单独逆序打印整棵树的右边界
        printEdge(head);
        System.out.println();
    }

    // 如何逆序打印整棵树的右边界
    /*
        A
       /   \
      B      \
       \      \
        C      \
         \     /
          D   /
           \ /
            E
    如何逆序打印B,C,D,E，首先让B的右指针指向空，
    C的右指针指向B，D的右指针指向C，E的右指针指向D
    然后将逆序将EDCB打印完，再将B的右指针调整指向C
    C的右指针调整指向D，D的右指针调整指向E，E的右指针
    指向空，完成逆序打印

    * */
    public static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }


}
