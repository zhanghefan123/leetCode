package STACK.ValidParentheses;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        boolean flag = true;
        int in = 0;
        int out = 0;
        for(int i = 0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c=='{')
            {
                deque.offerFirst(c);
                in++;
            }
            else if(c == ')' || c == ']' || c=='}')
            {
                if(deque.size()==0)
                {
                    return false;
                }
                else
                {
                    char top = deque.pollFirst();
                    out++;
                    if((c == ')' && top == '(') || (c == ']' && top == '[')||(c == '}' && top == '{'))
                    {
                        flag = true;
                    }
                    else
                    {
                        return false;
                    }
                }

            }
        }
        return in == out;
    }
}
