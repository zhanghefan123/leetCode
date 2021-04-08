package Recursion.acwing递归实现排列型枚举;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution{

    public static int n;

    public static boolean[] visited;

    public static ArrayList<StringBuilder> res;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n];
        res = new ArrayList<>();
        dfs(new StringBuilder());
        showRes();
    }

    public static void dfs(StringBuilder current)
    {
        if(current.length() == 2 * n)
        {
            res.add(new StringBuilder(current));
            return;
        }
        for(int i = 1; i < n+1; i++)
        {
            if(!visited[i-1])
            {
                current.append(i);
                current.append(" ");
                visited[i-1] = true;
                dfs(current);
                visited[i-1] = false;
                current.deleteCharAt(current.length()-1);
                current.deleteCharAt(current.length()-1);
            }
        }
    }

    public static void showRes()
    {
        for(StringBuilder s : res)
        {
            System.out.println(s);
        }
    }
}
