package 动态规划.动态规划入门.最值类型.找零钱;
//题目 -- 假设我有三种面值的硬币，分别为2元，5元，和7元，每种硬币都足够的多
//买一本书需要27元，问如何用最少的硬币组合正好付清，不需要对方找钱


public class CoinChange {
    public static void main(String[]args){
        int result = func(7);
        System.out.println(result);
    }
    //递归思想
    public static int func(int X){
        /*
        * input-> 即X形式参数:最少用多少枚硬币拼出X
        * */
        if(X == 0) return 0;//如果X == 0，只需要0枚硬币
        int res = Integer.MAX_VALUE; // 假设结果是无穷多枚硬币
        //最后一枚硬币是2块钱,判断条件的含义是，只有总钱数大于等于2最后一枚才可能是2
        if(X >= 2){
            res = Math.min(func(X-2)+1,res);
        }
        //最后一枚硬币是5块钱，判断条件的含义是，只有总钱数大于等于5最后一枚才可能是5
        if(X >= 5){
            res = Math.min(func(X-5)+1,res);
        }
        //最后一枚硬币是7块钱，判断条件的含义是，只有总钱数大于等于7最后一枚才可能是7
        if(X >= 7){
            res = Math.min(func(X-7)+1,res);
        }
        return res;
    }
    //迭代思想 -- 具体思想参考解析.txt
    public static int func2(int[]A, int M) {
        /*
         * A 是可用的硬币列表
         * M 是要凑的值
         */
        int n = A.length; //number of kinds of coins
        int[] f = new int[M + 1]; //我们要求出拼出0块钱，1块钱……27块钱的硬币数目。
        int i, j;
        //分别计算1块钱，2块钱……27块钱的最少硬币数目
        for (i = 1; i <= M; ++i) {
            // 先将待计算的值设置为最大的Int值，之后在进行Math.min的时候就可以计算了。
            f[i] = Integer.MAX_VALUE;
            // 遍历每一种币值
            for (j = 0; j < n; ++j) {
                // i >= A[j]是保证不会出现负数索引。
                if (i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - A[j]] + 1, f[i]);
                }
            }
        }
        if (f[M] == Integer.MAX_VALUE) {
            f[M] = -1;
        }
        return f[M];
    }
}
