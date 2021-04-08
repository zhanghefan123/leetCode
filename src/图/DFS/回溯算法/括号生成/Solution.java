package 图.DFS.回溯算法.括号生成;

import java.util.ArrayList;
import java.util.List;
// 自己的解法--将参数全部换为成员变量
class Solution {
    public StringBuilder single;
    public int left_count;
    public int right_count;
    public int n;
    public List<String> res;

    public List<String> generateParenthesis(int n) {
        this.single = new StringBuilder();
        this.left_count = 0;
        this.right_count = 0;
        this.n = n;
        this.res = new ArrayList<>();
        dfs();
        return res;
    }

    public void dfs()
    {
        if(single.length() == 2 * n)
        {
            this.res.add(new String(single));
            return;
        }
        // 如果左括号的数目小于括号对的数目则添加左括号
        if(left_count < n)
        {
            this.single.append("(");
            this.left_count++;
            dfs();
            this.left_count--;
            this.single.deleteCharAt(single.length()-1);
        }
        // 如果右括号的数目小于左括号的数目则添加右括号
        if(right_count < left_count)
        {
            this.single.append(")");
            this.right_count++;
            dfs();
            this.right_count--;
            this.single.deleteCharAt(single.length()-1);
        }
    }
}

// 官方题解--若参数为基本类型则不用回溯，若为引用类型则需要回溯
class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

