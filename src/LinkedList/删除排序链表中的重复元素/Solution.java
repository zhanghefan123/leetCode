package LinkedList.删除排序链表中的重复元素;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
        {
            return null;
        }
        // 由于不会删除头结点所以不需要dummyNode
        ListNode pre = head;
        ListNode after = head.next;
        // 如果仅仅存在一个结点的话，那么直接进行返回即可
        if(after == null)
        {
            return head;
        }
        while(after != null)
        {
            // 如果after指针所指向的值等于pre指针所指向的值则让after进行后移的操作
            if(pre.val == after.val)
            {
                after = after.next;
            }
            else
            {
                pre.next = after;
                pre = pre.next;
                after = after.next;
            }
        }
        pre.next = after;
        return head;
    }
}
