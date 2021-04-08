package 动态规划.最长序列型动态规划.俄罗斯套娃信封问题;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public int function(int[][] A)
    {
        if(A == null || A.length == 0)
        {
            return 0;
        }
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = A.length;
        int[] helper = new int[n];
        int res = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++)
        {
            helper[i] = 1;
            for(int j = 0;j<i;j++)
            {
                if(A[j][1] < A[i][1])
                {
                    helper[i] = Math.max(helper[i],helper[j]+1);
                }
            }
            res = Integer.max(res,helper[i]);
        }
        return res;
    }
}
