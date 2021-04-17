package 贪心.雷达设备;

import java.util.*;
class Segment{
    public double left;
    public double right;
    public Segment(double left,double right)
    {
        this.left = left;
        this.right = right;
    }
}

class Solution{

    public static ArrayList<Segment> queue = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 小岛的数目
        int n = sc.nextInt();
        // 雷达的检测范围
        int d = sc.nextInt();
        // 进行所有的区间的存储

        // 开始进行探测
        for(int i = 0; i < n; i++)
        {
            // 小岛的x坐标
            int x = sc.nextInt();
            // 小岛的y坐标
            int y = sc.nextInt();
            // 如果y > d那么肯定侦测不到
            if(y > d)
            {
                System.out.println(-1);
                return;
            }
            else
            {
                double length = Math.sqrt(d * d - y * y);
                double left = x - length;
                double right = x + length;
                queue.add(new Segment(left,right));
            }
        }
        // 将队列按照区间的右端点进行排序
        Collections.sort(queue,new Comparator<Segment>(){
            public int compare(Segment s1,Segment s2)
            {
                return s1.right - s2.right > 0 ? 1 : -1;
            }
        });
        // 然后按照贪心算法找出需要的点数
        int count = 0;
        double last_node = -1e20;
        for(int i = 0; i < queue.size(); i++)
        {
            Segment s = queue.get(i);
            if(last_node < s.left)
            {
                last_node = s.right;
                count++;
            }
        }
        System.out.println(count);
    }
}