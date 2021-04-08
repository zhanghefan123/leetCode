package TREE.红黑树.红黑树的应用.轮廓线;

import java.util.*;

// 题目
/*
给定一个N行3列的二维数组，每一行表示有一座大楼，一共有N座
大楼，所有大楼的底部都坐落在x轴上，每一行的三个值(a,b,c)
代表每座大楼从(a,0)开始，到(b,0)点结束，高度为c,输入的数据
可以保证a<b,且a,b,c均为正数，大楼之间可以有重合。请输出
整体的轮廓线。

例子:
给定一个二维数组[[1,3,3],[2,4,4],[5,6,1]]
输出轮廓线为[[1,2,3],[2,4,4],[5,6,1]]
* */
public class Solution {
    public static class Node {
        // 是上还是下
        public boolean isUp;
        // 哪个位置
        public int posi;
        // 高度
        public int h;

        public Node(boolean bORe, int position, int height) {
            isUp = bORe;
            posi = position;
            h = height;
        }
    }

    // 构建一个基于位置的比较器，来将Node进行排序的操作
    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.posi != o2.posi) {
                return o1.posi - o2.posi;
            }
            // 相同的位置下，上的排在前面，下的排在后面
            if (o1.isUp != o2.isUp) {
                return o1.isUp ? -1 : 1;
            }
            return 0;
        }
    }

    public static List<List<Integer>> buildingOutline(int[][] buildings) {
        // 原数组中的一个元素将会产生两个信息，两个Node
        Node[] nodes = new Node[buildings.length * 2];
        // 第0号大楼的信息放在0，1位置，第二号大楼的信息放在1，2位置，……以此类推
        for (int i = 0; i < buildings.length; i++) {
            nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
            nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
        }
        // 按照位置将Node列表进行递增排序
        Arrays.sort(nodes, new NodeComparator());
        // 准备一个红黑树，key是高度，value是高度出现的次数
        TreeMap<Integer, Integer> htMap = new TreeMap<>();
        // pmMap存储了每一个位置能够冲到的最大的高度
        TreeMap<Integer, Integer> pmMap = new TreeMap<>();
        for (int i = 0; i < nodes.length; i++) {
            // 如果此时是上
            if (nodes[i].isUp) {
                // 将此时的高度放进去
                if (!htMap.containsKey(nodes[i].h)) {
                    htMap.put(nodes[i].h, 1);
                } else {
                    htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);
                }
            }
            // 如果此时是下
            else {
                if (htMap.containsKey(nodes[i].h)) {
                    // 如果只有1个这样的高度那么直接删除即可。
                    if (htMap.get(nodes[i].h) == 1) {
                        htMap.remove(nodes[i].h);
                    } else {
                        htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
                    }
                }
            }
            // pmMap存储了每一个位置能够冲到的最大的高度
            if (htMap.isEmpty()) {
                pmMap.put(nodes[i].posi, 0);
            } else {
                pmMap.put(nodes[i].posi, htMap.lastKey());
            }
        }
        // 利用pmMap生成轮廓线
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int height = 0;
        // Entry的键是位置，value是位置。
        for (Map.Entry<Integer, Integer> entry : pmMap.entrySet()) {
            // 当前的位置
            int curPosition = entry.getKey();
            // 当前的最大高度
            int curMaxHeight = entry.getValue();
            // 如果之前的高度不等于当前的最大高度，开始产生轮廓线
            if (height != curMaxHeight) {
                if (height != 0) {
                    // 产生轮廓线
                    List<Integer> newRecord = new ArrayList<Integer>();
                    newRecord.add(start);
                    newRecord.add(curPosition);
                    newRecord.add(height);
                    res.add(newRecord);
                }
                start = curPosition;
                height = curMaxHeight;
            }
        }
        return res;
    }
}
