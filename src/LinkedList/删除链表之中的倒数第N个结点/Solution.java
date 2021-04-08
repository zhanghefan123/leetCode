package LinkedList.删除链表之中的倒数第N个结点;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode front = head;
        ListNode back = head;
        // 若要删除倒数第二个结点，则两个指针需要距离三个单位
        int distance = n+1;
        while(distance>0)
        {
            // 说明删不掉。
            if(front == null)
            {
                return head.next;
            }
            front = front.next;
            distance--;
        }
        while(front!=null)
        {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return head;
    }
}
