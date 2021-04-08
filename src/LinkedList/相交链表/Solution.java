package LinkedList.相交链表;

public class Solution {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    //找到链表1和链表2的相交的第一个结点。
    //将链表1所有的结点放到hashSet，然后遍历链表2，判断其中的每一个结点
    //是否在链表之中，第一个在的即为相交结点，如果链表2遍历到最后为空，则不相交
    public Node getIntersectionNode(Node headA, Node headB) {
        Node A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }



}
