package 图.DFS.回溯算法.电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public HashMap<Character,String> map;
    public char[] array;
    public int length;
    public List<String> res;

    public void init(String digits)
    {
        // 首先将各个数字作为键，他们所可能对应的字母序列作为值
        map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        this.array = digits.toCharArray();
        this.length = digits.length();
        this.res = new ArrayList<>();
    }



    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
        {
            return new ArrayList<>();
        }
        init(digits);
        dfs(new StringBuilder(),0);
        return this.res;
    }



    public void dfs(StringBuilder current_str,int current_index)
    {
        if(current_str.length() == this.length)
        {
            this.res.add(new String(current_str));
            return;
        }
        char current_char = array[current_index];
        // 获取这个数值可能对应的字母序列
        String str_to_digits = map.get(current_char);
        for(int i = 0; i < str_to_digits.length(); i++)
        {
            current_str.append(str_to_digits.charAt(i));
            dfs(current_str,current_index+1);
            current_str.deleteCharAt(current_str.length()-1);
        }
    }
}
