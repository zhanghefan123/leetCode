package 图.DFS.深度优先遍历的应用.二维平面上的搜索问题.被围绕的区域;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或

    //不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”

    // 算法思路：进行深度优先遍历，发现o走到边界上就停止

    public char[][] board;

    public boolean[][] visited;

    public boolean flag;

    public int rows;

    public int cols;

    public int[][] directions;

    public ArrayList<int[]> path;

    public void solve(char[][] board) {
        this.rows = board.length;
        if(this.rows == 0)
        {
            return;
        }
        this.cols = board[0].length;
        this.visited = new boolean[rows][cols];
        this.board = board;
        this.directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        this.path = new ArrayList<>();
        this.flag = false;

        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                this.flag = false;
                dfs(i,j);
                if(!this.flag)
                {
                    fill();
                }
                this.path.clear();
            }
        }
    }

    public void dfs(int i,int j)
    {
        if(!visited[i][j] && board[i][j] == 'O')
        {
            visited[i][j] = true;

            // 当发现走到边界上的时候，path失效，因为不需要填充
            if(inBound(i,j))
            {
                // flag为true说明这块区域有一个点在边界上。
                this.flag = true;
            }
            this.path.add(new int[]{i,j});
            for(int[] direction : this.directions)
            {
                int newX = i + direction[0];
                int newY = j + direction[1];
                if(inArea(newX,newY)&&!visited[newX][newY])
                {
                    dfs(newX,newY);
                }
            }

        }
    }

    public boolean inBound(int i,int j)
    {
        return i == 0 || i == (this.rows-1) || j == 0 || j == (this.cols-1);
    }

    public boolean inArea(int i, int j)
    {
        return i >= 0 && i < this.rows && j>=0 && j< this.cols;
    }

    public void fill()
    {
        for(int[] position : this.path)
        {
            int x = position[0];
            int y = position[1];
            this.board[x][y] = 'X';
        }

    }
}
