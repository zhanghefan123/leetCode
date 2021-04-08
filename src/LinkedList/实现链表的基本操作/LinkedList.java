package LinkedList.实现链表的基本操作;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LinkedList {
    //可以想象为头结点，也是虚结点，其中不存值
    //其next指针指向链表的第一个结点。
    ListNode dummy;
    public LinkedList()
    {
        dummy = new ListNode(-1);
    }
    //取值
    public int get(int location)
    {
        ListNode cur = dummy.next;
        //我们需要找到location索引指向的结点。
        for(int i =0;i<location;i++)
        {
            cur = cur.next;
        }
        return cur.val;
    }
    //包含
    public boolean contains(int val)
    {
        ListNode cur_node = dummy.next;
        while(cur_node!=null)
        {
            if(cur_node.val == val)
            {
                return true;
            }
            cur_node = cur_node.next;
        }
        return false;//当因为指向了最后指向了空而退出所以为null
    }
    //插入
    public void add(int location,int value)
    {
        ListNode pre = dummy;
        //如果插入到0位置，需要找到前驱结点即-1。
        //如果插入到1位置，则需要找到前驱结点0，以此类推
        for(int i=0;i<location;i++)
        {
            pre = pre.next;
        }
        ListNode node = new ListNode(value);
        node.next = pre.next;
        pre.next = node;
    }
    //删除
    public void remove(int location)
    {
        ListNode pre = dummy;
        for(int i =0;i<location;i++)
        {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}
