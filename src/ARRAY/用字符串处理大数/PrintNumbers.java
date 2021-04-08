package ARRAY.用字符串处理大数;
// 题目：
/*
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:
输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]

* */
// 思路：
public class PrintNumbers {
    public int[] printNumbers(int n) {
        int[] res = new int[(int)Math.pow(10, n) - 1];
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append('0');
        }
        int count = 0;
        while(!increment(str)){
            int index = 0;
            while (index < str.length() && str.charAt(index) == '0'){
                index++;
            }
            res[count] = Integer.parseInt(str.toString().substring(index));
            count++;
        }
        return res;
    }

    public boolean increment(StringBuilder str) {
        boolean isCarry = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            char s = (char)(str.charAt(i) + 1);
            if (s > '9') {
                str.replace(i, i + 1, "0");
                if (i == 0) {
                    isCarry = true;
                }
            }
            else {
                str.replace(i, i + 1, String.valueOf(s));
                break;
            }
        }
        return isCarry;
    }
}
