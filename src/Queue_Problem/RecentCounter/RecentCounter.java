package Queue_Problem.RecentCounter;

import java.util.Deque;
import java.util.LinkedList;

class RecentCounter {

    private Deque<Integer> deque;
    public RecentCounter() {
        this.deque = new LinkedList<>();
    }

    //输入的肯定是一个递增的数组
    public int ping(int t) {
        deque.offerFirst(t);

        while(deque.size() > 0)
        {
            if(t-3000<=deque.peekLast())
            {
                return deque.size();
            }
            else
            {
                deque.pollLast();
            }
        }
        return 1;

    }
}
