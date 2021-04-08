package 动态规划.位操作型动态规划.比特位计数;
//题目:
//求一个数的二进制表示法之中1的数目
public class BinaryCount {
    public static void main(String[] args) {

    }

    //算法思想：
    /*
    * 最后一步:
    * 假设前面高n-1位，存在x个1，那么分两种情况
    * > 若第n位是1，则总数为x+1
    * > 若第n为是0，则总数为x
    *
    * 状态f[i]表示值为i的数包含的1的个数
    *
    * f[i] = f[i>>1] + i mod 2
    * 分析值为i对应的二进制包含的1的个数，等于右移1位所包含的1的个数+原来的最后一位
    *
    * 初始条件：
    * f[0] = 0;
    *
    * */
    public static int[] func(int num)
    {
        int[] f = new int[num+1];
        int i;
        f[0] = 0; // 初始条件
        for(i = 1;i<=num;i++)
        {
            f[i] = f[i>>1] + (i % 2);//此处的i%2也可以替换成为i&1
        }
        return f;
    }
}
