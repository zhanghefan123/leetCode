package LinkedList.链表中的双指针.环形链表2;
// ListNode的定义
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        //快慢指针
        ListNode fast = head;
        ListNode low  = head;
        //设置循环条件
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low = low.next;
            //相遇
            if(fast==low){
                //设置一个新的指针，从头节点出发，慢指针速度为1，所以可以使用慢指针从相遇点出发
                ListNode newnode = head;
                while(newnode!=low){
                    low = low.next;
                    newnode = newnode.next;
                }
                //在环入口相遇
                return low;
            }
        }
        return null;

    }
}
