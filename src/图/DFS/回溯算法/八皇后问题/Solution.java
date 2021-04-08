package 图.DFS.回溯算法.八皇后问题;

import java.util.*;

class Solution {
    public int n;
    // 因为遍历每一行所以行上必不会出现两个皇后
    // 列上可能出现两个皇后，所以这里的col就是避免这个情况
    public boolean[] col;
    // 主对角线以及和主对角线平行的线
    public boolean[] main;
    // 副对角线以及和副对角线平型的线
    public boolean[] sub;
    // 结果数组
    public List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n == 0)
        {
            return res;
        }
        this.n = n;
        // 总共存在n列
        col = new boolean[n];
        // 总共存在2n-1条主对角线以及和主对角线平行的线
        main = new boolean[2*n-1];
        // 总共存在2n-1条副对角线以及和副对角线平行的线
        sub = new boolean[2*n-1];
        // 一种摆放方式
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    public void dfs(int row, Deque<Integer> path)
    {
        // 当到达了最后一行，说明已经在[0……n-1]位置放置了n个皇后
        if(row == n)
        {
            // 深度优先遍历到下标为 n，表示 [0.. n - 1] 已经填完，得到了一个结果
            List<String> board = convert2board(path);
            res.add(board);
            return;
        }
        // 遍历每一列
        for(int j = 0;j < n;j++)
        {
            // 没有同列的，同主斜线的，同副斜线的皇后水命这个位置可以放置
            // 由于直接进行row-j,索引会出现负数，所以加上n-1进行平衡
            if(!col[j] && !main[row-j+n-1] && !sub[row+j])
            {
                path.addLast(j);
                col[j] = true;
                main[row-j+n-1] = true;
                sub[row+j] = true;
                dfs(row+1,path);
                // 进行回溯过程,当执行完row+1,row+2,row+n之后，我们需要进行
                // 回溯，从而开启新的可能。
                sub[row+j] = false;
                main[row-j+n-1] = false;
                col[j] = false;
                path.removeLast();
            }
        }
    }

    public List<String> convert2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            // repeat 是 Jdk11之中才有的。
            row.append(repeat(".",Math.max(0, n)));
            row.replace(num, num + 1, "Q"); // 将num索引处的位置替换为"Q"
            board.add(row.toString());
        }
        return board;
    }

    public String repeat(String str,int count)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<count;i++)
        {
            stringBuilder.append(str);
        }
        return new String(stringBuilder);
    }
}