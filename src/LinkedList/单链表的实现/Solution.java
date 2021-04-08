package LinkedList.单链表的实现;

public class Solution {

}

class ListNode{
    // 本结点的值
    public int val;
    // 指向下一个结点
    public ListNode next;
    // 构造函数
    public ListNode(int val)
    {
        this.val = val;
        this.next = null;
    }
}
class MyLinkedList {

    public ListNode head;
    public int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        ListNode dummyNode = new ListNode(-1);
        this.head = dummyNode;
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index > (this.size-1))
        {
            return -1;
        }
        ListNode cur = head;
        while(index>=0)
        {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode tmp = new ListNode(val);
        tmp.next = head.next;
        head.next = tmp;
        this.size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode tmp = new ListNode(val);
        ListNode cur = head;
        while(cur.next != null)
        {
            cur = cur.next;
        }
        cur.next = tmp;
        tmp.next = null;
        this.size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > this.size)
        {
            return;
        }
        ListNode cur = head;
        ListNode tmp = new ListNode(val);
        while(index > 0)
        {
            cur = cur.next;
            index--;
        }
        tmp.next = cur.next;
        cur.next = tmp;
        this.size++;

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index > (this.size-1))
        {
            return;
        }
        ListNode cur = head;
        while(index > 0)
        {
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
        this.size--;
    }
}