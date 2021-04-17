package ARRAY.双指针算法.相向双指针.leetcode125_验证回文串;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，
// 可以忽略字母的大小写。
public class Palindromic {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        s = s.toUpperCase();
        char[] charArray = s.toCharArray();
        while(i<j)
        {
            if(Character.isLetterOrDigit(charArray[i]))
            {

            }
            else{
                i++;
                continue;
            }
            if(Character.isLetterOrDigit(charArray[j]))
            {

            }
            else{
                j--;
                continue;
            }
            if(charArray[i]!=charArray[j])
            {
                return false;
            }
            else
            {
                i++;
                j--;
            }
        }
        return true;
    }
}
