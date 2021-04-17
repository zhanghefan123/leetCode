package 贪心.最大平均通过率;


import java.util.*;
class Node{
    public double total_students;
    public double pass_students;
    public Node(double pass_students,double total_students)
    {
        this.total_students = total_students;
        this.pass_students = pass_students;
    }
}

class Solution {

    public static PriorityQueue<Node> max_heap = new PriorityQueue<>(new Comparator<Node>() {


        public int compare(Node node1, Node node2)
        {
            // 给node1所代表的班级增加学生所能够创造的增量
            double increase_node1 = ((node1.pass_students + 1) / (node1.total_students + 1)) - (node1.pass_students / node1.total_students);
            double increase_node2 = ((node2.pass_students + 1) / (node2.total_students + 1)) - (node2.pass_students / node2.total_students);
            return increase_node2 - increase_node1 < 0 ? -1 : 1;
        }

    });

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 先进行大根堆的创建
        for(int[] tmp_class : classes)
        {
            double pass_students_of_class = (double)tmp_class[0];
            double total_students_of_class = (double)tmp_class[1];
            max_heap.add(new Node(pass_students_of_class,total_students_of_class));
        }
        // 首先将大根堆堆顶的元素弹出进行相加的操作
        // 总共存在extraStudents待分配班级
        for(int i = 0;i < extraStudents; i++)
        {
            Node head = max_heap.poll();
            head.total_students++;
            head.pass_students++;
            max_heap.add(head);
        }
        // 最后进行平均通过率的统计
        double final_res = 0;
        for(Node tmp : max_heap)
        {
            final_res += tmp.pass_students / tmp.total_students;
        }
        System.out.println(final_res / classes.length);
        return final_res / classes.length;

    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        s.maxAverageRatio(new int[][] {{2,4},{3,9},{4,5},{2,10}},4);
    }
}
