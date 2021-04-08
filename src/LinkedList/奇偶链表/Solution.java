package LinkedList.奇偶链表;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        // 从一开始进行为结点编号
        // 偶数索引链表头结点为头结点的下一个结点
        ListNode evenHead = head.next;
        // 奇数索引链表头结点为头结点。
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            // 奇数链表链接下一个位置
            odd.next = even.next;
            // 奇数链表指针前移
            odd = odd.next;
            // 偶数链表指向下一个位置
            even.next = odd.next;
            // 偶数链表指针迁移
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
