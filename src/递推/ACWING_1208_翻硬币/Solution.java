package 递推.ACWING_1208_翻硬币;
import java.util.*;

class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder initial_sequence = new StringBuilder(sc.nextLine());
        StringBuilder final_sequence = new StringBuilder(sc.nextLine());
        // 从第一个位置开始进行遍历
        int count = 0;
        for(int i = 0;i < initial_sequence.length()-1; i++)
        {
            if(final_sequence.equals(initial_sequence))
            {
                break;
            }
            // 看i位置的字符是否相等
            if(initial_sequence.charAt(i) == final_sequence.charAt(i))
            {
                // 如果相等
                continue;
            }
            else
            {
                // 如果不相等则进行翻转
                if(initial_sequence.charAt(i) == 'o')
                {
                    initial_sequence.replace(i,i+1,"*");
                }
                else
                {
                    initial_sequence.replace(i,i+1,"o");
                }
                if(initial_sequence.charAt(i+1) == 'o')
                {
                    initial_sequence.replace(i+1,i+2,"*");
                }
                else
                {
                    initial_sequence.replace(i+1,i+2,"o");
                }
                count++;
            }
        }
        System.out.println(count);
    }
}