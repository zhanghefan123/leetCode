package 数据结构设计题.LRU;
// 题目:
// 设计可以变更的缓存结构(LRU)
/*
设计一种缓存结构，该结构在构造的时候确定大小，假设大小为k，并且有
两个功能：
功能1:set(key,value),将记录(key,value)插入这个结构之中
功能2:get(key),返回key对应的value值
两个要求:
要求1:set和get方法的时间复杂度为O(1)
要求2:某个key的set或者get操作一旦发生，人为这个key的记录成了最
经常使用的。
要求3:当缓存的大小超过K的时候，移除最不经常使用的记录，即set或者get
最久远的
* */

// 举例
/*
假设缓存结构的实例时cache，大小为3，并依次发生如下的行为:
step1:cache.set("A",1),最经常使用的记录为("A",1)
step2:cache.set("B",2),最经常使用的记录为("B",2),("A",1)变为最不经常的
step3:cache.set("C",3),最经常使用的记录为("C",2),("A",1)变为最不经常的
step4:cache.get("A"),醉经长使用的记录为("A",1),("B",2)变为最不经常的
step5:cache.set("D",4),大小超过了3，所以移除此时最不经常使用的记录("B",2)
加入记录("D",4)，并且为最经常使用的记录，然后("C",2)变为最不经常使用的记录
* */

import java.util.HashMap;

// 思路
// 哈希map+双向链表
// 双向链表从尾部到头部依次是最经常到最不经常的
public class Solution {
    // 双向链表的结点
    public static class Node<V> {
        public V value;
        public Node<V> last;
        public Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class NodeDoubleLinkedList<V> {
        // 双向链表的头指针
        private Node<V> head;
        // 双向链表的尾指针
        private Node<V> tail;

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        // 如何添加一个结点
        public void addNode(Node<V> newNode) {
            if (newNode == null) {
                return;
            }
            // 如果我的头结点为空，说明这个结点是第一个进来的结点
            if (this.head == null) {
                // 让头指针和尾指针都指向这个结点
                this.head = newNode;
                this.tail = newNode;
            } else {
                // 如果不是第一个元素，则放在最后
                this.tail.next = newNode;
                newNode.last = this.tail;
                this.tail = newNode;
            }
        }

        // 将访问到的元素移动到链表的尾部
        public void moveNodeToTail(Node<V> node) {
            // 如果尾部等于这个结点直接return
            if (this.tail == node) {
                return;
            }
            // 如果头部等于这个node与其他结点的操作不太一样，
            // 因为这个head没有头结点
            if (this.head == node) {
                this.head = node.next;
                this.head.last = null;
            } else {
                // 删除这个结点并准备将其放到最后
                node.last.next = node.next;
                node.next.last = node.last;
            }
            // 这个结点的前驱指向的是老的尾部
            node.last = this.tail;
            // 这个结点作为最后一个结点next指向null
            node.next = null;
            // 让原来的尾指针指向的结点的next指向这个结点
            this.tail.next = node;
            // 让尾指针进行更新
            this.tail = node;
        }

        // 删除头部的结点
        public Node<V> removeHead() {
            // 如果头部为空，则返回空，什么都没有删除
            if (this.head == null) {
                return null;
            }
            // 先让res指向头结点
            Node<V> res = this.head;
            // 如果头结点 == 尾部的结点
            // 说明只有一个结点
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            }
            // 如果存在多个结点，更改头结点即可。
            else {
                this.head = res.next;
                res.next = null;
                this.head.last = null;
            }
            return res;
        }

    }

    public static class MyCache<K, V> {
        // key到Node的HashMap
        private HashMap<K, Node<V>> keyNodeMap;
        // Node到key的HashMap
        private HashMap<Node<V>, K> nodeKeyMap;
        private NodeDoubleLinkedList<V> nodeList;
        // 内存大小不要超过多少
        private int capacity;

        public MyCache(int capacity) {
            if (capacity < 1) {
                throw new RuntimeException("should be more than 0.");
            }
            this.keyNodeMap = new HashMap<K, Node<V>>();
            this.nodeKeyMap = new HashMap<Node<V>, K>();
            this.nodeList = new NodeDoubleLinkedList<V>();
            this.capacity = capacity;
        }

        public V get(K key) {
            if (this.keyNodeMap.containsKey(key)) {
                Node<V> res = this.keyNodeMap.get(key);
                this.nodeList.moveNodeToTail(res);
                return res.value;
            }
            return null;
        }

        public void set(K key, V value) {
            if (this.keyNodeMap.containsKey(key)) {
                Node<V> node = this.keyNodeMap.get(key);
                node.value = value;
                this.nodeList.moveNodeToTail(node);
            } else {
                Node<V> newNode = new Node<V>(value);
                this.keyNodeMap.put(key, newNode);
                this.nodeKeyMap.put(newNode, key);
                this.nodeList.addNode(newNode);
                if (this.keyNodeMap.size() == this.capacity + 1) {
                    this.removeMostUnusedCache();
                }
            }
        }

        private void removeMostUnusedCache() {
            // 找到头部要移除的最久没有访问过的结点
            Node<V> removeNode = this.nodeList.removeHead();
            // 通过结点找到key
            K removeKey = this.nodeKeyMap.get(removeNode);
            // 通过Node删除NodeKeyMap中的对应键值对
            this.nodeKeyMap.remove(removeNode);
            // 通过key删除keyNodeMap中的对应键值对
            this.keyNodeMap.remove(removeKey);
        }

    }

    public static void main(String[] args) {
        MyCache<String, Integer> testCache = new MyCache<String, Integer>(3);
        testCache.set("A", 1);
        testCache.set("B", 2);
        testCache.set("C", 3);
        System.out.println(testCache.get("B"));
        System.out.println(testCache.get("A"));
        testCache.set("D", 4);
        System.out.println(testCache.get("D"));
        System.out.println(testCache.get("C"));

    }
}
