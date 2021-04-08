package LinkedList.查看单链表中入环的第一个结点;

public class CheckCircle {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //算法思想，使用hashSet
    /*
    首先准备一个hashSet，然后开始进行链表的遍历，
    此时hashSet为空，如果结点在hashSet中不存在则放入hashSet
    之中，如果结点在hashSet之中存在的话就将这个结点进行返回
    这就是第一个入环的结点。
    */

    //算法思想，不使用hashSet
    /*
    准备两个指针，准备快慢指针，快指针一次走两步，慢指针一次走一步
    然后当两者相等的时候，快指针重新回到头部，然后两个指针同时以步长
    为1向前进行运动，最终它们会相遇在入环结点
    * */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; // n1 -> slow
        Node n2 = head.next.next; // n2 -> fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; // n2 -> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }




}
