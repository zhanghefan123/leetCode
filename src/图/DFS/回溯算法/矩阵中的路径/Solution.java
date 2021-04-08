package 图.DFS.回溯算法.矩阵中的路径;

public class Solution {
    public int[][] directions;
    public char[] charArray;
    public int m;
    public int n;
    public char[][] board;

    public boolean exist(char[][] board, String word) {
        // 上下左右四个方向进行好初始化的工作
        this.directions = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        // 将字符串转换为字符数组
        this.charArray = word.toCharArray();
        // 初始化长度
        this.m = board.length;
        // 初始化宽度
        this.n = board[0].length;
        // 重新保存一遍board
        this.board = board;

        // 进行初始搜索点的遍历
        for(int i = 0; i < m;i++)
        {
            for(int j = 0;j< n;j++)
            {
                if(board[i][j] == charArray[0])
                {
                    boolean[][] visited = new boolean[m][n];
                    if(dfs(i,j,0,visited))
                    {
                        return true;
                    }
                    else
                    {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int i,int j,int current_index,boolean[][]visited)
    {
        if(current_index == charArray.length-1)
        {
            return true;
        }
        visited[i][j] = true;
        int newX;
        int newY;
        for(int[] direction : directions)
        {
            newX = i + direction[0];
            newY = j + direction[1];
            if(inArea(newX,newY)&&!visited[newX][newY]&&charArray[current_index+1] == board[newX][newY])
            {

                if(dfs(newX,newY,current_index+1,visited))
                {
                    return true;
                }
                // 注意当不成功的时候需要进行回溯操作
                else{
                    visited[newX][newY] = false;
                }

            }
        }
        return false;
    }

    public boolean inArea(int i,int j)
    {
        return i>=0 && j>=0 && i<=m-1 && j<=n-1;
    }
}
