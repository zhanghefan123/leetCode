package ARRAY.整数反转;

public class Solution1 {
    public int reverse(int x) {
        int res = 0;
        while(x!=0)
        {
            // 先行取到末尾的数字
            int tmp = x%10;
            // 整型的取值范围[-2147483648,2147483647]
            // 判断当前的res是否大于最大的整数的1/10
            if(res>214748364 || (res == 214748364 && tmp>7))
            {
                return 0;
            }
            // 判断当前的res是否小于最小的整数的1/10
            if(res<-214748364 || (res == -214748364 && tmp<-8))
            {
                return 0;
            }
            res = res * 10 + tmp;
            x/=10;
        }
        return res;
    }
}
