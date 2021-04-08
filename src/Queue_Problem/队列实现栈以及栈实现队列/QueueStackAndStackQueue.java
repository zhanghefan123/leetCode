package Queue_Problem.队列实现栈以及栈实现队列;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//给定两个栈，一个push栈，一个pop栈。
//用户给的数放入push栈，用户想要得到数从pop栈拿出
//比如用户放入了 1 2 3 4 5 到 push栈,然后如果用户
//想要pop的话，就将push栈中的内容全部导入pop栈中，然后弹栈即可

//限制1:如果push栈决定要向pop栈之中倒入东西要倒完
//限制2:如果pop栈之中有东西一定不能倒
public class QueueStackAndStackQueue {
    // 栈实现队列
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int pushInt) {
            stackPush.push(pushInt);
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

    //两个队列实现栈结构
    /*
    假设存在5个数依次的进入队列queue
    队列1 queue   1  2  3  4  5
                head        tail
    我们进入的顺序是 1 2 3 4 5 ，所以栈顶元素应该是 5，我们弹栈的话应该弹出5
    队列2 help   接收队列1的前四个数，
                1  2  3  4
              head      tail
    最后一个元素返回给用户

    * */

    public static class TwoQueuesStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt) {
            queue.add(pushInt);
        }

        public int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            // 将除了最后一个数，全部放到help栈之中去
            while (queue.size() != 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            //只要queue栈中的元素的个数大于1，就接着出队将元素放到help之中
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();//让queue指向help指向的对象，让help指向queue
            return res;
        }

        // data队列和help队列交换。
        private void swap() {
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }

    }

}
