package STACK.计算字符串;
// 题目:
/*
给定一个字符串str,str表示一个公式，公式里可能有整数，
加减乘除符号和左右括号，返回公式的计算结果

举例:
str = "48 * ((70-65) -43)+8*1" 返回-1816
str = "3+1*4" 返回7，str="3+(1*4)"

说明:
1.可以认为给定的字符串一定是正确的公式，即不需要对str做公式
有效性检验。
2.如果是负数，就需要使用括号括起来,比如4 * (-3)，但是如果负数
作为开头或者括号部分的开头，则可以没有括号，比如-3*4和(-3*4)都是
合法的
3.不用开率计算过程中会发生溢出的情况，
* */

import java.util.LinkedList;

// 思路:
/*
1.如果整个式子没有括号
从左向右将找到的数放到栈中，并且将找到的符号放到栈之中。
在放数值的时候检查栈顶，如果栈顶元素是"*或者/"将弹出两个元素结算之后压入栈中
当遍历完成整个字符串之后，依次将栈中的元素弹出，并进行计算。

2.运用上述的思路
定义一个函数f(str,index)
str永远是一开始给定我们的那个完整的str,index是说我们计算str从index开始到右括号结束的位置
我们遇到左括号就在左括号的下一个位置调用子过程
* */
public class Solution {
    // 主函数
    public static int getValue(String str) {
        return value(str.toCharArray(), 0)[0];
    }

    // 整体的递归过程
    // str永远不变，就相当于一个全局变量
    // i代表从哪个位置开始进行计算


    // 返回的数组永远length为2，arr[0]代表计算结果，arr[1]代表计算到了哪个位置
    public static int[] value(char[] str, int i) {
        LinkedList<String> que = new LinkedList<String>();
        int pre = 0;
        int[] bra = null;
        // 当i没到最后，并且不是右括号就继续
        while (i < str.length && str[i] != ')') {
            // 收集数值
            if (str[i] >= '0' && str[i] <= '9') {
                pre = pre * 10 + str[i++] - '0';
            // 遇到的不是数字且不是左括号，所以代表的是遇到的是符号
            } else if (str[i] != '(') {
                // 将收集到的数值和结果都放到栈之中去
                addNum(que, pre);
                que.addLast(String.valueOf(str[i++]));
                // 将数值进行归零等待下一次收集
                pre = 0;
            // 如果遇到的是左括号，进入递归
            } else {
                // 递归调用，计算从左括号到最近的右括号的值以及计算到的位置
                bra = value(str, i + 1);
                pre = bra[0];
                // 然后现在索引到了bra[1] + 1，右括号的下一个位置
                i = bra[1] + 1;
            }
        }
        addNum(que, pre);
        return new int[] { getNum(que), i };
    }

    public static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    public static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String exp = "48*((70-65)-43)+8*1";
        System.out.println(getValue(exp));

        exp = "4*(6+78)+53-9/2+45*8";
        System.out.println(getValue(exp));

        exp = "10-5*3";
        System.out.println(getValue(exp));

        exp = "-3*4";
        System.out.println(getValue(exp));

        exp = "3+1*4";
        System.out.println(getValue(exp));

    }

}
