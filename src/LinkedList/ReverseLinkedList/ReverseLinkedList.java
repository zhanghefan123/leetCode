package LinkedList.ReverseLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        // 指向cur之前的结点
        ListNode pre = null;
        // 在即将改变cur的指向的时候，存储cur
        ListNode next = null;
        // 当前指向的结点
        ListNode cur = head;
        while(cur != null)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
