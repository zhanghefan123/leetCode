package STRING.KMP算法;
//1.KMP解决的问题:
//str1主串和str2模式串，我们想要知道str1之中是否包含str2，
//如果有的话返回str2开始的位置
//--------------------------------------------------

//2.KMP相比较暴力匹配加速的原因：
//让前面匹配过的信息next数组指导后面。
//--------------------------------------------------

//3.概念的建设
//(最长)前缀的含义:(最长)不包含最后一个字符且包含首字符的子串
//(最长)后缀的含义:(最长)不包含第一个字符且包含尾字符的子串
//比如abcabc的最长前后缀为abc
//--------------------------------------------------
//在kmp之中我们要让每个字符记住一个东西，这个东西就是它前面的字符串中最长前后缀匹配的长度
//比如对于abcabcd,d记住的就是abcabc这个字符串的最长前缀和最长后缀相等的时候的值3


//4.求模式串的next数组的手算举例，next数组是str2的而不是str1的数组
/*
* 假设str2 = "ababac"
*            012345
* next[0]的求解 -- 由于前面没有字符串默认 -1
* next[1]的求解 -- 由于前面只有一个字符默认人为规定 0，因为前后缀不能包含自身，又只有一个字符所以固定为0
* next[2]的求解 -- 由于前面是ab,所以为 0
* 以此类推 next[3] = 1 next[4]= 2 next[5] = 3
* 后面我们将会讲解如何快速求解next数组
* */
//--------------------------------------------------

// 5.情况解析 -- 到底是如何利用next数组进行算法加速的。
/*
* "a b c a b c a"的next数组  = -1 0 0 1 2 2 3
*     索引      i …… …… ……  i+6
* 假设str1 = "……a b c a b c t"
*     索引      0 1 2 3 4 5 6
* 假设str2 =   "a b c a b c a"
*              ----- -----
*             ->->->"a b c a b c a"
* 模式串的索引为6的元素对应的最长前后缀匹配的为”a b c“
* 所以我们将模式串推进三个位置让前面的a b c占住原来 a b c
* 的位置由于我们知道前面的前缀和后面的后缀是匹配的所以
* 我们接着只要从str2的索引3号元素--next[6]开始与str1的索引i+6号元素开始匹配即可
*
* 实质是什么:
* 我们否定了主串的一些位置，即从这些位置开始配str2是一定
* 配不出来的，就比如上面例子之中的i+1号位置和i+2号位置
* 我们还在怀疑是否可以从i+3位置可以配出str2
* */

public class Kmp {
    // 代码
    public static int getIndexOf(String s, String m) {
        /*
        * s: 主串
        * m: 模式串
        * */
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        //------------------------------------------
        //1.将主串和从串变成char类型的数组--忽略java语言特性
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        //-------------------------------------------
        int si = 0; // si是指向str1的指针
        int mi = 0; // mi是指向str2的指针
        //-------------------------------------------
        //2.得出next数组--将getNextArray当成黑盒即可，后面会介绍
        int[] next = getNextArray(ms);
        //-------------------------------------------
        //终止条件，两个下表有一个到达终点就退出。
        while (si < ss.length && mi < ms.length) {
            //循环分析1:如果两个字符相等一同进行++
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            //循环分析2:如果两个字符不等并且next值为-1，那么说明第一个字符都没配上，没法向前跳了，所以直接让主串向后推进即可
            } else if (next[mi] == -1) {
                si++;
            }
            //循环分析3:如果两个字符不等并且mi指向的不是第一个字符，那么跳到next指向的位置
            else {
                mi = next[mi];
            }
        }
        //如果mi指向了str2最大索引+1的位置,说明全部完成了匹配，返回si-mi即可
        //否则返回-1
        return mi == ms.length ? si - mi : -1;
    }


    //获取next数组
    /*
    * 算法思想：
    * 假设字符串为 ”???? ……… ???? b a“
    *                /\
    * b这一处求得的最长后缀长度为4，此时求a的最长前后缀长度
    * 我们仅仅需要找到前缀的后一个字符是否为b,即/\所示的位置
    * 若为b则最长前后缀为5，如果不等的话则找到/\位置的前缀
    * 将这个前缀的后一个字符和b进行比较，若相等则等于这个前缀的长度+1
    * 否则继续循环往复
    *
    * 算法手算举例：
    * 假设字符串为 a b a b c a b a b  t  k
    *      t前缀 -------   -------
    *       索引                    i-1 i
    * 我们需要求得是k的最长前缀匹配长度
    * 我们看到t的最长前后缀为a b a b
    * c和t不相等，所以继续循环
    * a b a b c ……
    * --- ---
    * 我们需要找出c的最长前后缀的前缀为a b，而前缀的后一个字符为a,a和t进行比对没有比上
    * 然后再想要找到a前面的字符串的最长前后缀--发现找不到了，所以我们得出K的最长前后缀结果为0
    *
    *
    * 算法手算举例2：
    * 假设字符串为 a b a b c a b a b a k
    *                             i-1 i
    * 我们需要求的是k的最长前缀匹配长度，
    * 我们看到a的最长前缀后缀为a b a b
    * 所以我们看前缀的后一个位置和a是否相等，发现是c和a不相等
    * 然后继续看c的最长前缀匹配长度，我们看到c的最长前后缀为a b
    * 将前缀的下一个字符a和a进行比较发现相等，所以k的最长前缀匹配长度为2 + 1 = 3
    */
    public static int[] getNextArray(char[] ms) {
        //0位置固定为-1
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        //0位置固定为-1，1位置固定为0，人为规定
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2; //接下来要求的next[pos]，因为0，1位置已经求得，所以从2位置开始进行计算
        int cn = 0; //我们要跳到的位置即要找到其之前字符串的最长前后缀以及需要比较是否和pos-1位置上相等的位置
        while (pos < next.length) {
            //循环分析1--如果我当前跳到的位置和我们要求的位置的前一个字符相等，则等于0-(cn-1)一共cn个再+1 = cn+1个
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            //循环分析2--如果我当前跳到的位置和我们要求的位置的前一个字符不等，如果cn>0即我还能向前跳
            } else if (cn > 0) {
                cn = next[cn];
            //循环分析3--当cn跳到了0位置，跳无可跳。得出所求位置为0
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));

    }
}










