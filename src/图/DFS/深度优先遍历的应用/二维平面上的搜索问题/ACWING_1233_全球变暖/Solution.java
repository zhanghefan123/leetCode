package 图.DFS.深度优先遍历的应用.二维平面上的搜索问题.ACWING_1233_全球变暖;

import java.util.*;
class Main{

    public static boolean[][] visited;

    public static char[][] grid;

    public static int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public static int N;

    public static boolean dfs(int i,int j)
    {
        boolean flag = false;
        visited[i][j] = true;
        if(!sinkedOrNot(i,j))
        {
            flag = true;
        }
        for(int[] direction : directions)
        {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if(inArea(newX,newY) && !visited[newX][newY] && grid[newX][newY] == '#')
            {
                boolean flag_inner = dfs(newX,newY);
                flag = flag || flag_inner;
            }
        }
        return flag;
    }


    // 若返回true代表会沉没
    // 若返回false代表不会沉没
    public static boolean sinkedOrNot(int i,int j)
    {

        for(int [] direction : directions)
        {
            int newX = i + direction[0];
            int newY = j + direction[1];
            // 代表会被淹没
            if(inArea(newX,newY) && grid[newX][newY] == '.')
            {
                return true;
            }
        }
        return false;
    }

    public static boolean inArea(int i,int j)
    {
        return i>=0 && i < N && j>=0 && j<N;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        visited = new boolean[N][N];
        grid = new char[N][N];
        // 将grid进行读入
        for(int i = 0;i<N;i++)
        {
            grid[i] = sc.nextLine().toCharArray();
        }
        int count = 0;
        for(int i = 0; i < N; i++)
        {
            for(int j = 0;j<N;j++)
            {
                if(!visited[i][j] && grid[i][j] == '#')
                {
                    if(!dfs(i,j))
                    {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

}
