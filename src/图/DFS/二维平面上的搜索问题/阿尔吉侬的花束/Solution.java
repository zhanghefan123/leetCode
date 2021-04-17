package 图.DFS.二维平面上的搜索问题.阿尔吉侬的花束;

import java.util.*;
class Point{
    int x;
    int y;
    public Point(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public String toString()
    {
        return x + "," + y;
    }
}
class Solution{

    public static char[][] char_matrix;

    public static Point mouse_point;

    public static int[][] distance;

    public static int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public static int m;

    public static int n;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while((count--)!=0)
        {
            m = sc.nextInt();
            n = sc.nextInt();
            sc.nextLine();
            char_matrix = new char[m][n];
            for(int i = 0;i < m ;i++)
            {
                char_matrix[i] = sc.nextLine().toCharArray();
                for(int j = 0;j < n; j++)
                {
                    if(char_matrix[i][j] == 'S')
                    {
                        mouse_point = new Point(i,j);
                    }
                }
            }
            // 开始准备进行bfs
            // 准备好我们的distance矩阵
            distance = new int[m][n];
            for(int i = 0; i < m; i++)
            {
                Arrays.fill(distance[i],-1);
            }
            int res = bfs();
            if(res == -1)
            {
                System.out.println("oop!");
            }
            else
            {
                System.out.println(res);
            }
        }
    }

    public static int bfs()
    {
        Deque<Point> queue = new LinkedList<>();
        // 将老鼠进行入队
        distance[mouse_point.x][mouse_point.y] = 0;
        queue.offerLast(mouse_point);
        while(!queue.isEmpty())
        {
            // 将队头结点丢出来
            Point head = queue.pollFirst();
            // 找到其所有的邻居结点
            for(int[] direction : directions)
            {
                int newX = head.x + direction[0];
                int newY = head.y + direction[1];
                if(inArea(newX,newY) && distance[newX][newY] == -1 && char_matrix[newX][newY]!='#')
                {
                    if(char_matrix[newX][newY] == 'E')
                    {
                        distance[newX][newY] = distance[head.x][head.y] + 1;
                        return distance[newX][newY];
                    }
                    else if(char_matrix[newX][newY] == '.')
                    {

                        distance[newX][newY] = distance[head.x][head.y] + 1;
                        queue.offerLast(new Point(newX,newY));
                    }
                    else
                    {
                        continue;
                    }
                }
            }
        }
        return -1;
    }

    public static boolean inArea(int x,int y)
    {
        boolean flag = x>=0 && x < m && y>=0 && y<n;
        return flag;
    }


}