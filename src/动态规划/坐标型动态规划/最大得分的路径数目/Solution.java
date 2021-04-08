package 动态规划.坐标型动态规划.最大得分的路径数目;

import java.util.List;

public class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int row = board.size();
        if (row == 0) return new int[]{0, 0};
        int modNum = 1000000007;
        int col = board.get(0).length();
        int[][] dpScore = new int[row+1][col+1];
        int[][] dpPath = new int[row+1][col+1];
        //从右下角开始走，初始路径为1条
        dpPath[row-1][col-1] = 1;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                //如果board[i][j] == 'X', 即为障碍
                //如果dpPath[i+1][j],dpPath[i][j+1]和dpPath[i+1][j+1]都等于0，就是路径被障碍'X'封死了
                if (board.get(i).charAt(j) != 'X' &&
                        (dpPath[i + 1][j] != 0 || dpPath[i][j + 1] != 0 || dpPath[i + 1][j + 1] != 0)) {
                    int maxScore = Math.max(Math.max(dpScore[i + 1][j], dpScore[i][j + 1]), dpScore[i + 1][j + 1]);
                    dpScore[i][j] = maxScore + board.get(i).charAt(j) - '0';
                    if (dpScore[i + 1][j] == maxScore) {
                        dpPath[i][j] = (dpPath[i][j] + dpPath[i + 1][j]) % modNum;
                    }
                    if (dpScore[i][j + 1] == maxScore) {
                        dpPath[i][j] = (dpPath[i][j] + dpPath[i][j + 1]) % modNum;
                    }
                    if (dpScore[i + 1][j + 1] == maxScore) {
                        dpPath[i][j] = (dpPath[i][j] + dpPath[i + 1][j + 1]) % modNum;
                    }
                }
            }
        }
        //dpScore[0][0] - ('E' - '0'),是因为结束时候为'E'，上面加了，所以要减去
        int maxScore = dpScore[0][0] == 0 ? 0 : dpScore[0][0] - ('E' - '0');
        return new int[]{maxScore, dpPath[0][0]};
    }
}
