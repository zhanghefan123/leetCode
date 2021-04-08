package Recursion.打印一个字符串的全部子序列.回溯版本;

import java.util.ArrayList;
import java.util.Scanner;

// 打印一个字符串的全部子序列，包括空字符串
public class Solution {
    // abc的子序列
    // 空串,a,b,c,ab,ac,bc,abc
    public ArrayList<Character> tmp_res;

    public char[] charArray;

    public Solution()
    {
        this.tmp_res = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        solution.charArray = sc.next().toCharArray();
        for(int i = 0; i <= solution.charArray.length;i++)
        {
            solution.TraceBack(i,0);
        }
    }

    public void TraceBack(int length,int index)
    {
        if(length == tmp_res.size()){
            System.out.println(tmp_res);
            return;
        }
        else
        {
            for(int i = index ; i < charArray.length; i++)
            {
                tmp_res.add(charArray[i]);
                TraceBack(length,i+1);
                tmp_res.remove(tmp_res.size()-1);
            }
        }
    }
}
