package 图.DFS.二维平面上的搜索问题.太平洋大西洋水流问题;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int rows;

    public int cols;

    public int[][] matrix;

    public boolean flag1;

    public boolean flag2;

    public int[][] directions;

    public List<List<Integer>> final_res;

    public boolean[][] visited;


    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        this.rows = matrix.length;
        if(this.rows == 0)
        {
            return new ArrayList<>();
        }
        this.cols = matrix[0].length;
        this.matrix = matrix;
        this.flag1 = false;
        this.flag2 = false;
        this.final_res = new ArrayList<>();
        this.directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < this.rows; i++)
        {
            for(int j = 0; j< this.cols; j++)
            {
                this.flag1 = false;
                this.flag2 = false;
                this.visited = new boolean[this.rows][this.cols];
                dfs(i,j);
                if(this.flag1 && this.flag2)
                {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    this.final_res.add(tmp);
                }

            }
        }
        return final_res;
    }

    public void dfs(int i,int j)
    {
        if(!visited[i][j])
        {
            visited[i][j] = true;
            if(left_top_bound(i,j))
            {
                flag1 = true;
            }
            if(right_bottom_bound(i,j))
            {
                flag2 = true;
            }
            if(flag1 && flag2)
            {
                return;
            }
            else
            {
                for(int[] direction:this.directions)
                {
                    int newX = i + direction[0];
                    int newY = j + direction[1];
                    if(inArea(newX,newY) && !visited[newX][newY]&& matrix[i][j]>=matrix[newX][newY])
                    {
                        dfs(newX,newY);
                    }
                }
            }
        }
    }

    public boolean inArea(int i,int j)
    {
        return i>=0 && i < this.rows && j >= 0 && j < this.cols;
    }

    public boolean left_top_bound(int i,int j)
    {
        return (i == 0) || (j == 0);
    }

    public boolean right_bottom_bound(int i,int j)
    {
        return (i == (this.rows-1)) || (j == (this.cols-1));
    }
}