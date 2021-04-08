package 动态规划.坐标型动态规划.丑数;

public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        // a用来遍历的是丑数*2的队列
        // b用来遍历的是丑数*3的队列
        // c用来遍历的是丑数*5的队列
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            // 注意这里是if的关系而不是if else的关系，
            // 为的就是应对相同的情况。比如3 * 5 == 5 * 3
            if(dp[i] == n2) {
                a++;
            }
            if(dp[i] == n3) {
                b++;
            }
            if(dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }

}
