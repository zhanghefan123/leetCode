package 图.BFS.广度优先遍历BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    public int val;
    public TreeNode left,right;
    public TreeNode(int val)
    {
        this.val = val;
        this.left = this.right = null;
    }
}
public class BFS {
    public static void main(String[] args) {

    }
    public static ArrayList<ArrayList<Integer>> bfs(TreeNode root)
    {
        //因为我们需要按层序进行输出所以这里声明一个二维的动态数组
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        //辅助队列
        Queue<TreeNode> queue = new LinkedList<>();

        //当根结点为空的时候直接退出
        if(root == null)
        {
            return results;
        }

        //准备进行BFS
        queue.offer(root);

        //while队列不空，将队头结点出队，并访问，然后将左右子树入队
        while(!queue.isEmpty())
        {
            int size = queue.size();//本层之中的结点个数
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i = 0 ;i<size;i++)
            {
                TreeNode tmp = queue.poll();
                arrayList.add(tmp.val);
                if(tmp.left!=null)
                {
                    queue.offer(tmp.left);
                }
                if(tmp.right!=null)
                {
                    queue.offer(tmp.right);
                }
            }
            results.add(arrayList);
        }
        return results;
    }
}
