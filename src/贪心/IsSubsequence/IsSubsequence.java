package 贪心.IsSubsequence;
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        //字符串t可能会很长，但是s一定是较短的
        int i;
        int j;
        int start = 0 ;
        char temp;
        for(i=0;i<s.length();i++)
        {
            temp = s.charAt(i);
            for(j=start;j<t.length();j++)
            {
                if(temp == t.charAt(j))
                {
                    start = j+1;
                    break;
                }
            }
            if(j==t.length())
            {
                return false;
            }
        }
        return true;
    }
}
