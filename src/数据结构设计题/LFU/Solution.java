package 数据结构设计题.LFU;
// 题目
/*
LFU内存替换算法:是根据频率来确定优先级的。
* */

// 举例
/*
假设一块内存之中只允许三个元素的存在，
此时已经存在了三个元素，下一个元素进来的时候就
必须要出去一个元素，这个时候应该出去使用频率最低的元素。
当使用频率一致的时候，我们让最不经常访问的元素出去。
* */

import java.util.HashMap;

// 算法思路
/*
定义一个双向链表，双向链表中存储的元是出现的次数
每一个元素又是另一个双向链表的指针，这个双向链表
存储的是出现频率为这个指针的元素
* */
public class Solution {


    public static class Node {
        // 存储的key
        public Integer key;
        // 存储的value
        public Integer value;
        // 出现的次数
        public Integer times;
        // 前驱
        public Node up;
        // 后继
        public Node down;

        public Node(int key, int value, int times) {
            this.key = key;
            this.value = value;
            this.times = times;
        }
    }

    public static class LFUCache {

        // 整个链表是由一个个的NodeList串联而来的
        // NodeList之中含有一个个的Node
        public static class NodeList {
            // 头
            public Node head;
            // 尾
            public Node tail;
            // 整个大链表中这个ListNode的前驱
            public NodeList last;
            // 整个大链表中这个ListNode的后继
            public NodeList next;

            public NodeList(Node node) {
                head = node;
                tail = node;
            }

            // 添加新的头结点，维护一个从头到尾从最常访问到最不经常访问的链表
            // 老的头结点变成新的头结点的下一个
            public void addNodeFromHead(Node newHead) {
                newHead.down = head;
                head.up = newHead;
                head = newHead;
            }

            public boolean isEmpty() {
                return head == null;
            }

            // 删除任意一个结点
            public void deleteNode(Node node) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    // 如果删除的是头结点
                    if (node == head) {
                        head = node.down;
                        head.up = null;
                    // 如果删除的是尾部的结点
                    } else if (node == tail) {
                        tail = node.up;
                        tail.down = null;
                    // 如果删除的既不是头部也不是尾部
                    } else {
                        node.up.down = node.down;
                        node.down.up = node.up;
                    }
                }
                // 彻底断开被删除结点与NodeList的连接
                node.up = null;
                node.down = null;
            }
        }
        // 总的容量，最多放多少
        private int capacity;
        // 现在放了多少个
        private int size;
        // key对应的Node
        private HashMap<Integer, Node> records;
        // Node对NodeList,即这个Node到底来自于那个NodeList
        private HashMap<Node, NodeList> heads;
        // 这个是整体的结构，NodeList的集合。
        private NodeList headList;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.records = new HashMap<>();
            this.heads = new HashMap<>();
            // 第一个大链表，这个大链表代表出现次数最少的记录集合
            headList = null;
        }

        public void set(int key, int value) {
            // 如果存在这个key
            if (records.containsKey(key)) {
                // 拿到Node
                Node node = records.get(key);
                node.value = value;
                // 出现的次数++
                node.times++;
                // 找到这个Node属于哪个大链表
                NodeList curNodeList = heads.get(node);
                // 因为次数++了所以要换大链表了
                move(node, curNodeList);
            // 如果不存在这个key
            } else {
                // 如果size已经到了阈值，所以需要删除一个才能加入他
                if (size == capacity) {
                    // 第一个大链表的最尾部结点就是要删除的结点
                    Node node = headList.tail;
                    headList.deleteNode(node);
                    // 如果删空了，那么需要将整个NodeList删掉。
                    // 并且更改headList
                    modifyHeadList(headList);
                    records.remove(node.key);
                    heads.remove(node);
                    size--;
                }
                // 创建新的结点
                Node node = new Node(key, value, 1);
                // 如果整个大结构为空
                // 创建一个NodeList并放入node.
                if (headList == null) {
                    headList = new NodeList(node);
                } else {
                    // 如果有1词频的ListNode，放在头部
                    if (headList.head.times.equals(node.times)) {
                        headList.addNodeFromHead(node);
                    // 否则创建一个1词频的ListNode，并将Node放进去。
                    } else {
                        NodeList newList = new NodeList(node);
                        newList.next = headList;
                        headList.last = newList;
                        headList = newList;
                    }
                }
                // 添加记录在records之中
                records.put(key, node);
                // 添加记录在heads之中
                heads.put(node, headList);
                size++;
            }
        }

        // 当一个结点的出现的次数++，他需要移动到新的NodeList上
        private void move(Node node, NodeList oldNodeList) {
            oldNodeList.deleteNode(node);
            NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last
                    : oldNodeList;
            NodeList nextList = oldNodeList.next;
            if (nextList == null) {
                NodeList newList = new NodeList(node);
                if (preList != null) {
                    preList.next = newList;
                }
                newList.last = preList;
                if (headList == null) {
                    headList = newList;
                }
                heads.put(node, newList);
            } else {
                if (nextList.head.times.equals(node.times)) {
                    nextList.addNodeFromHead(node);
                    heads.put(node, nextList);
                } else {
                    NodeList newList = new NodeList(node);
                    if (preList != null) {
                        preList.next = newList;
                    }
                    newList.last = preList;
                    newList.next = nextList;
                    nextList.last = newList;
                    if (headList == nextList) {
                        headList = newList;
                    }
                    heads.put(node, newList);
                }
            }
        }

        // return whether delete this head
        // 牵涉到大的结构换头的操作
        private boolean modifyHeadList(NodeList nodeList) {
            if (nodeList.isEmpty()) {
                if (headList == nodeList) {
                    headList = nodeList.next;
                    if (headList != null) {
                        headList.last = null;
                    }
                } else {
                    nodeList.last.next = nodeList.next;
                    if (nodeList.next != null) {
                        nodeList.next.last = nodeList.last;
                    }
                }
                return true;
            }
            return false;
        }

        public int get(int key) {
            if (!records.containsKey(key)) {
                return -1;
            }
            Node node = records.get(key);
            node.times++;
            NodeList curNodeList = heads.get(node);
            move(node, curNodeList);
            return node.value;
        }
    }
}
