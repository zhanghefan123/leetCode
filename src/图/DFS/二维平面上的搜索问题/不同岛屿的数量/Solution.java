package 图.DFS.二维平面上的搜索问题.不同岛屿的数量;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    // 这个set用来记录每一个岛屿
    public HashSet<List<List<Integer>>> set;
    public int[][] directions;
    public int m;
    public int n;
    public int[][] grid;
    public boolean[][] visited;
    public int min_row;
    public int min_col;
    public ArrayList<ArrayList<Integer>> island;



    public int numDistinctIslands(int[][] grid) {
        this.island = new ArrayList<>();
        this.set = new HashSet<>();
        this.directions = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];
        for(int i = 0; i < m;i++)
        {
            for(int j = 0; j< n;j++)
            {
                if(!visited[i][j] && grid[i][j] == 1)
                {
                    min_row = i;
                    min_col = j;
                    dfs(i,j);
                    set.add(new ArrayList<>(island));
                    island.clear();
                }
            }
        }
        return set.size();
    }

    public void dfs(int i,int j)
    {
        if(!visited[i][j])
        {
            visited[i][j] = true;
            ArrayList<Integer> list_tmp = new ArrayList<>();
            list_tmp.add(i-min_row);
            list_tmp.add(j-min_col);
            island.add(list_tmp);
            for(int[] direction : directions)
            {
                int newX = i+direction[0];
                int newY = j+direction[1];
                if(inArea(newX,newY) && grid[newX][newY] == 1)
                {
                    dfs(newX,newY);
                }
            }
        }
    }

    public boolean inArea(int i,int j)
    {
        return i>=0 && j>=0 && i<=m-1 && j<=n-1;
    }
}
