package 图.DFS.二维平面上的搜索问题.单词搜索;

public class Solution {
    // 判断是否访问过了。
    public boolean[][] visited;
    // 方向，上下左右，第一个坐标为行的相对移动，第二个坐标为列的相对移动
    public int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}};
    // 行
    public int rows;
    // 列
    public int cols;
    // 单词长度
    public int len;
    // 单词的char array形式
    public char[] charArray;
    // 单词版
    public char[][] board;

    // 这个方法是用来判断board之中能否找到word
    public boolean exist(char[][] board, String word)
    {
        this.len = word.length();
        this.rows = board.length;
        if(rows==0)
        {
            return false;
        }
        this.cols = board[0].length;
        visited = new boolean[rows][cols];
        this.charArray = word.toCharArray();
        this.board = board;
        for(int i = 0;i < this.rows;i++)
        {
            for(int j = 0;j < this.cols;j++)
            {
                if(dfs(i,j,0))
                {
                    return true;
                }
            }
        }
        return false;
    }

    // 传入的是起始位置,begin是开始匹配字符串的位置。
    public boolean dfs(int i,int j,int begin)
    {
        if(begin == len-1)
        {
            return board[i][j] == charArray[begin];
        }
        if(board[i][j] == charArray[begin])
        {
            visited[i][j] = true;
            for(int[] direction : directions)
            {
                int newX = i + direction[0];
                int newY = j + direction[1];
                if(inArea(newX,newY) && !visited[newX][newY])
                {
                    if(dfs(newX,newY,begin+1))
                    {
                        return true;
                    }
                }
            }
            // 如果每个方向都行不通，最终会落到这一步
            visited[i][j] = false;
        }
        return false;
    }

    // 判断是否在区域之中
    public boolean inArea(int x,int y)
    {
        return x>=0 && x < rows && y>=0 && y<cols;
    }
}