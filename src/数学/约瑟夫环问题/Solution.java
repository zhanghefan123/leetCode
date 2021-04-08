package 数学.约瑟夫环问题;
// 题目
/*
据说著名犹太历史学家Josephus有过以下的故事，罗马人占领乔塔帕特后，39个犹太人
和Josephus以及他的朋友躲到一个山洞之中,39个犹太人决定宁愿死也不被敌人抓到，
于是决定了一个自杀方式，41个人排成一个圆圈，有第一个人开始报数报数到3的人就自杀，
然后由下一个人重新报1，报数到3的人再自杀，这样依次下去，知道剩下最后一个人的时候，
那个人可以自由选择自己的命运，这就是著名的约瑟夫环问题，现在请使用单向环形链表描述该结构
并呈现整个自杀过程

输入:一个环形单链表的头结点head,和报数的值m
返回:最后生存下来的结点，且这个结点自己组成环形单向链表，其他结点都删掉。

进阶:
如果链表结点数为N，想在时间复杂度O(N)完成原问题的要求，如何实现?

* */
public class Solution {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // 暴力解，从每个结点开始都需要数数，数m次，时间复杂度为O(m * n)
    public static Node josephusKill1(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        // 计数器清0
        int count = 0;
        while (head != last) {
            // 如果加到了m准备进行杀人
            if (++count == m) {
                last.next = head.next;
                // 杀完人之后将计数器进行清0的操作
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    // O(N)解法
    // 思路
    /*
    剩余结点的数目     存活结点的编号
         1                1
         2                ?
         ……               ……
         存在一个公式逐步向上求解
         最终求解出剩余结点为N的时候
         最终存活的结点的编号
    * */

    // 推公式
    // 参见solution.md
    // 编号 = (报数-1) % i + 1 (i是环的长度)

    public static Node josephusKill2(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node cur = head.next;
        int tmp = 1; // tmp -> list size
        while (cur != head) {
            tmp++;
            cur = cur.next;
        }
        tmp = getLive(tmp, m); // tmp -> service node position
        while (--tmp != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    // i是整个约瑟夫环的长度，m是杀掉为m的结点。
    public static int getLive(int i, int m) {
        if (i == 1) {
            return 1;
        }
        // 旧 = (新 + (m-1)) % i + 1
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }

    public static void printCircularList(Node head) {
        if (head == null) {
            return;
        }
        System.out.print("Circular List: " + head.value + " ");
        Node cur = head.next;
        while (cur != head) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("-> " + head.value);
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = head1;
        printCircularList(head1);
        head1 = josephusKill1(head1, 3);
        printCircularList(head1);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = head2;
        printCircularList(head2);
        head2 = josephusKill2(head2, 3);
        printCircularList(head2);

    }
}
