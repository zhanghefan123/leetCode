package STACK.BaseballPlayer;

import java.util.Deque;
import java.util.LinkedList;

public class BaseballPlayer {
    public int calPoints(String[] ops) {
        Deque<String> deque = new LinkedList<>();
        for(int i=0;i<ops.length;i++)
        {
            if(IsNum(ops[i]))
            {
                deque.offerFirst(ops[i]);
            }
            else if(ops[i].equals("+"))
            {
                int temp1 = Integer.parseInt(deque.pollFirst());
                int temp2 = Integer.parseInt(deque.pollFirst());
                deque.offerFirst(String.valueOf(temp2));
                deque.offerFirst(String.valueOf(temp1));

                int sum = temp1+temp2;
                deque.offerFirst(String.valueOf(sum));
            }
            else if(ops[i].equals("D"))
            {
                int temp1 = Integer.parseInt(deque.pollFirst());
                deque.offerFirst(String.valueOf(temp1));
                int sum = temp1*2;
                deque.offerFirst(String.valueOf(sum));
            }
            else if(ops[i].equals("C"))
            {
                deque.pollFirst();
            }
            System.out.println(deque);
        }
        int result = 0;
        int size = deque.size();
        for(int i=0;i<size;i++)
        {
            result += Integer.parseInt(deque.pollFirst());
        }
        return result;
    }
    private boolean IsNum(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
