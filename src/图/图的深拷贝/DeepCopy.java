package 图.图的深拷贝;

//题目：
/*
*
* 克隆一张无向图. 无向图的每个节点包含一个 label 和一个列表 neighbors.
* 保证每个节点的 label 互不相同.你的程序需要返回一个经过深度拷贝的新图.
* 新图和原图具有同样的结构, 并且对新图的任何改动不会对原图造成任何影响.
* */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//图的结点定义
class Node{
    int val; //存放结点的编号
    ArrayList<Node> neighbors;//存放结点的邻居
    public Node(int x, List neighbors)
    {
        val = x;
        neighbors = neighbors;
    }
}
class DeepCopy {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        HashMap<Node, Node> visited = new HashMap<>();

        // 将题目给定的节点添加到队列
        LinkedList<Node> queue = new LinkedList<Node> ();
        queue.add(node);
        // 克隆第一个节点并存储到哈希表中
        visited.put(node, new Node(node.val, new ArrayList<>()));

        // 广度优先搜索
        while (!queue.isEmpty()) {
            // 取出队列的头节点
            Node n = queue.remove();
            // 遍历该节点的邻居
            for (Node neighbor: n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // 如果没有被访问过，就克隆并存储在哈希表中
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    // 将邻居节点加入队列中
                    queue.add(neighbor);
                }
                // 更新当前节点的邻居列表
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}

