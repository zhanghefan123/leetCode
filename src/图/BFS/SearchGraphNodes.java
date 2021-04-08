package 图.BFS;

import java.util.*;

//题目:
/*
*
Description
Given a undirected graph, a node and a target,
* --- 函数的参数为一个结点代表的图，一个源点，一个目标值
return the nearest node to given node which value of it is target,
return NULL if you can't find.
* --- 目标是找到离源点最近的，具有目标值的结点并进行返回。
There is a mapping store the nodes' values in the given parameters.
已知条件是--给了一个结点和结点对应的值之间的映射关系
* */
class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
          label = x; neighbors = new ArrayList<UndirectedGraphNode>();
      }
  };
public class SearchGraphNodes {
    public static void main(String[] args) {

    }
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here

        if (node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);

        HashSet<UndirectedGraphNode> hash = new HashSet<>();
        hash.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode currNode = queue.poll();
                if (values.get(currNode) == target) {
                    return currNode;//BFS中先找到的一定是最优的，找到后立即返回
                }
                else {
                    for (UndirectedGraphNode nei : currNode.neighbors) {
                        if (!hash.contains(nei)) {
                            queue.offer(nei);
                            hash.add(nei);
                        }
                    }
                }
            }
        }

        return null;
    }
}
