package STRING.翻转单词顺序;

public class Solution {
    public  static String reverseWords(String s) {
        String[] s_array = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i<s_array.length;i++)
        {
            // 如果不为空串则进行
            if(!s_array[i].equals(""))
            {
                if(i == 0)
                {
                    builder.append(s_array[i]);
                }
                else
                {
                    builder.insert(0,s_array[i]+" ");
                }
            }
        }
        return new String(builder);
    }

    public static void main(String[] args) {
    }
}
