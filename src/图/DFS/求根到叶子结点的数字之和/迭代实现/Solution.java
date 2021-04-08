package 图.DFS.求根到叶子结点的数字之和.迭代实现;

import java.util.LinkedList;
import java.util.Queue;

// 思路
/*
使用广度优先搜索需要维护两个队列，分别存储节点和节点对应的数字
初始的时候，将根节点和根节点的值分别加入两个队列，每次从两个队列
分别取出一个节点和一个数字

进行如下操作：
> 1.如果当前节点是叶子节点，则将该节点对应的数字加到数字之和
> 2.如果当前节点不是叶子节点，则获得当前节点的非空子节点，并根据
当前节点对应的数字和子节点的值计算子节点对应的数字，然后将子节点和子节点对应的数字分别加入两个队列。
        */
class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        // 存储节点的队列
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        // 存储节点对应的当前的数值
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            // 将数值队列中的对头元素pop出来
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}
