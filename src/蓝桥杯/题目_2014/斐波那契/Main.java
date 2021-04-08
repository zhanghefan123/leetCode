package 蓝桥杯.题目_2014.斐波那契;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static BigInteger[][] ONE = {{BigInteger.ONE, BigInteger.ONE},
            {BigInteger.ONE,BigInteger.ZERO}};
    public static BigInteger[][] ZERO = {{BigInteger.ZERO,BigInteger.ZERO},
            {BigInteger.ZERO,BigInteger.ZERO}};
    //求取矩阵ONE的n次方
    public BigInteger[][] getOneOfN(long n) {
        if(n == 0)
            return ZERO;
        if(n == 1)
            return ONE;
        if((n & 1) == 0) {   //当n为偶数时
            // 规模拆分成两个一样的
            BigInteger[][] A = getOneOfN(n >> 1);
            return multiMatrix(A, A);
        }
        //当n为奇数时
        // 先去掉一个
        // 然后规模拆分成两个一样的。
        BigInteger[][] A = getOneOfN(n >> 1);
        return multiMatrix(multiMatrix(A, A), ONE);
    }
    //求取矩阵A*B的值
    public BigInteger[][] multiMatrix(BigInteger[][] A, BigInteger[][] B) {
        BigInteger[][] result = new BigInteger[A.length][B[0].length];
        for(int i = 0;i < A.length;i++)
            for(int j = 0;j < B[0].length;j++)
                result[i][j] = BigInteger.ZERO;
        for(int i = 0;i < A.length;i++)
            for(int j = 0;j < B.length;j++)
                for(int k = 0;k < A[0].length;k++)
                    result[i][j] = result[i][j].add(A[i][k].multiply(B[k][j]));
        return result;
    }
    //获取第n个斐波那契数
    public BigInteger getFibonacci(long n) {
        if(n == 1 || n == 2)
            return BigInteger.ONE;
        BigInteger[][] A  = new BigInteger[1][2];
        A[0][0] = BigInteger.ONE;
        A[0][1] = BigInteger.ONE;
        BigInteger[][] B = getOneOfN(n - 2);
        A = multiMatrix(A, B);
        // 矩阵坐上角的元素就是结果
        return A[0][0];
    }

    public static void main(String[] args) {
        Main test = new Main();
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        BigInteger p = in.nextBigInteger();
        BigInteger result = BigInteger.ZERO;
        if(m>=n+2)
        {
            result = test.getFibonacci(n + 2).subtract(BigInteger.ONE);
            result = result.mod(p);
        }
        else
        {
            result = test.getFibonacci(n + 2).subtract(BigInteger.ONE);
            result = result.mod(test.getFibonacci(m));
            result = result.mod(p);
        }
        System.out.println(result);
    }

}
