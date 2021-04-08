package Recursion.打印一个字符串的全部子序列.左程云版本;

public class Solution {
    public static void printAllSubsequence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0,"");
    }

    public static void process(char[] chs, int i,String res) {
        if (i == chs.length) {
            System.out.println(String.valueOf(res));
            return;
        }
        // 这个字符不进入
        process(chs,i+1,res);
        // 这个字符进入
        process(chs,i+1,res+(chs[i]));
    }

    public static void main(String[] args) {
        String test = "abc";
        printAllSubsequence(test);
    }
}
