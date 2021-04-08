package 蓝桥杯.题目_2015.垒骰子;

// 垒骰子 -- 动态规划解法

import java.util.HashMap;
import java.util.Scanner;

public class Solution1 {
    // 使用滚动数组 -- 因为本行仅仅取决于上一行的取值
    public long[][] dp = new long[2][7];

    public int n,m;

    public boolean[][] conflict = new boolean[7][7];

    public HashMap<Integer,Integer> op = new HashMap<>();

    public int MOD = 1000000007;

    public Solution1(){
        this.op.put(1,4);
        this.op.put(4,1);
        this.op.put(2,5);
        this.op.put(5,2);
        this.op.put(3,6);
        this.op.put(6,3);

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m;i++)
        {
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            conflict[a][b] = true;
            conflict[b][a] = true;
        }
    }

    public void solve()
    {
        for(int i = 1;i<=6;i++)
        {
            // 第0层，任意面值朝上的方案数都是1，6个面都是被允许的
            dp[0][i] = 1;
        }
        // 过去层是第0层，下次存放的就是第一层。
        int cur = 0;
        // 叠代的层数
        for(int level = 2; level<=n;level++)
        {
            // 滚动数组来回交替
            cur = 1 - cur;
            // 尝试将6个面放在当前一层朝上的方向
            for(int j = 1;j<=6;j++)
            {
                // 先初始化为0
                dp[cur][j] = 0;
                for(int i = 1;i<=6;i++) {
                    // 如果冲突了则循环
                    if (conflict[op.get(j)][i])
                    {
                        continue;
                    }
                    // 如果没有冲突则进行加和，注意1-cur是前一行
                    dp[cur][j] = (dp[cur][j] + dp[1-cur][i]) % MOD;
                }
            }
        }
        long sum = 0;
        for(int k = 1;k<=6;k++)
        {
            sum = (sum + dp[cur][k]) % MOD;
        }

        // 快速幂求4的n次方
        long ans = 1;
        long tmp = 4;
        long p = n;

        // 进行循环
        while(p!=0)
        {
            // 是奇数情况
            if((p & 1) == 1)
            {
                ans = (ans * tmp) % MOD;
            }
            tmp = (tmp * tmp) % MOD;
            p >>= 1;
        }

        System.out.println((sum * ans) % MOD);
    }

    public static void main(String[] args) {

    }


}
