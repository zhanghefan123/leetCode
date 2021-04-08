package Queue_Problem.优先级队列;

import java.util.Collections;

public class PriorityQueue {
    public static void main(String[] args) {
        java.util.PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>();
        char s = Integer.toString(1).charAt(0);
        priorityQueue.add(4);
        priorityQueue.add(3);
        priorityQueue.add(5);
        while(!priorityQueue.isEmpty())
        {
            System.out.println(priorityQueue.poll());
        }
    }
}
