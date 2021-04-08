package 动态规划.最长序列型动态规划.最长上升子序列;

public class LongestIncreasingSubsequence {
    public int function(int[] A)
    {
        int n = A.length;
        if(n == 0)
        {
            return 0;
        }
        // helper[i]表示以A[i]结尾的最长上升子序列的长度
        int[] helper = new int[n];
        // 结果
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            helper[i] = 1;
            // A[i]遍历之前的元素
            for(int j = 0;j < i;j++)
            {
                if(A[j] < A[i])
                {
                    helper[i] = Integer.max(helper[i],helper[j] + 1);
                }
            }
            res = Integer.max(res,helper[i]);

        }
        return res;
    }
}
