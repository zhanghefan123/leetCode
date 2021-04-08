package 图.课程表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegrees = new int[numCourses];//创建一张入度表，即每一个结点的入度是多少
        List<List<Integer>> adjacency = new ArrayList<>();//创建一个点的邻接点
        Queue<Integer> queue = new LinkedList<>();//创建一个队列用来将入度为0的结点进行入队的操作
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // Get the indegree and adjacency of every course.
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;//将这个结点的入度进行递增的操作
            adjacency.get(cp[1]).add(cp[0]);//取出起始点对应的邻接矩阵的集合并且添加结束点，比如[[1,0]]就代表adjacency的0索引集合中加入了1
        }
        // Get all the courses with the indegree of 0.
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);//将所有度为0的结点进行入队的操作
        // BFS TopSort.
        // 当队列不空就进行循环。
        while(!queue.isEmpty()) {
            int pre = queue.poll();//进行出队操作，相当于删除结点的操作
            numCourses--;//将课程进行删除。
            for(int cur : adjacency.get(pre))//将一个点的邻接点的indegrees进行减去1的操作。
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }
}
