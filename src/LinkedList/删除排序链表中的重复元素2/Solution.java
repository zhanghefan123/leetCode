package LinkedList.删除排序链表中的重复元素2;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // prev指针所指向的是从dummyNode到prev都是不重复的结点，prev在移动的时候已经保证了不重复
        ListNode prev = dummyHead;
        ListNode cur = prev.next;
        while (cur != null) {
            int curRepeatNum = 0;
            // difNode记录的是第一个不同于cur的结点
            ListNode difNode = cur;
            // 找到和cur指向的结点值不同的结点
            while (difNode != null && difNode.val == cur.val) {
                curRepeatNum++;
                difNode = difNode.next;
            }

            // 如果curRepeatNum的值大于1，则表示cur指向的结点重复出现了
            if (curRepeatNum > 1) {
                prev.next = difNode;
            }else {
                // cur指向的结点没有重复出现，则将变量prev指向cur所指向的结点
                prev = cur;
            }
            cur = difNode;
        }

        return dummyHead.next;
    }
}
