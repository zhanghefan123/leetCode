package 动态规划.划分型动态规划;

public class  PalindromePartitioning2Optimizer {
    public int minCut(String s) {
        int length = s.length();
        if(length == 0)
        {
            return 0;
        }
        char[] array = s.toCharArray();
        boolean[][] isPalindrome = calcPalindrome(array);
        int[] helper = new int[length+1];
        helper[0] = 0;
        int res;
        String lastPalindrome;
        for(int i = 1; i <= length; i++)
        {
            res = Integer.MAX_VALUE;
            for(int j = 0; j<i; j++)
            {
                if(isPalindrome[j][i-1])
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

    public boolean[][] calcPalindrome(char[] array)
    {
        int n = array.length;
        // 这是一个布尔数组，每一个元素[i][j]用来记录S[i……j]是否是回文串
        boolean[][] res = new boolean[n][n];
        // 奇数长度
        int i,j;
        // c是center character
        for(int c = 0; c < n;c++)
        {
            i = j = c;
            while(i>=0 && j<=(n-1) && array[i]==array[j])
            {
                res[i][j] = true;
                i--;
                j++;
            }
        }
        // c是center line
        for(int c = 0;c < n-1;c++)
        {
            i = c;
            j = c+1;
            while(i>=0 && j < n && array[i] == array[j])
            {
                res[i][j] = true;
                i--;
                j++;
            }
        }
        return res;
    }
}