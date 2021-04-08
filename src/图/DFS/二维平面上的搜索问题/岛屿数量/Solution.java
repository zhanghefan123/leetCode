package 图.DFS.二维平面上的搜索问题.岛屿数量;

public
class Solution {
    //接收的参数是一个字符的二维数组
    public int numIslands(char[][] grid) {
        int m = grid.length;//获取数组的行数
        if(m == 0)
        {
            return 0;
        }
        int n = grid[0].length;//获取数组的列数
        int count = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == '0')
                {

                }
                else
                {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = '0';
        if(i<m-1 && grid[i+1][j] == '1')
        {
            dfs(grid,i+1,j);
        }
        if(i>0 && grid[i-1][j] == '1')
        {
            dfs(grid,i-1,j);
        }
        if(j<n-1 && grid[i][j+1] == '1')
        {
            dfs(grid,i,j+1);
        }
        if(j>0 && grid[i][j-1] == '1')
        {
            dfs(grid,i,j-1);
        }
    }
}