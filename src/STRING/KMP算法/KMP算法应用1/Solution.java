package STRING.KMP算法.KMP算法应用1;
// KMP的应用1：
/*
题目:
假设存在一个原始串，现在要求只能在这个原始串的后面添加字符，
如何使得这个原始串出现两次，并且添加的字符的个数是最少的。

举例:
比如abcabc
我们只要在后面添加abc即可
因为abcabcabc
   ------
      ------

解决方案:
求出这个序列的next数组，然后我们多求一个终止位置的next数组，
比如aba我们求得最后一个终止位置的next数组值为2，所以原始串的a我们可以复用
接着我们需要添加剩下的ba,构成最终的结果ababa
* */
public class Solution {
    public static String answer(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chas = str.toCharArray();
        if (chas.length == 1) {
            return str + str;
        }
        if (chas.length == 2) {
            return chas[0] == chas[1] ? (str + String.valueOf(chas[0])) : (str + str);
        }
        int endNext = endNextLength(chas);
        return str + str.substring(endNext);
    }

    public static int endNextLength(char[] chas) {
        int[] next = new int[chas.length + 1];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (chas[pos - 1] == chas[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next[next.length - 1];
    }

    public static void main(String[] args) {
        String test1 = "a";
        System.out.println(answer(test1));

        String test2 = "aa";
        System.out.println(answer(test2));

        String test3 = "ab";
        System.out.println(answer(test3));

        String test4 = "abcdabcd";
        System.out.println(answer(test4));

        String test5 = "abracadabra";
        System.out.println(answer(test5));

    }
}
