package 图.岛问题;
//题目
/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，
请你计算网格中岛屿的数量。岛屿总是被水包围，并且每
座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。

输入示例：
输入:
[
['1','1','1','1','0'],
['1','1','0','1','0'],
['1','1','0','0','0'],
['0','0','0','0','0']
]

输出：
1
* */
//算法思想
//我们可以将矩阵想象成为一个图，这道题即让我们寻找连通分支的数目

import java.util.*;

public class NumberOfIslands {

    //接收的参数是一个字符的二维数组
    public int numIslands(char[][] grid) {
        int m = grid.length;//获取数组的行数
        if(m==0)
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
