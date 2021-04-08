package LinkedList.链表中的双指针.环形链表;

import java.util.HashSet;

// ListNode的定义
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
// 自己的解法--创建一个HashSet,如果发现结点重复出现的则报警退出。
public class Solution {
    public HashSet<ListNode> set;
    public boolean hasCycle(ListNode head) {
        this.set = new HashSet<>();
        ListNode cur = head;
        while(cur != null)
        {
            // 一旦发现已经存在了就返回true,表示存在环
            if(set.contains(cur))
            {
                return true;
            }
            else
            {
                // 将这个cur放到hashset之中
                set.add(cur);
                cur = cur.next;
            }
        }
        return false;
    }
}

// 题目解法
class SolutionStandard {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
