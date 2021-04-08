package 动态规划.划分型动态规划;

public class PalindromePartitioning2 {
    public int minCut(String s) {
        int length = s.length();
        if(length == 0)
        {
            return 0;
        }
        int[] helper = new int[length+1];
        helper[0] = 0;
        int res;
        String lastPalindrome;
        for(int i = 1; i <=length; i++)
        {
            res = Integer.MAX_VALUE;
            for(int j = 0; j<i; j++)
            {
                lastPalindrome = s.substring(j,i);
                if(isPalindrome(lastPalindrome))
                {
                    res = Integer.min(res,helper[j]+1);
                }
                else
                {
                    continue;
                }
            }
            helper[i] = res;
        }
        for(int s_tmp : helper)
        {
            System.out.println(s_tmp);
        }
        return helper[length]-1;
    }

    public boolean isPalindrome(String s)
    {
        // 如果只有一个字符直接返回true,是回文串。
        if(s.length() == 1)
        {
            return true;
        }
        int start = 0;
        int end = s.length()-1;
        while(start<=end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
