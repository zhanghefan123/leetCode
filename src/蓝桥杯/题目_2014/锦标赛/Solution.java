package 蓝桥杯.题目_2014.锦标赛;
// 锦标赛 -- 代码填空问题
/*
如果要在n个数据中挑选出第一大和第二大的数据(要求输出数据所在的位置和值)，使用什么方法比较的次数最小
我们可以从体育锦标赛之中受到启发

如图[1.png]所示，8个选手的锦标赛，先两两捉对厮杀，淘汰一半，优胜者再进行两两比拼，直到决出第一名
第一名输出后，只要对黄色标是否能的位置重新比赛即可，也就是说被冠军淘汰的拥有重新再比赛的权力。
下面的代码实现了这个算法(假设数据中没有相同值)


代码中需要用一个数组来表示图中的数(注意这个是满二叉树，不足需要进行补齐)
他不是存储数据本身，而是存储数据的下表
第一个数据输出后。他所在的位置被标识为-1

* */
public class Solution {

    public static void main(String[] args) {
        // 原始数据
        int[] a = {1,8,22,15,3,6,12,13};
        // 输出最大，次大元素的位置以及值
        pick(a);

    }

    //a 表示待处理的数据，长度如果不是2的次幂，则不足位置补为-1
    static void pick(int[] a){
        int n = 1;
        while(n<a.length)
            n *= 2;

        int[] b = new int[2*n-1];
        for(int i=0; i<n; i++){
            if(i<a.length)
                b[n-1+i] = i;
            else
                b[n-1+i] = -1;
        }

        //从最后一个向前处理
        for(int i=b.length-1; i>0; i-=2){
            if(b[i]<0){
                if(b[i-1]>=0)
                    b[(i-1)/2] = b[i-1];
                else
                    b[(i-1)/2] = -1;
            }else{
                if(a[b[i]]>a[b[i-1]])
                    b[(i-1)/2] = b[i];
                else
                    b[(i-1)/2] = b[i-1];
            }
        }

        //输出树根
        System.out.println(b[0] + ": " + a[b[0]]);

        //值等于根元素的位置需要重新pk
        pk(a,b,0,b[0]);

        //再次输出树根
        System.out.println(b[0] + ": " + a[b[0]]);
    }


    // a 就是数组，b 二叉树，k 当前要重新比拼的位置，v 已经决胜出的值
    static void pk(int[] a, int[] b, int k, int v){

        // k的左子下标
        int k1 = k*2+1;
        // k的右子下标
        int k2 = k1 + 1;


        if(k1>=b.length || k2>=b.length){
            b[k] = -1;
            return;
        }

        // 如果左子等于这个下标，那么向右侧递归
        if(b[k1]==v)
            pk(a,b,k1,v);
        // 如果右子等于这个下标，那么向左侧进行递归
        else
            pk(a,b,k2,v);


        //重新比较
        if(b[k1]<0){
            if(b[k2]>=0)
                b[k] = b[k2];
            else
                b[k] = -1;
            return;
        }

        if(b[k2]<0){
            if(b[k1]>=0)
                b[k] = b[k1];
            else
                b[k] = -1;
            return;
        }

        if(a[b[k1]]>a[b[k2]])  //填空
            b[k] = b[k1];
        else
            b[k] = b[k2];
    }
}
