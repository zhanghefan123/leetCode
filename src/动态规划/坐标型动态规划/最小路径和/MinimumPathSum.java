package 动态规划.坐标型动态规划.最小路径和;
//题目：
/*
* 给定m行n列的一个网格，每一个网格都是一个非负数
* 求一个左上角(0,0)到右下角(m-1,n-1)的路径，
* 每一步只能向下走一步或者向右走一步，使得路径中
* 格子的数值之和是最少的，返回这个最小值
* */

//思路:
/*
* 1.最后一步:
* 第一种情况 -- 肯定是从(m-2,n-1)到达(m-1,n-1)
* 第二种情况 -- 或者是从(m-1,n-2)到达(m-1,n-1)
* 分析这两种情况
* 若前一步在(m-2,n-1)，则前面一定是从(0,0)到(m-2,n-1)总和最小的路径
* 若前一步在(m-1,n-2)，则前面一定是从(0,0)到(m-1,n-2)总和最小的路径
*
* 2.子问题的寻找
* 到(i,j)的最小路径等价于研究到(i-1,j)和到(i,j-1)的最小路径之和
*
* 3.状态
* f[i][j] 就是从(0,0)走到(i,j)的最小数值总和
*
* 4.状态转移方程
* f[i][j] = min{f[i-1][j],f[i][j-1]}+A[i][j]
*
* 5.初始条件
* f[0][0] = A[0][0]
* */
public class MinimumPathSum {
    public static void main(String[] args) {


    }

    //未进行空间优化的版本
    public static int func(int [][]A){
        /*
        * A中存储的是矩阵形式的各点的数值
        * */
        int m = A.length;//存储A的行数
        int n = A[0].length;//存储A的列数
        int[][] f= new int[m][n];
        int[][] pi = new int[m][n];//想要进行路径的打印需要的数组，pi[i][j]=0代表前驱为上面结点，p[i][j] = 1代表前驱为左侧结点
        int i,j;
        for(i = 0; i< m; i++)
        {
            for(j = 0;j<n;j++)
            {
                if(i == 0 && j==0) {
                    f[i][j] = A[i][j];
                    continue;
                }
                //状态转移方程
                //f[i][j] = min{f[i-1][j],f[i][j-1]}+A[i][j]
                int t = Integer.MAX_VALUE;
                //找出两者的最小值
                //有上侧的就拿上侧来比较
                if(i>0)
                {
                    t = Math.min(t,f[i-1][j]);
                    //代表前驱结点是上面的结点
                    if(t == f[i-1][j])
                    {
                        pi[i][j] = 0;
                    }

                }
                //有左侧的就拿左侧来比较
                if(j>0)
                {
                    t = Math.min(t,f[i][j-1]);
                    //代表前驱结点为左侧的结点
                    if(t == f[i][j-1])
                    {
                        pi[i][j] = 1;
                    }
                }
                //结果需要加上A[I][J]
                f[i][j] = t+A[i][j];
            }
        }
        //将路径进行打印的方式
        int[] path = new int[m+n-1];//总共存储m+n-1个结点，边总共是m+n-2条
        int length = m+n-1;
        //当前所在结点的x--行索引,y--列索引
        int x = m-1;
        int y = n-1;
        //遍历生成path的所有节点
        for(int p = 0;p<length;p++)
        {
            path[p] = A[x][y];
            //前驱结点在上侧
            if(pi[x][y] == 0)
            {
                x--;
            }
            //前驱结点在左侧
            if(pi[x][y] == 1)
            {
                y--;
            }
        }
        //将得出的路径进行打印 -- 注意需要从后往前进行打印
        for(int p = length-1;p>=0;p--)
        {
            System.out.println(path[p]);
        }
        return f[m-1][n-1];
    }

    //进行空间优化
    //原因：在我们计算索引为i行元素的时候，我们仅仅用到的是索引为i行和索引为i-1行的
    //实现想法：我们只开两行的数组，当我们计算到第三行的时候我们删除掉第一行的数组。
    //    //实际想法：
    /*
    使用滚动数组，计算f[0][0] --- f[0][n-1]的时候我们可以正常填写
    计算f[1][0] --- f[1][n-1]的时候我们可以正常填写
    计算f[2][0] --- f[2][n-1]的时候我们将数值写在f[0][0] --- f[0][n-1]位置上
    以此类推
    * */

    //滚动数组版本
    public static int func2(int [][]A){
        /*
         * A中存储的是矩阵形式的各点的数值
         * */
        int m = A.length;//存储A的行数
        int n = A[0].length;//存储A的列数
        //我们仅仅需要开两行，然后这个数组就是我们的滚动数组
        int[][] f= new int[2][n];
        //然后我们需要将值先存储在0行再存储再1行，反复如此
        int i,j;
        int current_row = 0;
        int old_row = 0;
        for(i = 0; i< m; i++)
        {
            current_row = i%2; //where is row i stored:now
            old_row = 1-current_row; // where was row i-1 stored;
            /*
            * 当i = 0的时候存储在0行，此时的current_row == 0,old_row = 1-current = 1 --> 当前计算行为0行
            * 当i = 1的时候存储在1行，此时的current_row == 1,old_row = 1-current = 0 --> 当前计算行为1行，上一行存在0行
            * 当i = 2的时候存储在0行，此时的current_row == 0,old_row = 1-current = 1 --> 当前计算行为2行，上一行存在1行
            * */
            for(j = 0;j<n;j++)
            {
                if(i == 0 && j==0) {
                    f[current_row][j] = A[i][j];
                    continue;
                }

                //状态转移方程
                //f[i][j] = min{f[i-1][j],f[i][j-1]}+A[i][j]
                int t = Integer.MAX_VALUE;
                //找出两者的最小值
                //有左侧的就将左侧的拿来进行比较
                if(i>0)
                {
                    t= Math.min(t,f[old_row][j]);
                }
                //有上侧的就拿上侧的拿来进行比较
                if(j>0)
                {
                    t= Math.min(t,f[current_row][j-1]);
                }
                //结果需要加上A[I][J]
                f[current_row][j] = t+A[i][j];
            }
        }
        return f[current_row][n-1];
    }
}
