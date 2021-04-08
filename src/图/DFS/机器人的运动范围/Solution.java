package 图.DFS.机器人的运动范围;

public class Solution {
    public int count;
    public int m;
    public int n;
    public int[][] directions;
    public boolean[][] visited;
    public int k;

    public int movingCount(int m, int n, int k) {
        this.k = k;
        this.count = 0;
        this.m = m;
        this.n = n;
        this.directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        this.visited = new boolean[m][n];
        dfs(0,0);
        return count;

    }

    public void dfs(int i,int j)
    {
        if(getSum(i,j)<= k)
        {
            count++;
            visited[i][j] = true;
            int newX;
            int newY;
            for(int[] direction : directions)
            {
                newX = i + direction[0];
                newY = j + direction[1];
                if(inArea(newX,newY)&&!visited[newX][newY])
                {
                    dfs(newX,newY);
                }
            }
        }

    }

    public boolean inArea(int i,int j)
    {
        return i>=0 && j >=0 && i<=m-1 && j<=n-1;
    }

    public int getSum(int i, int j)
    {
        int sum = 0;
        while(i>0)
        {
            sum += i % 10;
            i = i/10;
        }
        while(j>0)
        {
            sum += j % 10;
            j = j/10;
        }
        return sum;
    }
}
