package STRING.Manacher算法.ManaCher算法应用;

// manacher算法应用
/*
题目:
一个字符串只能够向后面进行字符的添加，问如何添加最少的字符
使得整个字符串变成回文串。

举例:
给定的字符串为: abc12321
我们需要添加为: abc12321abc

思路:
其实这道题的含义就是，除去必须包含最后一个字符的最长的回文串，将前面的字符串逆序过来就是答案。
* */

import java.util.Arrays;

public class Solution {
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static String shortestEnd(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int maxContainsEnd = -1;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            // 与manacher算法唯一的不同之处
            if (pR == charArr.length) {
                // 最长回文半径
                maxContainsEnd = pArr[i];
                System.out.println(maxContainsEnd);
                break;
            }
        }
        System.out.println(Arrays.toString(pArr));
        char[] res = new char[str.length() - maxContainsEnd + 1];
        for (int i = 0; i < res.length; i++) {
            res[res.length - 1 - i] = charArr[i * 2 + 1];
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str2 = "abcd123321";

        System.out.println(shortestEnd(str2));

    }
}
