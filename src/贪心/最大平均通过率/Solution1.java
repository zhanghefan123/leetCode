package 贪心.最大平均通过率;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {
    public double maxAverageRatio(int[][] classes, int n) {

        // 定义优先队列，优先级按照增加 1 名学生之后能够产生的最大贡献来排序
        Queue<double[]> queue = new PriorityQueue<double[]>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                double x = ((o2[0]+1)/(o2[1]+1) - o2[0]/o2[1]), y = ((o1[0]+1)/(o1[1]+1) - o1[0]/o1[1]);
                if(x>y) return 1;
                if(x<y) return -1;
                return 0;
            }
        });

        // 转化为 double，方便小数计算
        for(int[] c : classes){
            queue.offer(new double[]{c[0], c[1]});
        }

        // 分配学生，每次分配 1 名
        while(n-->0){
            double[] c = queue.poll(); // 取出能够产生最大贡献的班级
            c[0]+=1.0d;
            c[1]+=1.0d;
            queue.offer(c);
        }

        // 计算最终结果
        double ans = 0;
        while(!queue.isEmpty()){
            double[] c = queue.poll();
            ans += (c[0]/c[1]);
        }
        return ans / classes.length;
    }
}