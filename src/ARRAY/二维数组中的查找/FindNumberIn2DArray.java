package ARRAY.二维数组中的查找;

public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 每一行按照从左到右的顺序进行递增，每一列按照从上到下的顺序进行递增。

        // 所以我们发现一个思路：就是从右上角开始，我们如果向下就是递增，向左就是递减。

        // 解决方案：
        int m = matrix.length;
        if(m == 0)
        {
            return false;
        }
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        while(i>=0 && j>=0 && i<=m-1 && j<=n-1)
        {
            if(matrix[i][j] == target)
            {
                return true;
            }
            else if(matrix[i][j] < target)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return false;
    }
}
