package Queue_Problem.队列的最大值;

import HASH.Hash;

import java.util.*;

//辅助队列的操作：元素尾部入队之前，从队列尾部依次取出比当前元素 value 小的元素，直到遇到一个比当前元素大的元素 value' 即可。
//这样就能够维护一个单调递减的队列了。
//假如入队的次序为1 3 2 4
//data队列为1时,辅助队列为1
//data队列为1 3时，辅助队列为3
//data队列为1 3 2时，辅助队列为3 2
//data队列为1 3 2 4 时 ，辅助队列为 4

//注意，当data出队的时候，如果出队元素等于辅助队列的队头元素则进行出队
//如果出队元素不等于辅助队列的队头元素则只需要peek队头元素。作为当前最大的元素。
public class MaxQueue {
    Deque<Integer> data;
    Deque<Integer> max;
    public MaxQueue() {
        // data是数据队列
        data = new LinkedList<>();
        // max是辅助队列
        max = new LinkedList<>();
    }

    public int max_value() {
        if(data.isEmpty())
        {
            return -1;
        }
        else{
            // 返回辅助队列的队头的元素
            return max.peekFirst();
        }
    }

    public void push_back(int value) {
        data.offerLast(value);
        //在进行入队的时候，max队列要同步进行入队的操作
        while(!max.isEmpty() && max.peekLast()<value)
        {
            max.pollLast();
        }
        max.offerLast(value);
    }

    public int pop_front() {
        HashSet<Integer> hash = new HashSet<>();
        //在进行出队的时候如果队列为空则返回0
        if(data.isEmpty())
        {
            return -1;
        }
        int value = data.pollFirst();
        if(max.peekFirst()==value)
        {
            max.pollFirst();
        }
        return value;
    }

    public static void main(String[] args) {
        int[][] array = new int[4][2];
        int count = 0;
        for(int[] i : array)
        {
            count++;

        }
        System.out.println(count);
    }
}
