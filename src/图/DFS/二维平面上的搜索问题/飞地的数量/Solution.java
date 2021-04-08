package 图.DFS.二维平面上的搜索问题.飞地的数量;

public class Solution {

    // 方向
    public int[][] directions;

    // 行数
    public int m;

    // 列数
    public int n;

    // 图表的拷贝
    public int[][] grid;

    // 是否访问过
    public boolean[][] visited;

    // 在进行洪泛的时候记录一块连续飞地的块数
    public int tmp_res;

    // 最终结果
    public int final_res;

    // 标记是否是一块连续的飞地
    public boolean isFly;

    public int numEnclaves(int[][] grid) {

        // 方向：上下左右
        this.directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        // 行数
        this.m = grid.length;
        // 列数
        this.n = grid[0].length;
        // 布尔数组的初始化
        this.visited = new boolean[m][n];
        // 其他初始化
        this.final_res = 0;
        this.grid = grid;


        // 遍历所有的洪泛点，开始进行洪泛
        for(int i = 0; i < m;i++)
        {
            for(int j = 0; j < n;j++)
            {
                if(!visited[i][j] && grid[i][j] == 1)
                {

                    this.tmp_res = 1;
                    if(onBorder(i,j))
                    {

                        this.isFly = false;
                    }
                    else
                    {
                        this.isFly = true;
                    }
                    visited[i][j] = true;
                    dfs(i,j);
                    if(this.isFly)
                    {
                        final_res += this.tmp_res;
                    }
                }
            }
        }
        return final_res;
    }

    public void dfs(int i,int j)
    {
        // 遍历所有的方向
        for(int[] direction : this.directions)
        {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if(inArea(newX,newY) && !visited[newX][newY] && grid[newX][newY] == 1)
            {
                visited[newX][newY] = true;
                this.tmp_res++;
                if(onBorder(newX,newY))
                {
                    this.isFly = false;
                }
                dfs(newX,newY);
            }
        }
    }


    public boolean onBorder(int i,int j)
    {
        return i == 0 || i == m-1 || j == 0 || j==n-1;
    }

    public boolean inArea(int i,int j)
    {
        return i>=0 && i < m && j>=0 && j < n;
    }
}
