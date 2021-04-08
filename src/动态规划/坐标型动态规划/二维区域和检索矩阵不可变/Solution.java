package 动态规划.坐标型动态规划.二维区域和检索矩阵不可变;

public class Solution {
    public int[][] helper;
    public boolean flag;

    public Solution(int[][] matrix) {
        int m = matrix.length;
        this.flag = true;
        if(m != 0)
        {
            int n = matrix[0].length;
            this.helper = new int[m][n];
            for(int i = 0; i < m; i++)
            {
                for(int j = 0;j < n;j++)
                {
                    if(i == 0 && j == 0)
                    {
                        helper[i][j] = matrix[i][j];
                        continue;
                    }
                    else
                    {
                        if(i>0 && j >0)
                        {
                            helper[i][j] = helper[i-1][j] + helper[i][j-1] - helper[i-1][j-1] + matrix[i][j];
                        }
                        else if(i == 0 && j != 0)
                        {
                            helper[i][j] = helper[i][j-1] + matrix[i][j];
                        }
                        else{
                            helper[i][j] = helper[i-1][j] + matrix[i][j];
                        }
                    }
                }
            }
        }
        else{
            flag = false;
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(flag)
        {
            if(row1>0 && col1 > 0)
            {
                return helper[row2][col2] + helper[row1-1][col1-1] - helper[row2][col1-1] - helper[row1-1][col2];
            }
            else if(row1 == 0 && col1 == 0)
            {
                return helper[row2][col2];
            }
            else if(row1 == 0 && col1 != 0)
            {
                return helper[row2][col2] - helper[row2][col1-1];
            }
            else{
                return helper[row2][col2] - helper[row1-1][col2];
            }
        }
        else{
            return -1;
        }


    }
}
