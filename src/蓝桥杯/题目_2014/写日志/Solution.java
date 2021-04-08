package 蓝桥杯.题目_2014.写日志;
// 写日志

// 写日志是程序的常见任务，现在要求在t1.log,t2.log,t3.log三个文件之间轮流写入日志
// 也就是说第一次写入t1.log,第二次写入t2.log,……第四次仍然写入t1.log
public class Solution {
    private static int n = 1;
    public static void write(String msg)
    {
        String filename = "t" + n + ".log";
        n = (++n)%4 == 0 ? 1:n;
        System.out.println("write to file:" + filename + " " + msg);
    }

    public static void main(String[] args) {
        for(int i = 0;i<9;i++)
        {
            write("1");
        }
    }
}
