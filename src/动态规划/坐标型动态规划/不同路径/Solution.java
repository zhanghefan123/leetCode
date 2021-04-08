package 动态规划.坐标型动态规划.不同路径;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)
        {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] helper = new int[m][n];
        for(int i = 0;i < m; i++)
        {
            for(int j = 0;j < n;j++){
                if(i ==0 && j == 0)
                {
                    helper[i][j] = 1;
                }
                else if(obstacleGrid[i][j] == 1)
                {
                    helper[i][j] = 0;
                }
                else if(i == 0)
                {
                    helper[i][j] = helper[i][j-1];
                }
                else if(j == 0)
                {
                    helper[i][j] = helper[i-1][j];
                }
                else{
                    helper[i][j] = helper[i-1][j] + helper[i][j-1];
                }
            }
        }
        return helper[m-1][n-1];
    }
}
