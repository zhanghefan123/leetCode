package 图.DFS.二维平面上的搜索问题.扫雷;

public class Mine {
    //题目:
    /*
    让我们一起来玩扫雷游戏！
    给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
    现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
    如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
    如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
    如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
    如果在此次点击中，若无更多方块可被揭露，则返回面板。
    * */
    String number = new String("12345678");
    public char[][] updateBoard(char[][] board, int[] click) {
        //board是一个二维数组，其中的元素要么是未能挖出的空块E
        //要么是存在的地雷M。click数组的0索引表示的是用户点击位置的
        //行索引，click数组的1索引表示的是用户点击位置的列索引。
        int click_i = click[0];
        int click_j = click[1];
        // 如果点击到了Mine地雷则直接将这个点击到的位置置为'X'并返回
        if(board[click_i][click_j] == 'M')
        {
            board[click_i][click_j] = 'X';
            return board;
        }
        // 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块
        // 或者点击到数字，则直接返回board
        if(board[click_i][click_j] == 'B' || number.contains(Character.toString(board[click_i][click_j])))
        {
            return board;
        }
        // 'E' 代表一个未挖出的空方块
        if(board[click_i][click_j] == 'E')
        {
            reveal(board,click_i,click_j);
        }
        return board;
    }
    // 揭露算法
    public void reveal(char[][]board,int i,int j)
    {
        int m = board.length;
        int n = board[0].length;
        // 如果i,j越界，或者递归的进行揭露的时候发现是M或者B或者是数字那么直接返回，不需要再递归的进行揭露
        if(i<0 || i>m-1 || j <0 || j>n-1||board[i][j]=='M'||board[i][j] == 'B'||number.contains(Character.toString(board[i][j])))
        {
            return;
        }
        // 查找这个被点击的未挖出的空方块，周围有多少颗地雷
        int value = withMinesAround(i,j,board);
        // 如果周围有雷,填充存在多少颗雷之后进行返回
        if(value > 0)
        {
            board[i][j] = Integer.toString(value).charAt(0);
            return;
        }
        // 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露
        if(value == 0)
        {
            board[i][j] = 'B';
            reveal(board,i-1,j);
            reveal(board,i+1,j);
            reveal(board,i,j-1);
            reveal(board,i,j+1);
            reveal(board,i-1,j-1);
            reveal(board,i-1,j+1);
            reveal(board,i+1,j-1);
            reveal(board,i+1,j+1);
        }

    }
    public int withMinesAround(int i ,int j, char[][]board)
    {
        int m = board.length;
        int n = board[0].length;
        int left = 0;
        int right = 0;
        int up = 0 ;
        int down = 0;
        int left_up = 0;
        int right_up = 0;
        int left_down = 0;
        int right_down = 0;
        if(j>0)
        {
            left = board[i][j-1] == 'M'?1:0;
            if(i>0)
            {
                left_up = board[i-1][j-1] == 'M'?1:0;
            }
            if(i<m-1)
            {
                left_down = board[i+1][j-1] == 'M'?1:0;
            }
        }
        if(j<n-1)
        {
            right = board[i][j+1] == 'M'?1:0;
            if(i>0)
            {
                right_up = board[i-1][j+1] == 'M'?1:0;
            }
            if(i<m-1)
            {
                right_down = board[i+1][j+1] == 'M'?1:0;
            }
        }
        if(i>0)
        {
            up = board[i-1][j] == 'M'?1:0;
        }
        if(i<m-1)
        {
            down = board[i+1][j] == 'M'?1:0;
        }
        return left+right+down+up+left_down+left_up+right_down+right_up;
    }
}
