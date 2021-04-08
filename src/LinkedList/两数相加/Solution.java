package LinkedList.两数相加;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return process(l1,l2,0);
    }
    public ListNode process(ListNode l1, ListNode l2, int carry)
    {
        if(l1 == null && l2 == null)
        {
            if(carry == 1)
            {
                ListNode res = new ListNode(carry,null);
                return res;
            }
            else{
                return null;
            }
        }
        if(l1 == null && l2 != null)
        {
            return process2(l2,carry);
        }
        if(l1 != null && l2 == null)
        {
            return process2(l1,carry);
        }
        if(l1.val + l2.val + carry < 10)
        {
            ListNode newNode = new ListNode(l1.val + l2.val + carry);
            newNode.next = process(l1.next,l2.next,0);
            return newNode;
        }
        else
        {
            ListNode newNode = new ListNode(l1.val + l2.val + carry - 10);
            newNode.next = process(l1.next,l2.next,1);
            return newNode;
        }
    }

    public ListNode process2(ListNode l,int carry)
    {
        if(l == null)
        {
            if(carry == 1)
            {
                ListNode res = new ListNode(carry,null);
                return res;
            }
            else{
                return null;
            }

        }
        else{
            if(l.val +  carry >= 10)
            {
                ListNode newNode = new ListNode(l.val+carry-10);
                newNode.next = process2(l.next,1);
                return newNode;
            }
            else{
                ListNode newNode = new ListNode(l.val + carry);
                newNode.next = process2(l.next,0);
                return newNode;
            }
        }
    }
}
