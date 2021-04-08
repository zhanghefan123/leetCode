package STRING.Manacher算法;

// 一个字符串之中找到最长回文子串
// 暴力解法
/*
思路1:
从每个字符向两边进行扩充，如果两边字符相等则长度+2
但是这样无法应对偶回文串的情况，比如1221，使用这种方式的话结果为0
除非我们每次选中两个字符往外扩。

思路2:
像每个字符的两侧添加特殊字符。

举例:
       1  1  3  1  1
# 1 # 1 # 3 # 1 # 1 #  添加特殊字符后的回文串
1 3 5 3 1 11 1 3 5 3 1 回文串长度
结果为11/2 = 5 向下圆整

* */

// 概念的普及
// 1.回文直径:以某一个点向两边扩充形成的回文串的长度

// 2.回文半径数组:以每个位置能够扩充的回文半径的长度记录在这个数组之中

// 3.最右回文右边界:
/*
字符串:#1#2#1#……
 索引:0123456……
一开始最右回文右边界为-1，当我们从0位置开始向着两边进行扩充，最右回文右边界来到1
之后我们来到索引1位置，向两边进行扩充，最有回文有边界来到2位置……
* */

// 4.最右侧回文右边界的中心
/*
回文右边界只要没有进行更新，就记录最早能使回文右边界到达这里的回文中心的位置。

举例:
1 2 1 3 1 2 1
      ^
0 1 2 3 4 5 6 索引
当回文中心是3的时候可以将最右回文右边界推到索引为6的位置
当来到2的位置向两边进行扩的时候右边界还是停留在索引为6的位置，但是此时的最右侧回文右边界的中心依然是先前的索引3位置
* */

// manacher算法
/*
情形1:当前位置不在最右回文右边界里面的时候进行暴力扩展
情形2:当前位置在最右回文右边界里面的时候找到这个位置的关于回文中心C的对称点，如果以对称点为中心B的回文串被包在
以会问中心C为中心的回文串[L,R]之中。那么将是下图所示的情形
[L    [l  i'  r]            C                i      R]
比如 ab[cdcbatttabcdc]f
      L i'   c    i R
那么以i为回文中心的回文长度将是i'为回文中心的长度。

情形2:当前位置在最右回文右边界里面的时候找到这个位置的关于回文中心C的对称点，如果以对称点为中心B的回文串超过了
[L,R]边界的左边界，那么将是下图所示的情形:
[l   [L   i'     r]            C                i      R]
比如 (ab[cdcba)tttabcdcdc]f
       L i'    c      i R
结果是i的回文半径就是i到R
证明:我们让L关于i'进行对称形成L’，我们让R关于i进行对称形成R‘
L到L'以及R到R'必是回文，L左侧的字符X'必然不等于R右侧的字符X，
又因为X'等于L’右侧的字符Y',X等于R'左侧的字符Y，所以X!=Y

情形4:当前位置在最右回文右边界里面的时候找到这个位置的关于回文中心C的对称点，如果以对称点为中心B的回文串压住了
[L,R]边界的左边界
[L/l   i'   r]      C                i      R]
比如 [(abcba)kkkabcba]k
   L/l  i'   c   i R
* */



public class Solution {
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        // 在中间和两侧进行#的添加。
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        // 记录以这个索引位置的元素为回文中心的回文半径
        int[] pArr = new int[charArr.length];
        // index就是最右回文右边界的回文中心
        int index = -1;
        // pR就是最右回文右边界
        int pR = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            // pR > i 的话，i就在回文右边界之内，这时满足情况2或者3
            // 此时右侧的圆括号和中括号哪个边界越靠近 （  [ i'  ) c  (  i ]  )
            // 就以哪个为准2 * index - 1 就是 i 所对应的i'
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            // 进行的是pR == i的检测。
            // 再进行两边括，情况23扩一下就会失败，而情况14还有可能向两边进行扩充
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            // 更新最右回文右边界和回文中心index
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }
}
