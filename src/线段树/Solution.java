package 线段树;

import java.util.*;

class Node{
    int left;
    int right;
    int sum;

    public Node(){

    }

    public Node(int left,int right,int sum)
    {
        this.left = left;
        this.right = right;
        this.sum = sum;
    }



    public Node(int left,int right)
    {
        this.left = left;
        this.right = right;
    }

    public String toString()
    {
        return "左:" + left + " 右:" + right + " 总和:" + sum;
    }
}

class Main{

    public static Node[] segment_tree;

    public static int[] array;

    // 使用子结点的信息将父结点的信息进行更新
    public static void pushup(int u)
    {
        // 左儿子的和和右儿子的和等于儿子
        segment_tree[u].sum = segment_tree[u * 2].sum + segment_tree[u * 2 + 1].sum;
    }

    // 进行线段树的构建
    // u是根节点，left是当前结点的左边界，right是当前结点的右边界
    public static void build(int u,int left,int right)
    {
        // 如果是叶子结点的情况
        if(left == right)
        {
            segment_tree[u] = new Node(left,right,array[right]);
        }
        // 如果是非叶子结点的情况
        else
        {
            segment_tree[u] = new Node(left,right);
            // [1,7] mid = 4
            int mid = (left + right) / 2;
            // build[1,4] 进行左子树的构建
            build(u * 2, left, mid);
            // build[5,7] 进行右子树的构建
            build(u * 2 + 1,mid+1,right);
            // 将两棵子树的信息向上传递
            pushup(u);
        }
    }

    // u是根结点的编号,l是查询的左边界，r是查询的右边界
    public static int query(int u, int left, int right)
    {
        // 如果当前遍历到的u所代表的区间被left_right所包含了则直接加掉。
        if(segment_tree[u].left >= left && segment_tree[u].right <= right)
        {
            return segment_tree[u].sum;
        }
        int mid = (segment_tree[u].left + segment_tree[u].right) / 2;
        int sum = 0;
        if(left <= mid) sum += query(u * 2,left,right);
        if(right > mid) sum += query(u * 2 + 1,left,right);
        return sum;
    }

    public static void modify(int u,int x,int v)
    {
        // 如果是到了叶节点，则直接更改就好。
        if(segment_tree[u].left == segment_tree[u].right)
        {
            segment_tree[u].sum += v;
        }
        else
        {
            int mid = (segment_tree[u].left + segment_tree[u].right) / 2;
            // 如果是在线段树的左子
            if(x <= mid){
                modify(u * 2,x,v);
            }
            // 如果是在线段树的右子
            else
            {
                modify(u * 2 + 1,x,v);
            }
            pushup(u);
        }
    }

    // 单点修改过程

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // 总共存在N个数
        int N = sc.nextInt();
        // 总共存在K次询问或者插入
        int K = sc.nextInt();
        array = new int[N+1];
        segment_tree = new Node[4 * N];
        for(int i = 1;i <= N; i++)
        {
            array[i] = sc.nextInt();
        }
        build(1,1,N);
        for(int i = 0;i < K; i++)
        {
            int k = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(k == 0)
            {
                System.out.println(query(1,a,b));
            }
            else
            {
                modify(1,a,b);
            }
        }
    }
}