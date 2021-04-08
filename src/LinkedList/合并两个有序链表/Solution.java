package LinkedList.合并两个有序链表;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        ListNode l1_pointer = l1;
        ListNode l2_pointer = l2;
        while(l1_pointer != null && l2_pointer != null)
        {
            if(l1_pointer.val <= l2_pointer.val)
            {
                dummyNode.next = l1_pointer;
                dummyNode = dummyNode.next;
                l1_pointer = l1_pointer.next;
            }
            else
            {
                dummyNode.next = l2_pointer;
                dummyNode = dummyNode.next;
                l2_pointer = l2_pointer.next;
            }
        }
        if(l1_pointer != null)
        {
            dummyNode.next = l1_pointer;
        }
        if(l2_pointer != null)
        {
            dummyNode.next = l2_pointer;
        }
        return res.next;
    }
}
