package 蓝桥杯.题目_2016.剪邮票;
import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
    // 注意以每个结点为起点进行深搜，深搜五步，是不行的
    // 因为无法解决T型问题，深搜是走的是串型。

    // 解决思路
    // 进行枚举，选择5个结点出来
    // 总共存在12个可选的结点
    public ArrayList<Integer> tmp_res_for_choose;
    public ArrayList<ArrayList<Integer>> final_res_for_choose;
    public boolean[][] testIsConnected;
    public int[][] directions;
    public int count;

    public Solution()
    {
        this.tmp_res_for_choose = new ArrayList<>();
        this.final_res_for_choose = new ArrayList<>();
        this.testIsConnected = new boolean[3][4];
        this.directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    }

    // 进行C12^5,从12个结点之中选择5个结点
    public void dfs(int index)
    {
        if(tmp_res_for_choose.size() == 5)
        {
           final_res_for_choose.add(new ArrayList<>(tmp_res_for_choose));
           return;
        }
        for(int i = index;i<=12;i++)
        {
            this.tmp_res_for_choose.add(i);
            dfs(i+1);
            this.tmp_res_for_choose.remove(this.tmp_res_for_choose.size()-1);
        }
    }

    // 使用dfs进行是否这5个点是连通图的判断
    public void fillAndTest(ArrayList<Integer> tmp)
    {
        // 将这5个点进行置为true的操作
        int i = 0;
        int j = 0;
        count = 0;
        for(int item : tmp)
        {
            i = (item-1) / 4;
            j = item - (i * 4) - 1;
            this.testIsConnected[i][j] = true;
        }
        System.out.println(judgeIfConnected(i,j));
        System.out.println(Arrays.deepToString(this.testIsConnected));


    }

    public int judgeIfConnected(int x,int y)
    {
        for(int[] direction : directions)
        {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(inArea(newX,newY) && this.testIsConnected[newX][newY])
            {
                count++;
                this.testIsConnected[newX][newY] = false;
                judgeIfConnected(newX,newY);
            }
        }
        return count;

    }

    public boolean inArea(int i,int j)
    {
        return i >= 0 && i < 3 && j >=0 && j < 4;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.dfs(1);
        solution.fillAndTest(solution.final_res_for_choose.get(0));
    }
}
