package 动态规划.坐标型动态规划.数字三角形;

import java.util.*;
public class Solution {

    public static ArrayList<ArrayList<Integer>> matrix;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int level_count = sc.nextInt();
        sc.nextLine();
        matrix = new ArrayList<>();
        int max_size = 0;
        for(int i = 0;i < level_count;i++)
        {
            ArrayList<Integer> tmp = new ArrayList<>();
            String[] numbers = sc.nextLine().split(" ");
            for (String number : numbers) {
                tmp.add(Integer.parseInt(number));
            }
            if(i == level_count-1)
            {
                max_size = tmp.size();
            }
            matrix.add(tmp);
        }
        int[][] dp = new int[level_count][max_size];
        // 开始进行自底向上的遍历
        // 首先进行最后一行的初始化的操作
        for(int i = 0;i < max_size;i++)
        {
            dp[level_count-1][i] = matrix.get(level_count-1).get(i);
        }
        // 然后进行其他行的初始化
        for(int i = level_count-2;i>=0;i--)
        {
            for(int j = 0; j < matrix.get(i).size(); j++)
            {
                dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+1]) + matrix.get(i).get(j);
            }
        }
        System.out.println(dp[0][0]);
        sc.close();
    }
}
