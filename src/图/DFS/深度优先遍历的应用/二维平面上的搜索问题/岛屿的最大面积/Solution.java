package 图.DFS.深度优先遍历的应用.二维平面上的搜索问题.岛屿的最大面积;

import java.util.ArrayList;

class Solution {

    public int[][] directions;
    public boolean[][] visited;
    public int rows;
    public int cols;
    public int maxArea;
    public int tmpArea;
    public int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        this.rows = grid.length;
        if(this.rows == 0)
        {
            return 0;
        }
        this.cols = grid[0].length;
        this.directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        this.visited = new boolean[this.rows][this.cols];
        this.maxArea = Integer.MIN_VALUE;
        this.grid = grid;
        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                tmpArea = 0;
                dfs(i,j);
                maxArea = Integer.max(tmpArea,maxArea);
            }
        }
        return maxArea;
    }

    public void dfs(int i,int j)
    {
        if(!visited[i][j] && grid[i][j] == 1)
        {
            visited[i][j] = true;
            tmpArea++;
            for(int[] direction : directions)
            {
                int newX = i + direction[0];
                int newY = j + direction[1];
                if(inArea(newX,newY) && !visited[newX][newY])
                {
                    dfs(newX,newY);
                }
            }
        }
    }


    public boolean inArea(int i,int j)
    {

        return i>=0 && i<rows && j>=0 && j<cols;
    }
}