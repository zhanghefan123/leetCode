package 动态规划.坐标型动态规划.轰炸敌人;
//题目:
/*
* 给出一个M*N的网格，每个格子可能是空的，可能存在一个敌人，可能是一堵墙
* 只能在某个空格子之中放上一个炸弹，炸弹会炸死同行同列的敌人，但是不能
* 够穿透墙，问最多能够炸死多少个敌人。
* */

//思路:
//我们先假设炸弹能够放在敌人的头上
/*
* 算法分步：
* 我们先将算法分解为4份，分别是向上能够炸死的敌人的数目，
* 向左能够炸死的敌人数目，向下，和向右。
*
* 向上的最后一步:
* 假设从(i,j)位置处爆炸
* 最后一步就是第(i-1,j)处向上最多炸死的敌人+本处可能炸死的敌人。
* 两种情况--本处存在敌人则up(i,j) = up(i-1,j)+1
*         若本处不存在敌人则up(i,j) = up(i-1,j)
*
* 在上下左右的分别计算之中需要进行计算顺序的把握。
* left(i,j) = left(i-1,j) +或者不+1 所以要从左向右进行计算
* right(i,j) = right(i+1,j) +或者不+1 所以需要从右向左进行计算
* down(i,j) = down(i+1,j) +或者不+1 所以需要从下向上进行计算
*
*
* */
public class BombEnemy {
    public static void main(String[] args) {

    }
    public int maxKilledEnemies(char[][] A){
        // 如果为这些不正常的情况，肯定结果是0
        if(A == null || A.length==0 || A[0].length == 0)
        {
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        // 向上能炸死多少敌人的辅助数组
        int[][] up = new int[m][n];
        // 向下能炸死多少敌人的辅助数组
        int[][] down = new int[m][n];
        // 向左能炸死多少敌人的辅助数组
        int[][] left = new int[m][n];
        // 向右能炸死多少敌人的辅助数组
        int[][] right = new int[m][n];

        // 完成向上和向左的辅助数组的初始化
        for(int i = 0 ; i < m; i++)
        {
            for(int j = 0 ; j < n; j++)
            {
                // 如果是面墙，则直接返回0。
                if(A[i][j] == 'W')
                {
                    up[i][j] = 0;
                    left[i][j] = 0;
                    continue;
                }
                // 如果是空地，则返回上一个
                else if(A[i][j] == '0')
                {
                    if(i > 0)
                    {
                        up[i][j] = up[i-1][j];
                    }
                    else{
                        up[i][j] = 0;
                    }

                    if(j > 0)
                    {
                        left[i][j] = left[i][j-1];
                    }
                    else{
                        left[i][j] = 0;
                    }
                }
                // 只能是敌人
                else
                {
                    if(i > 0)
                    {
                        up[i][j] = up[i-1][j] + 1;
                    }
                    else{
                        up[i][j] = 1;
                    }

                    if(j > 0)
                    {
                        left[i][j] = left[i][j-1] + 1;
                    }
                    else
                    {
                        left[i][j] = 1;
                    }
                }
            }
        }

        for(int i = m-1;i>=0;i--)
        {
            for(int j = n-1;j>=0;j--)
            {
                // 如果是面墙，则直接返回0。
                if(A[i][j] == 'W')
                {
                    down[i][j] = 0;
                    right[i][j] = 0;
                }
                // 如果是空地，则返回上一个
                else if(A[i][j] == '0')
                {
                    if(i<m-1)
                    {
                        down[i][j] = down[i+1][j];
                    }
                    else{
                        down[i][j] = 0;
                    }

                    if(j<n-1)
                    {
                        right[i][j] = right[i][j+1];
                    }
                    else{
                        right[i][j] = 0;
                    }
                }
                // 只能是敌人
                else
                {
                    if(i<m-1)
                    {
                        down[i][j] = down[i+1][j] + 1;
                    }
                    else{
                        down[i][j] = 1;
                    }

                    if(j<n-1)
                    {
                        right[i][j] = right[i][j+1] + 1;
                    }
                    else{
                        right[i][j] = 1;
                    }
                }
            }
        }

        int res = 0;
        for(int i = 0; i < m;i++)
        {
            for(int j = 0;j < n;j++)
            {
                if(A[i][j] == '0')
                {
                    res = Integer.max(res,up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return res;
    }
}
