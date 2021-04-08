package 动态规划.序列型动态规划.粉刷房子;
//题目:
/*
有一排N栋房子，每栋房子要漆成3种颜色中的一种--红，蓝，绿
任何两栋相邻的房子不能漆成相同的颜色，第i栋房子染成红色，
蓝色，绿色的花费分别是cost[i][0] cost[i][1] cost[i][2]
cost是一个以颜色为纵坐标，房子序号为横坐标的二维数组
问最少需要花费多少钱油漆这些房子
*/
//算法思想：
/*
状态: f[i][0]代表油漆前i栋房子并且索引i-1号房子是红色最小花费
     第一个索引代表油漆的房子数，第二个索引代表i-1号房屋的颜色
状态转移方程: f[i][0] = min{f[i-1][1] + cost[i-1][0], f[i-1][2]+cost[i-1][0]}
           f[i][1] = min{f[i-1][0] + cost[i-1][1], f[i-1][2]+cost[i-1][1]}
          f[i][2] = min{f[i-1][0] + cost[i-1][2], f[i-1][1]+cost[i-1][2]}
初始状态： f[0][0] = f[0][1] = f[0][2] = 0 因为油漆0栋房子肯定是0

计算顺序：for 从上到下
           for 从左到右

*/


public class PaintHouse {
    public static void main(String[] args) {

    }
    public static int minCost(int[][] c){
        int n = c.length;
        if(n == 0){
            return 0;
        }
        // 前0栋房子到前n栋房子总共n+1种情况，最后一栋房子的颜色有三种。
        int [][] f = new int[n+1][3];
        // 给前0栋房子染色为0
        f[0][0] = f[0][1] = f[0][2] = 0;
        int i,j,k;
        // 从前1栋房子开始
        for(i=1; i<=n; i++)
        {
            //j是第i-1栋房子颜色的选择
            for(j = 0;j<3;j++)
            {
                //k是第i-2栋房子颜色的选择。
                f[i][j] = Integer.MAX_VALUE;
                for(k=0; k<3; k++)
                {
                    // 索引i-1房子不能与索引i-2房子的颜色相同
                    if(j != k){
                        f[i][j] = Math.min(f[i][j],f[i-1][k]+c[i-1][j]);
                    }

                }

            }
        }
        return Math.min(f[n][0],Math.min(f[n][1],f[n][2]));
    }
}
