package 动态规划.博弈型动态规划.石子游戏;
// 递归方式解决石子游戏问题
// 缺点:仅仅适用于解决极小的数据量，面对大量的数据就会崩溃
public class Solution {
    public int[] piles;

    public boolean stoneGame(int[] piles) {
        this.piles = piles;
        int first_res = first(0,piles.length-1);
        int second_res = second(0,piles.length-1);
        return first_res > second_res;
    }

    public int first(int i,int j)
    {
        if(i == j)
        {
            return piles[i];
        }
        // 因为堆数是偶数，所以终止的时候会出现这种base_case
        return Math.max((piles[i] + second(i+1,j)),(piles[j] + second(i,j-1)));
    }

    public int second(int i,int j)
    {
        if(i == j)
        {
            return 0;
        }
        // 当我是后手，好的肯定已经被选走了
        // 因为我是后手，对方是先手，对方会从i-j之中选择i或者选择j,留给我的肯定是最差的局面
        // 我作为先手面对的局面就是[i+1,j]或者[i,j-1]之中得分最低的那种
        return Math.min(first(i+1,j),first(i,j-1));
    }
}
