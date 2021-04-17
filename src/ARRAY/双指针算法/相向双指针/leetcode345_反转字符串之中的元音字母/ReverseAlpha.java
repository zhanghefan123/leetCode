package ARRAY.双指针算法.相向双指针.leetcode345_反转字符串之中的元音字母;
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
public class ReverseAlpha {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        String alpha = "aeiouAEIOU";
        char [] charArray = s.toCharArray();
        while(i<j)
        {
            if(alpha.contains(Character.toString(charArray[i])))
            {

            }
            else
            {
                i++;
                continue;
            }
            if(alpha.contains(Character.toString(charArray[j])))
            {

            }
            else
            {
                j--;
                continue;
            }
            char tmp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmp;
            i++;
            j--;
        }
        return new String(charArray);
    }
}
