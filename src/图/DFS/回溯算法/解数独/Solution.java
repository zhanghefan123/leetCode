package 图.DFS.回溯算法.解数独;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {

    // 每一行都有一个HashSet
    public ArrayList<HashSet<Character>> row;

    // 每一列都有一个HashSet
    public ArrayList<HashSet<Character>> col;

    // 每一个3*3matrix都有一个HashSet
    public ArrayList<ArrayList<HashSet<Character>>> matrix;

    // 可以填充的点的坐标
    public ArrayList<int[]> positions;

    // 存储结果
    public char[][] final_res;

    // 当前正在查看哪个位置
    public int current_position;

    public void solveSudoku(char[][] board) {
        // 进行row和col的初始化
        this.row = new ArrayList<>();
        this.col = new ArrayList<>();
        // 进行matrix的初始化
        this.matrix = new ArrayList<>();

        // 初始设置为第一个可填写的空白位置
        this.current_position = 0;
        // 进行HasSet的初始化
        for(int i = 0; i < 9; i++)
        {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
        }
        // 进行Matrix的初始化
        for(int i = 0; i < 3; i++)
        {
            matrix.add(new ArrayList<>());
            for(int j = 0;j < 3;j++)
            {
                matrix.get(i).add(new HashSet<>());
            }
        }
        // 找到可以填充的点的坐标，并且初始化HashSet
        this.positions = new ArrayList<>();
        for(int i = 0;i < 9;i++)
        {
            for(int j = 0;j < 9;j++)
            {
                // 如果是空位
                if(board[i][j] == '.')
                {
                    this.positions.add(new int[]{i,j});
                }
                // 如果是数字
                else
                {
                    // 行进行添加
                    this.row.get(i).add(board[i][j]);
                    // 列进行添加
                    this.col.get(j).add(board[i][j]);
                    // matrix进行添加
                    this.matrix.get(i/3).get(j/3).add(board[i][j]);
                }
            }
        }
        // 进行回溯
        backTrace(board);
    }

    public boolean backTrace(char[][] board)
    {
        if(current_position == this.positions.size())
        {
            return true;
        }
        for(char i = '1';i<='9';i++)
        {
            int[] cur = this.positions.get(current_position);
            int x = cur[0];
            int y = cur[1];
            if(!row.get(x).contains(i) && !col.get(y).contains(i) && !(matrix.get(x/3).get(y/3).contains(i)))
            {
                row.get(x).add(i);
                col.get(y).add(i);
                matrix.get(x/3).get(y/3).add(i);
                board[x][y] = i;
                this.current_position++;
                if(backTrace(board))
                {
                    return true;
                }
                else{
                    row.get(x).remove(i);
                    col.get(y).remove(i);
                    matrix.get(x/3).get(y/3).remove(i);
                    this.current_position--;
                    board[x][y] = '.';
                }
            }
        }
        return false;
    }
}