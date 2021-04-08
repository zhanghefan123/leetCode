package LinkedList.双向链表的实现;

class ListNode{
    // 存储结点的值
    public int val;
    // 存储前一个结点
    public ListNode pre;
    // 存储后一个结点
    public ListNode next;
    // 构造函数
    public ListNode(int val)
    {
        this.val = val;
    }
}

class MyLinkedList {
    // 存储双向链表的元素个数
    public int size;
    // 存储双向链表的头部
    public ListNode head;
    // 存储双向链表的尾部
    public ListNode tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        // 创建dummyNode,不存储任何有效的值。
        this.head = new ListNode(-1);
        // 创建dummyNode,不存储任何有效的指。
        this.tail = new ListNode(-1);
        // 让head.next指向tail
        this.head.next = this.tail;
        // 让tail.next指向null
        this.tail.next = null;
        // 让tail.pre指向head
        this.tail.pre = head;
        // 初始化链表的大小为0
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // 如果索引越界，则返回-1
        if(index > (this.size-1) || index < 0)
        {
            return -1;
        }
        return findNode(index).val;
    }

    public ListNode findNode(int index)
    {
        // 让cur指针指向dummyNode
        ListNode cur = this.head;
        // 当索引为0的时候，也需要向下指一轮
        while(index >= 0)
        {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode tmp = new ListNode(val);
        tmp.next = head.next;
        head.next.pre = tmp;
        head.next = tmp;
        tmp.pre = head;
        this.size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode tmp = new ListNode(val);
        tail.pre.next = tmp;
        tmp.pre = tail.pre;
        tmp.next = tail;
        tail.pre = tmp;
        this.size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > this.size || index < 0)
        {
            return;
        }
        ListNode insert = new ListNode(val);
        ListNode cur = findNode(index);
        cur.pre.next = insert;
        insert.pre = cur.pre;
        insert.next = cur;
        cur.pre = insert;
        this.size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index > (this.size-1) || index < 0)
        {
            return;
        }
        ListNode del_prev = findNode(index);
        del_prev.next.pre = del_prev.pre;
        del_prev.pre.next = del_prev.next;
        this.size--;
    }
}
