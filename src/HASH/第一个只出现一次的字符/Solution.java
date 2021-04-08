package HASH.第一个只出现一次的字符;

public class Solution {
    public char firstUniqChar(String s) {
        char[] array = s.toCharArray();
        int[] alpha_count = new int[26];
        for(int i = 0;i<array.length;i++)
        {
            alpha_count[(array[i]-97)]++;
        }
        for(int i = 0;i<array.length;i++)
        {
            if(alpha_count[(array[i]-97)]==1)
            {
                return array[i];
            }
        }
        return ' ';
    }
}
