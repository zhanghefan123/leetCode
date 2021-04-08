package Recursion.FeiBoNaQi;
//不使用递归完成斐波那契第n项的值的计算
public class Recursion  {
    public int fib(int n) {
        if(n == 0)
            return 0;
        int[] result = new int[n + 1];
        result[1] = 1;
        for(int i = 2; i <= n; i++)
            result[i] = (result[i - 2] + result[i - 1])%1000000007;
        return result[n];
    }
}
