package Queue_Problem.循环队列的实现;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {

    private int[] data;
    private int head;
    private int tail;
    private int size;
    private int current_size;

    public Solution(int k) {
        // 注意初始值的设置
        data = new int[k];
        // 指向队头元素
        head = 0;
        // 指向队尾元素
        tail = -1;
        size = k;
        current_size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if((tail == size - 1))
        {
            tail = 0;
            data[tail] = value;
        }
        else
        {
            tail++;
            data[tail] = value;
        }
        current_size++;
        return true;

    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if(head == size - 1)
        {
            head = 0;
        }
        else{
            head++;
        }
        current_size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    public boolean isEmpty() {
        return current_size == 0;
    }

    public boolean isFull() {
        return current_size == size;
    }
}

