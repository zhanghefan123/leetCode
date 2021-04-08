package 滑动窗口.无重复字符的最长子串;

import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
        {
            return 0;
        }
        // 首先创建一个哈希表
        HashSet<Character> set = new HashSet<>();
        // 将s转换为字符数组
        char[] charArray = s.toCharArray();
        int start = 0;
        int res = Integer.MIN_VALUE;
        int end;
        for(end = 0;end<=s.length()-1;end++)
        {
            if(!set.contains(charArray[end]))
            {
                set.add(charArray[end]);
                res = Integer.max(end-start,res);
            }
            else
            {
                // 出现重复的charArray[end]
                res = Integer.max(end-start,res);
                char tmp = charArray[end];
                while(true)
                {
                    if(charArray[start] == tmp)
                    {
                        start++;
                        break;
                    }
                    set.remove(charArray[start]);
                    start++;
                }
            }
        }
        res = Integer.max(end-start,res);
        return res;
    }
}
