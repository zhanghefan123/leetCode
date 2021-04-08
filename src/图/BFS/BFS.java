package 图.BFS;
//注意图的BFS和树的BFS的区别，我们需要进行一个HashSet的维护，
// 如果HashSet中包含了这个元素即这个元素进入过这个队列之中，
// 如果进入过则不再进行进入。


import java.util.*;

public class BFS {



}

//由于我们需要找到一个结点的所有的邻居
//所以我们需要思考，如何将二维数组--邻接矩阵，
//转换为邻接表，邻接表可以方便的找到邻居结点
class Node{                //无论是表结点还是头结点都是用同一个类即可
    String data;            //数据域
    Node next;              //相当于指针域，指向下一个结点

    public void head(Node newnode) {      //前插方式
        newnode.next = this.next;		 //要插入的结点的下一个结点指向调用该函数的头结点的原本的下一个结点
        this.next = newnode;          //将头结点的下一个结点指向要插入的结点
    }

    public void tail(Node newnode) {      //后插方式
        Node test = this;              //新建一个结点指向调用该函数的头结点
        while(true) {
            if(test.next == null) {      //如果test结点没有下一个结点
                test.next = newnode;     //将要插入的结点插入到该test结点后
                break;                 	 //然后退出循环
            }
            else
                test = test.next;        //如果test结点有下一个结点，将test等于test的下一个结点
        }
    }

    public void printlist() {              //输出邻接表
        Node test = this;                   //新建一个test结点，指向调用该函数的头结点
        System.out.print(test.data + " ");      //输出该头结点的数据域（+""使为了使得test的数据域转换为String类型）
        while((test = test.next) != null) {     //使test等于test的下一个结点（这样就算条件不成立，test还可以一直更新）
            System.out.print(test.data + " ");   	//若test不为空，输出test的数据域
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(data, node.data) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }
}
class Adjacency_list_right {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        int[][] adjMatrix = new int[][]{{0,1,0,1,0,0,0,0},
                {1,0,1,0,0,0,0,0},
                {0,1,0,1,1,0,0,0},
                {1,0,1,0,0,0,0,0},
                {0,0,1,0,0,1,1,0},
                {0,0,0,0,1,0,0,1},
                {0,0,0,0,1,0,0,1},
                {0,0,0,0,0,1,1,0}};
        Node[] AdjList = new Node[adjMatrix.length];      //创建头结点数组
        for(int i = 0; i < adjMatrix.length; i++) {              //头结点初始化
            AdjList[i] = new Node();
            AdjList[i].data = "V" + (i + 1);//每个结点为V1,V2……
            AdjList[i].next = null;
        }
        System.out.print("请选择插入方式（1：前插；2：后插）：");   //选择插入方式
        //链表头插法会导致反向，链表尾插法是正序。
        int choice = input.nextInt();
        input.close();

        int i = 0, j = 0;
        for(i = 0; i < adjMatrix.length; i++) {
            for(j = 0; j < adjMatrix.length; j++) {
                //如果第i号结点和第j号结点之间存在一条边，此处存储的是有向图，即从i索引结点指向j索引结点的一条边。
                if(adjMatrix[i][j] == 1) {      //如果邻接矩阵中元素为1，则说明i与j相应的结点邻接
                    Node newnode = new Node();
                    newnode.data = j + "";
                    if(choice == 1)
                        AdjList[i].head(newnode);
                    else
                        AdjList[i].tail(newnode);
                }
            }
            System.out.print(i + " ");
            AdjList[i].printlist();
        }
    }
}