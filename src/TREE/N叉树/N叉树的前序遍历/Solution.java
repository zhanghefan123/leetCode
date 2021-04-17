package TREE.N叉树.N叉树的前序遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
        {
            return new ArrayList<>();
        }
        else
        {
            Deque<Node> stack = new LinkedList<>();
            stack.push(root);

            while(!stack.isEmpty())
            {
                Node tmp = stack.pop();
                res.add(tmp.val);
                List<Node> children = tmp.children;
                for(int i=children.size()-1;i>=0;i--)
                {
                    stack.push(children.get(i));
                }
            }
        }
        return res;
    }
}
