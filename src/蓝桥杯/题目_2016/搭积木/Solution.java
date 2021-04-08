package 蓝桥杯.题目_2016.搭积木;

import java.util.ArrayList;

// 题目
/*
小明最近喜欢搭数字积木，每个积木上面有一个数字，0-9

搭积木的规则:
每个计目放到其他两个计目的上面，并且一定比下面的两个积木的数字要小，
最后搭成4层的金字塔型，必须用完所有的积木

下面是一种合法的搭建方法:
    0
   1 2
  3 4 5
 6 7 8 9
*/
public class Solution {
    public ArrayList<Integer> tmp_res;

    public boolean[] visited;

    public int res;

    public Solution()
    {
        this.tmp_res = new ArrayList<>();
        this.visited = new boolean[10];
        this.res = 0;
    }

    public void dfs()
    {
        if(tmp_res.size() == 10)
        {
            if(check(this.tmp_res))
            {
                this.res++;
            }
            return;
        }
        for(int i = 0;i<=9;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                this.tmp_res.add(i);
                dfs();
                this.tmp_res.remove(this.tmp_res.size()-1);
                visited[i] = false;
            }
        }
    }

    public boolean check(ArrayList<Integer> arrayList)
    {
        boolean flag1 = arrayList.get(0) < arrayList.get(1) && arrayList.get(0) < arrayList.get(2);
        boolean flag2 = arrayList.get(1) < arrayList.get(3) && arrayList.get(1) < arrayList.get(4);
        boolean flag3 = arrayList.get(2) < arrayList.get(4) && arrayList.get(2) < arrayList.get(5);
        boolean flag4 = arrayList.get(3) < arrayList.get(6) && arrayList.get(3) < arrayList.get(7);
        boolean flag5 = arrayList.get(4) < arrayList.get(7) && arrayList.get(4) < arrayList.get(8);
        boolean flag6 = arrayList.get(5) < arrayList.get(8) && arrayList.get(5) < arrayList.get(9);
        return flag1 && flag2 && flag3 && flag4 && flag5 && flag6;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.dfs();
        System.out.println(solution.res);
    }
}
