package LinkedList.ReverseLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
        {
            return null;
        }
        ListNode prehead;
        ListNode pre = head;
        ListNode cur = head.next;
        if(cur == null)
        {
            return head;
        }
        while(cur!=null)
        {
            // 先将这个cur结点删除
            pre.next = cur.next;
            // 保存之前的头结点
            prehead = head;
            // 再将这个结点作为头部
            head = cur;
            head.next = prehead;
            cur = pre.next;
        }
        return head;

    }
}
