package 跳表.跳表的实现;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    // 跳表的Node
    public static class SkipListNode {
        public Integer value;
        // 如果nextNodes的长度为10，则说明了开了10层
        // nextNodes[0]代表第0层的下一个结点是什么?
        // nextNodes[1]代表第一层的下一个结点是什么?
        public ArrayList<SkipListNode> nextNodes;

        public SkipListNode(Integer value) {
            this.value = value;
            nextNodes = new ArrayList<>();
        }
    }

    public static class SkipListIterator implements Iterator<Integer> {
        SkipList list;
        SkipListNode current;

        public SkipListIterator(SkipList list) {
            this.list = list;
            this.current = list.getHead();
        }

        public boolean hasNext() {
            return current.nextNodes.get(0) != null;
        }

        public Integer next() {
            current = current.nextNodes.get(0);
            return current.value;
        }
    }

    public static class SkipList {
        // 整个结构之中前面最小的一条链
        private SkipListNode head;
        // 我所有数据的抛出的最大层
        private int maxLevel;
        private int size;
        // 以什么样的概率出0,以1-什么样的概率出1
        private static final double PROBABILITY = 0.5;

        public SkipList() {
            size = 0;
            maxLevel = 0;
            // 这里null代表无穷小
            head = new SkipListNode(null);
            // nextNodes[0]是弃而不用的，永远都是指向null
            // nextNodes[1]指向的是value=xxx的这一列的第一层的下一个结点。
            head.nextNodes.add(null);
        }

        public SkipListNode getHead() {
            return head;
        }

        public void add(Integer newValue) {
            if (!contains(newValue)) {
                size++;
                int level = 0;
                // 跑骰子，扔出层数
                while (Math.random() < PROBABILITY) {
                    level++;
                }
                // 如果当前抛出的level大于最大的level
                // 我们的头链表一定要增加高度。
                while (level > maxLevel) {
                    head.nextNodes.add(null);
                    // 更新最大值
                    maxLevel++;
                }
                // 创建新的要插入结点
                SkipListNode newNode = new SkipListNode(newValue);
                // 总是从头开始进行寻找
                SkipListNode current = head;
                do {
                    // 找到第一个比自己大的数，插在这个数的前面即可。
                    current = findNext(newValue, current, level);
                    // 前插
                    newNode.nextNodes.add(0, current.nextNodes.get(level));
                    // 让current在第level层指向newNode
                    current.nextNodes.set(level, newNode);
                    // 从最高层找到最底层。
                } while (level-- > 0);
            }
        }

        public void delete(Integer deleteValue) {
            if (contains(deleteValue)) {
                SkipListNode deleteNode = find(deleteValue);
                size--;
                int level = maxLevel;
                SkipListNode current = head;
                do {
                    current = findNext(deleteNode.value, current, level);
                    if (deleteNode.nextNodes.size() > level) {
                        current.nextNodes.set(level, deleteNode.nextNodes.get(level));
                    }
                } while (level-- > 0);
            }
        }

        // Returns the skiplist node with greatest value <= e
        private SkipListNode find(Integer e) {
            return find(e, head, maxLevel);
        }

        // Returns the skiplist node with greatest value <= e
        // Starts at node start and level
        private SkipListNode find(Integer e, SkipListNode current, int level) {
            do {
                current = findNext(e, current, level);
            } while (level-- > 0);
            return current;
        }

        // Returns the node at a given level with highest value less than e
        private SkipListNode findNext(Integer e, SkipListNode current, int level) {
            // 找到这一层的下一个结点。
            SkipListNode next = current.nextNodes.get(level);
            // 如果next!=null
            while (next != null) {
                // 将next的值拿出来
                Integer value = next.value;
                // 如果要插入的值小于当前的值
                if (lessThan(e, value)) { // e < value
                    break;
                }
                current = next;
                next = current.nextNodes.get(level);
            }
            return current;
        }

        public int size() {
            return size;
        }

        public boolean contains(Integer value) {
            SkipListNode node = find(value);
            return node != null && node.value != null && equalTo(node.value, value);
        }

        public Iterator<Integer> iterator() {
            return new SkipListIterator(this);
        }

        /******************************************************************************
         * Utility Functions *
         ******************************************************************************/

        private boolean lessThan(Integer a, Integer b) {
            return a.compareTo(b) < 0;
        }

        private boolean equalTo(Integer a, Integer b) {
            return a.compareTo(b) == 0;
        }

    }

    public static void main(String[] args) {

    }
}
