package 蓝桥杯.题目_2014.绳圈问题;

public class Solution {

    // 首先创建辅助数组
    public static double [][] helper = new double[101][101];
    public static void main(String[] args)
    {
        helper[1][1] = 1;
        for(int sheng = 2;sheng <= 100;sheng++)
        {
            // 为了保证quan-1有效
            helper[sheng][1] = helper[sheng-1][1] * (sheng-1) * 2 / (2*sheng-1);
            for(int quan = 2; quan<=sheng;quan++)
            {
                helper[sheng][quan] = (helper[sheng-1][quan-1] + helper[sheng-1][quan] * (sheng-1) * 2) / (2*sheng-1);
            }
        }
        double p = -1;
        double ans = -1;
        for(int quan = 1;quan<=100;++quan)
        {
            if(helper[100][quan] > p) {
                p = helper[100][quan];
                ans = quan;
            }
        }
        System.out.println(ans);
    }
}
