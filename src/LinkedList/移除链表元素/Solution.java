package LinkedList.移除链表元素;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
        {
            return head;
        }
        // 声明两个指针
        ListNode front = head.next;
        ListNode back = head;
        while(front != null)
        {
            if(front.val == val)
            {
                back.next = front.next;
                front = front.next;
            }
            else
            {
                front = front.next;
                back = back.next;
            }
        }
        if(head.val == val)
        {
            head = head.next;
        }
        return head;
    }
}
