package 动态规划.博弈型动态规划.cardsInALine;
// 题目--排成一条线的纸牌博弈问题
/*
给定一个整型数组arr,代表数值不同的纸牌拍成一条线，玩家A和玩家B依次拿走每张纸牌
给定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或者最右侧的纸牌，玩家A和
玩家B都是聪明绝顶的人，请返回最后获胜者所得到的分数总和,(得分多的人获胜)
* */
public class Solution {
    public static int win1(int [] arr)
    {
        if(arr == null || arr.length == 0)
        {
            return 0;
        }
        // 返回先手的人在0-(arr.length-1)上的得分，以及后手的人在0-(arr.length-1)上的得分
        // 哪个人得分更多
        return Math.max(first(arr,0,arr.length-1),second(arr,0,arr.length-1));
    }

    // 先手的策略
    public static int first(int[] arr,int i,int j)
    {
        if(i == j)
        {
            return arr[i];
        }
        // 先手的人会走出让自己的值最大的一步，然后先手变为后手，面对剩下的棋局。
        return Math.max(arr[i] + second(arr,i+1,j),arr[j] + second(arr,i,j-1));
    }


    // 后手的策略
    public static int second(int [] arr,int i,int j)
    {
        if(i == j)
        {
            return 0;
        }
        // 先手肯定会走出让后手最难受的一步
        return Math.min(first(arr,i+1,j),first(arr,i,j-1));
    }

    // 填充规则
    // 创建两个dp二维数组进行填充即可.
    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 9, 1 };
        System.out.println(win1(arr));
        System.out.println(win2(arr));

    }
}
