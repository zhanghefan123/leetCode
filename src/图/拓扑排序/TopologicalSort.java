package 图.拓扑排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class DirectedGraphNode {
      // 存储的是这个结点的值
      int label;
      // 存储的是这个结点的邻居
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }

};
//题目：给定一个有向图，我们需要给出这个图的拓扑序列。
public class TopologicalSort {
    //返回的是一个拓扑排序序列
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph)
    {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        //此map存储的是结点对应的入度
        HashMap<DirectedGraphNode,Integer> map = new HashMap<>();
        //遍历所有的结点。
        for(DirectedGraphNode node : graph)
        {   //遍历每个结点的邻居
            for(DirectedGraphNode neighbor : node.neighbors)
            {
                // 当入度表存在这个结点则进行+1的操作
                if(map.containsKey(neighbor))
                {
                    //当入度表之中存在这个结点的时候，将入度进行+1的操作。
                    map.put(neighbor,map.get(neighbor)+1);
                }
                else
                {
                    //当入度表中不存在这个结点的时候，添加新结点并置入度为1
                    map.put(neighbor,1);
                }
            }
        }
        //此处将所有的入度为0的结点进行入队的操作。可能一开始就存在多个度为0的结点。
        Queue<DirectedGraphNode> q = new LinkedList<>();
        for(DirectedGraphNode node : graph)
        {
            //入度表之中不包含这个结点，则这个结点是入度为0的点。
            if(!map.containsKey(node))
            {
                q.offer(node);
                result.add(node);
            }
        }
        //当队列不空的时候继续进行循环，依次出队，在出队的过程中也伴随着入队。
        while(!(q.isEmpty()))
        {
            DirectedGraphNode node = q.poll();
            //将这个入度为0的结点指向的结点的入度-1，就相当于删除这个结点的所有出边
            for(DirectedGraphNode neighbor : node.neighbors)
            {
                map.put(neighbor,map.get(neighbor)-1);
                if(map.get(neighbor) == 0)
                {
                    result.add(neighbor);
                    q.offer(neighbor);
                }
            }
        }
        return result;
    }
}
