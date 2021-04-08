package STACK.栈的压入和弹出序列;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public Deque<Integer> helper;
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 辅助栈
        this.helper = new LinkedList<>();
        // 声明一个变量指向当前popped被遍历到哪里了。
        int count = 0;
        // 遍历pushed数组
        for(int i = 0;i<pushed.length;i++)
        {
            helper.push(pushed[i]);
            // 检查是否和popped元素相同
            while(true)
            {
                if(helper.isEmpty())
                {
                    break;
                }
                if(helper.peek()==popped[count])
                {
                    helper.pop();
                    count++;
                }
                else{
                    break;
                }
            }
        }
        // 然后遍历弹栈的元素
        int length = helper.size();
        for(int i = 0;i < length;i++)
        {
            if(popped[count]!=helper.pop())
            {
                return false;
            }
            else
            {
                count++;
            }
        }
        return true;
    }
}
