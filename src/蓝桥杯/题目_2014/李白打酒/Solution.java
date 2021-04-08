package 蓝桥杯.题目_2014.李白打酒;

import java.util.ArrayList;

// 李白打酒
/*
话说大诗人李白，一生好饮酒，幸好他从来不开车
一天，他提着酒壶，从家里出来，酒壶之中有酒2斗，他边走边唱：
无事街上走，提壶去打酒
逢店加一倍，遇花喝一斗

这一路上，他一共遇到店5次，遇到花10次，已知最后一次遇到的是花，他正好把酒都喝光了

请你计算李白遇到店和化的次序，可以将遇到店即为a,遇到花记为b,则babaabbabbabbbb就是合理的次序
像这样的答案一共有多少呢？请你给出所有可能的方案的个数


* */
public class Solution {

    public int count;

    // 遇到店的次数
    public int a;

    // 遇到花的次数
    public int b;

    public ArrayList<Character> tmp;

    public Solution(){
        this.count = 0;
        this.a = 5;
        this.b = 10;
        this.tmp = new ArrayList<>();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.traceBack(2);
        System.out.println(solution.count);
    }

    public void traceBack(int current)
    {
        if(current == 0 && this.a == 0 && this.b == 0)
        {
            if(tmp.get(tmp.size()-1) == 'b')
            {
                System.out.println(tmp);
                this.count++;
                return;
            }
            else
            {
                return;
            }

        }
        else if(this.a < 0 || this.b < 0 || this.count < 0)
        {
            return;
        }
        for(int i = 0; i <= 1 ;i++) {
            if (i == 0) {
                this.a--;
                this.tmp.add('a');
                traceBack(current * 2);
                this.tmp.remove(this.tmp.size()-1);
                this.a++;
            } else {

                this.b--;
                this.tmp.add('b');
                traceBack(current - 1);
                this.tmp.remove(this.tmp.size()-1);
                this.b++;
            }
        }

    }
}
