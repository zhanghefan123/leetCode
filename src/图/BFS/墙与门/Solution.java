package 图.BFS.墙与门;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    public int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int INF = 2147483647;

    public int rows;

    public int cols;

    public HashSet<int[]> set;

    public int[][] rooms;


    public void wallsAndGates(int[][] rooms) {
        // 矩阵长度
        this.rows = rooms.length;
        if(this.rows == 0)
        {
            return;
        }
        this.cols = rooms[0].length;
        this.rooms = rooms;
        // 找到空房间之后开始广度优先遍历。
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j< cols;j++)
            {
                // 如果发现是空房子，则开始广度优先遍历
                bfs(i,j);
            }
        }

    }
    public void bfs(int i, int j)
    {
        // 如果发现是门或者是墙则什么也不做。
        if(this.rooms[i][j] != this.INF)
        {
            return;
        }
        // 防止兜圈子
        boolean [][] visited = new boolean[this.rows][this.cols];

        // 辅助队列
        Deque<int[]> queue = new LinkedList<>();
        // 前两个元素是索引，最后一个元素是走的步数
        queue.offerLast(new int[]{i,j,0});
        while(!queue.isEmpty())
        {
            int[] position_and_level = queue.pollFirst();

            int x = position_and_level[0];

            int y = position_and_level[1];

            int level = position_and_level[2];

            // 如果发现是门就直接退出
            if(this.rooms[x][y] == 0)
            {
                this.rooms[i][j] = level;
                break;
            }
            else
            {
                visited[x][y] = true;
            }

            for(int[] direction : directions)
            {
                int newX = x + direction[0];
                int newY = y + direction[1];
                // 当在区域内且不是墙就可以走。
                if(inArea(newX,newY) && (this.rooms[newX][newY] !=-1) && (!visited[newX][newY]))
                {
                    queue.offerLast(new int[]{newX,newY,level+1});
                }
            }
        }


    }

    public boolean inArea(int i,int j)
    {
        return i >= 0 && i < rows && j >=0 && j < cols;
    }
}
