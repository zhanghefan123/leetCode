package STACK.下一个更大元素2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] ret = new int[length];
        Arrays.fill(ret,-1);
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i<=(2*length-2); i++)
        {
            // 如果栈为空，则直接添加
            if(stack.isEmpty())
            {
                stack.push(i % length);
            }
            else
            {
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i%length])
                {
                    int tmp = nums[i%length];
                    ret[stack.pop()] = tmp;
                }
                stack.push(i%length);
            }
        }
        return ret;
    }
}
