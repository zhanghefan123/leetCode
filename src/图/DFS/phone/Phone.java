package 图.DFS.phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Phone {
    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
        {
            return new ArrayList<>();
        }
        HashMap<String,String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        List<String> res = new ArrayList<>();
        helper(0,res,digits,new String(),map);
        return res;
    }

    public void helper(int cur_index,List<String> res,String digits, String cur,HashMap<String,String> map)
    {
        if(cur_index == digits.length())
        {
            res.add(new String(cur));
            return;
        }
        char number = digits.charAt(cur_index);//第一个数字 -- 对应的为a,b,c
        String number_to_sequence = map.get(Character.toString(number));//第一个数字能够对应的字母序列。
        //在字母序列之中进行遍历。
        for(int j = 0; j < number_to_sequence.length();j++)
        {
            cur += Character.toString(number_to_sequence.charAt(j));
            helper(cur_index+1,res, digits,cur,map);
            cur = cur.substring(0,cur.length()-1);
        }

    }
}
