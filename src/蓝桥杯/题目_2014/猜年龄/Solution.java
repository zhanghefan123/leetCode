package 蓝桥杯.题目_2014.猜年龄;
// 猜年龄
/*
小明带两个妹妹参加元宵灯会，别人问她们多大了，她们调皮的说：“我们俩的年龄之积是年龄之和的6倍”
小明又补充说：“他们可不是双胞胎，年龄差肯定也不超过8岁”
请你写出小明的较小的妹妹的年龄
* */
public class Solution {
    public static void main(String[] args) {
        // 使用常识来定边界条件
        for(int i = 1; i < 20;i++) {
            for (int j = 1; j < 20; j++)
            {
                if(i*j == (i+j) * 6 && i < j && Math.abs(i-j) <= 8)
                {
                    System.out.println(i+" "+j);
                }
            }
        }
        // 输出的i和j是10和15
        // 这是一道结果填空题所以返回10即可。
    }
}
