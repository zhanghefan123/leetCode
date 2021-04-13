package 动态规划.状压dp.玉米田;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static ArrayList<Integer> valid_state_list = new ArrayList<>();

    public static HashMap<Integer,ArrayList<Integer>> valid_transform = new HashMap<>();

    public static int m;

    public static int n;

    public static int mod = 100000000;

    public static boolean valid_state(int number){
        // 因为仅仅存在n列，所以每一个状态使用3位来进行表示
        for(int i = 0; i < n; i++)
        {
            if((((number>>i) & 1) == 1) && (((number>>i+1) & 1) == 1))
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 总共存在m行
        m = sc.nextInt();
        // 总共存在n列
        n = sc.nextInt();
        // 找到所有不能选择的位置

        // 使用一个g数组来存储每一行的状态
        // g数组之中的每一个元素表示都是一行的状态
        // 这一个元素之中为1的位代表这一行的这一个位置不能种玉米
        int[] g = new int[m+1];
        for(int i = 1; i <= m; i++)
        {
            for(int j = 0;j < n; j++)
            {
                int tmp = sc.nextInt();
                if(tmp == 0)
                {
                    // g[1]代表索引为1的行。
                    g[i] += 1 << j;
                }
            }
        }
        // 然后将可选的状态进行记录(一行只能不允许出现两个相邻的1)
        // 比如对于三列，总共有000~111总共8种状态。
        for(int i = 0; i < 1 << n; i++)
        {
            if(valid_state(i))
            {
                valid_state_list.add(i);
            }
        }
        // 找到可以进行转移的valid_state_list
        for(int i = 0; i < valid_state_list.size(); i++)
        {
            for(int j = 0;j < valid_state_list.size(); j++)
            {
                int a = valid_state_list.get(i);
                int b = valid_state_list.get(j);
                if((a & b) == 0)
                {
                    if(!valid_transform.containsKey(a))
                    {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(b);
                        valid_transform.put(a,list);
                    }
                    else
                    {
                        valid_transform.get(a).add(b);
                    }
                }
            }
        }
        // 创建dp矩阵
        int[][] dp = new int[m+1][(1<<n)];
        dp[0][0] = 1;
        // 遍历前i行，到前m行
        for(int i = 1;i <= m; i++)
        {
            // 遍历索引i-1行的所有的可能的状态。
            for(int state : valid_state_list)
            {
                // 如果这个状态不被允许则进行continue
                if((g[i] & state) > 0)
                {
                    continue;
                }
                // 找到state可以成功转移的状态
                for(int state_transform_to : valid_transform.get(state))
                {
                    // 如果转移失败的话就是错误的
                    if((g[i - 1] & state_transform_to) > 0)
                    {
                        continue;
                    }
                    dp[i][state] = (dp[i][state] + dp[i-1][state_transform_to]) % mod ;

                }
            }
        }
        long res = 0;
        for(int i = 0; i < (1<<n);i++){
            res =  (res  + dp[m][i] )  % mod;
        }
        System.out.println(res);

    }
}
