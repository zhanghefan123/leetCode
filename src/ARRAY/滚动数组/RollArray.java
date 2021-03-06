package ARRAY.滚动数组;
/*
滚动数组是DP中的一种编程思想。简单的理解就是让数组滚动起来，
每次都使用固定的几个存储空间，来达到压缩，节省存储空间的作用。
起到优化空间，主要应用在递推或动态规划中（如01背包问题）。
因为DP题目是一个自底向上的扩展过程，我们常常需要用到的是连续的解，
前面的解往往可以舍去。所以用滚动数组优化是很有效的。利用滚动数组的话
在N很大的情况下可以达到压缩存储的作用。
*/
public class RollArray {
    public static void main()
    {
        int i;
        long[] d =  new long[3];
        d[1]=1;
        d[2]=1;
        for(i=2;i<80;i++)
        {
            d[0]=d[1];
            d[1]=d[2];
            d[2]=d[0]+d[1];
        }
        System.out.println(d[2]);
    }
}
