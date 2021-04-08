package Recursion.acwing带分数;

import java.util.*;

public class Main{

    public static ArrayList<Integer> tmp_res;

    public static boolean[] visited;

    public static int answer;

    public static int n;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        tmp_res = new ArrayList<>();
        visited = new boolean[9];
        answer = 0;
        dfs();
        System.out.println(answer);
    }

    public static void dfs()
    {
        if(tmp_res.size() == 9)
        {
            check(new ArrayList<>(tmp_res));
            return;
        }
        for(int i = 1; i <= 9; i++)
        {
            if(!visited[i-1])
            {
                visited[i-1] = true;
                tmp_res.add(i);
                dfs();
                visited[i-1] = false;
                tmp_res.remove(tmp_res.size()-1);
            }
        }
    }


    public static void check(ArrayList<Integer> tmp_res)
    {
        // 考虑a的长度
        for(int i = 1;i <= 7;i++)
        {
            // a的数值
            int a = ArrayToInt(tmp_res,0,i);
            if(a >= n)
            {
                return;
            }
            // 考虑b的长度
            for(int j = 1;j<=8-i;j++)
            {
                int b = ArrayToInt(tmp_res,i,j);
                int c = ArrayToInt(tmp_res,i+j,9-i-j);
                if(b % c == 0 && (a + b/c) == n)
                {
                    answer++;
                }
            }
        }
    }

    public static int ArrayToInt(ArrayList<Integer> arr,int pos,int len)
    {
        int res = 0;
        int pow = 1;
        for(int i = pos+len-1;i>=pos;i--)
        {
            res += arr.get(i) * pow;
            pow *= 10;
        }
        return res;
    }
}
