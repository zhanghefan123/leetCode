package 贪心.会议室宣讲;
// 会议室宣讲
/*
一个项目要占用一个会议室进行宣讲，会议室不能同时容纳两个项目的宣讲，给你每一个项目开始的时间和结束的
时间(给你一个数组，里面是一个个具体的项目)，你来安排宣讲的日程，要求会议室进行的宣讲的场次最多，返回
这个最多的宣讲场次。

* */

// 贪心策略

// 一个错误的贪心策略
/*
哪个项目早开始我们就安排哪个项目。
对于这个贪心策略我们可以举出反例，就是当一个项目早上6点开始最早，但是
它将会占用全天的时间，明显不行。
* */

// 另一个错误的贪心策略
/*
时间越短的宣讲会，优先级越高。
* */

import java.util.Arrays;
import java.util.Comparator;

// 正确的贪心策略
/*
根据最早结束的项目来定优先级。
* */
public class Solution {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }

    }

    public static int bestArrange(Program[] programs, int start) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (start <= programs[i].start) {
                result++;
                start = programs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
