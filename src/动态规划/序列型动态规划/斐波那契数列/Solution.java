package 动态规划.序列型动态规划.斐波那契数列;

// 滚动数组解法
public class Solution {
    public int fib(int n) {
        int n1 = 0, n2 = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = sum;
        }
        return n1;
    }
}
