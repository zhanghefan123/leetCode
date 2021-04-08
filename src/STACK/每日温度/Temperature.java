package STACK.每日温度;

import java.util.Deque;
import java.util.LinkedList;

//维护一个栈底向栈顶非递增，即可能相等，可能递减的单调栈
//所以如果栈为空或者当日温度小于栈顶则直接入栈。反之若当日温度大于栈顶温度，说明栈顶元素的升温日
//已经找到了。然后我们将栈顶元素弹出即可，计算其与当日相差的天数即可
public class Temperature {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
