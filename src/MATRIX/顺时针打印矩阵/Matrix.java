package MATRIX.顺时针打印矩阵;

import java.util.List;

public class Matrix {
    public int[] spiralOrder(int[][] matrix) {
        //先行遍历到纵坐标的尽头，然后遍历到横坐标的尽头，然后遍历到纵坐标为0

        String s = new String("hello");
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] return_array = new int[rows*cols];
        int count = 0;
        int row_count = 0;
        int col_count = 0;
        int bottom_row_count = 0;
        int bottom_col_count = 0;

        while(true)
        {
            for(int i = bottom_col_count ; i < cols-col_count ;i++)
            {
                return_array[count] = matrix[row_count][i];
                count++;
                if(count==rows*cols)
                {
                    return return_array;
                }
            }
            row_count++;
            for(int i = row_count ; i < rows-bottom_row_count ;i++)
            {
                return_array[count] = matrix[i][cols-col_count-1];
                count++;
                if(count==rows*cols)
                {
                    return return_array;
                }
            }
            col_count++;
            for(int i = cols-col_count-1; i>=bottom_col_count;i--)
            {
                return_array[count] = matrix[rows-bottom_row_count-1][i];
                count++;
                if(count==rows*cols)
                {
                    return return_array;
                }
            }
            bottom_row_count++;
            for(int i = rows-bottom_row_count-1;i>=row_count;i--)
            {
                return_array[count] = matrix[i][bottom_col_count];
                count++;
                if(count==rows*cols)
                {
                    return return_array;
                }
            }
            bottom_col_count++;
        }

    }
}
