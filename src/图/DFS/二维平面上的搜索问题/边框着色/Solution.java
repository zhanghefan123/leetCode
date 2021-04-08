package 图.DFS.二维平面上的搜索问题.边框着色;

public class Solution {

    public boolean[][] visited;

    public int[][] res;

    public int[][] former_grid;

    public int m;

    public int n;

    public int color_before;

    public int color_after;

    public int[][] directions;

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        this.res = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];
        this.former_grid = new int[m][n];
        this.directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0;i<m;i++)
        {
            former_grid[i] = grid[i].clone();
        }
        this.color_before = grid[r0][c0];
        this.color_after = color;
        dfs(r0,c0);
        return res;
    }

    // 如果一个连通分量之中的点四周都是连通分量之中的元素，那么这个点就是连通分量中的内点
    // 如果一个连通分量之中的点四周并不是都是连通分量之中的元素，那么这个点就是连通分量之中的边界点


    public void dfs(int i,int j)
    {
        if(!visited[i][j] && former_grid[i][j] == color_before)
        {
            visited[i][j] = true;
            // 如果不是内点则进行修改
            if(!isInsidePoint(i,j))
            {
                res[i][j] = this.color_after;
            }
            for(int [] direction : directions)
            {
                int newX = i + direction[0];
                int newY = j + direction[1];
                if(inArea(newX,newY))
                {
                    dfs(newX,newY);
                }
            }
        }
    }

    public boolean isInsidePoint(int i,int j)
    {
        boolean flag = true;
        for(int[] direction : directions)
        {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if(!inArea(newX,newY) || this.former_grid[newX][newY] != color_before)
            {
                return false;
            }
        }
        return true;
    }

    public boolean inArea(int i,int j)
    {
        return i>=0 && i < m && j >=0 && j<n;
    }
}