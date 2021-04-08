package TREE.N叉树.N叉树的后序遍历;

import java.util.*;

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
    public List<Integer> postorder(Node root) {
        if(root == null)
        {
            return new ArrayList<>();
        }
        Deque<Node> stack = new LinkedList<>();
        Deque<Integer> stack1 = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            Node tmp = stack.pop();
            stack1.push(tmp.val);
            List<Node> children = tmp.children;
            for(int i = 0;i<children.size();i++)
            {
                stack.push(children.get(i));
            }
        }
        return Arrays.asList(stack1.toArray(new Integer[stack1.size()]));
    }
}