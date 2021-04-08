package ARRAY.整数反转;

public class Solution {
    public int reverse(int x) {
        if(x<0)
        {
            String tmp = String.valueOf(-x);
            char[] charArray = tmp.toCharArray();
            int i = 0;
            int j = charArray.length-1;
            while(i<=j)
            {
                char tmp_char = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = tmp_char;
                i++;
                j--;
            }
            try{
                return -Integer.parseInt(new String(charArray));
            }
            catch(Exception e)
            {
                return 0;
            }
        }
        else
        {
            String tmp = String.valueOf(x);
            char[] charArray = tmp.toCharArray();
            int i = 0;
            int j = charArray.length-1;
            while(i<=j)
            {
                char tmp_char = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = tmp_char;
                i++;
                j--;
            }
            try{
                return Integer.parseInt(new String(charArray));
            }
            catch(Exception e)
            {
                return 0;
            }
        }
    }
}
