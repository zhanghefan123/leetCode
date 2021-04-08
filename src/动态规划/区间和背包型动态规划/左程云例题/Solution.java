package 动态规划.区间和背包型动态规划.左程云例题;
// 题目:
/*
给定参数N，给定参数M，给定参数p,给定参数k
机器人的初始位置位于M位置，总共有[1,N]位置可以供机器人走
若机器人走到了1位置那么只能向右走，如果机器人走到了N位置难么只能向左走
否则机器人既可以向左走，也可以向右走，请问机器人走p步之后停留在k位置的情况有多少种?
*/
public class Solution {
    // N 一共有1~N的位置可以走
    // M 来到的位置
    // P 还可以走的步数
    // K 最终停留的位置
    public static int ways(int N,int M,int P,int K)
    {
        if(N < 2 || M < 1 || M > N || P < 0 || K < 1 || K > N)
        {
            return 0;
        }
        if(P == 0)
        {
            return M == K ? 1 : 0;
        }
        int res = 0;
        // 只能向右走
        if(M == 1)
        {
            res = ways(N,M+1,P-1,K);
        }
        // 只能向左走
        else if(M == N)
        {
            res = ways(N,M-1,P-1,K);
        }
        // 可以向左也可以向右走
        else
        {
            res = ways(N,M+1,P-1,K) + ways(N,M-1,P-1,K);
        }
        return res;
    }

    // 暴力递归改动态规划
    // 以P为纵轴，M为横轴即可。
}
