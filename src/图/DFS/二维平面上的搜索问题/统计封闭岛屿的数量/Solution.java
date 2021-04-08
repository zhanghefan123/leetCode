package 图.DFS.二维平面上的搜索问题.统计封闭岛屿的数量;

public class Solution {

    public int[][] directions;

    public boolean isClosedIsland;

    public int[][] grid;

    public boolean[][] visited;

    public int m;

    public int n;

    public int final_res;

    public Solution(){

    }


    public int closedIsland(int[][] grid) {
        // 如果这个点能够到达边界则说明这个点所在的路地块不是封闭岛屿
        this.directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        this.isClosedIsland = false;
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.final_res = 0;
        this.visited = new boolean[m][n];
        // 遍历所有的结点
        for(int i = 0; i < m;i++)
        {
            for(int j = 0; j<n; j++)
            {
                // 在遍历一个岛屿的时候，首先认为它是封闭岛屿
                if(!visited[i][j] && this.grid[i][j] == 0)
                {
                    if(onBorder(i,j))
                    {
                        this.isClosedIsland = false;
                    }
                    else
                    {
                        this.isClosedIsland = true;
                    }
                    visited[i][j] = true;
                    dfs(i,j);
                    if(this.isClosedIsland)
                    {
                        this.final_res++;
                    }
                }
            }
        }
        return final_res;
    }


    public void dfs(int i, int j)
    {
        // 遍历所有的邻居结点
        for(int[] direction : directions)
        {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if(inArea(newX,newY) && !visited[newX][newY] && this.grid[newX][newY] == 0)
            {
                if(onBorder(newX,newY))
                {
                    this.isClosedIsland = false;
                }
                visited[newX][newY] = true;
                dfs(newX,newY);
            }
        }
    }


    public boolean inArea(int i,int j)
    {
        return i>=0 && i<m && j >=0 && j<n;
    }

    public boolean onBorder(int i,int j)
    {
        return (i == 0) || (i == m-1) || (j == 0) || (j == n-1);
    }
}
