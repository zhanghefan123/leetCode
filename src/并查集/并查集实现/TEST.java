package 并查集.并查集实现;

import java.util.HashMap;
import java.util.List;

//并查集可以实现的功能
/*
* 1.要非常快的检查两个元素是否在同属于一个集合之中。 isSameSet(A,B)
* 2.两个元素各自所在的集合合并在一起。 union(A,B)将A所在的所有集合和B所在的所有集合合并在一起
* */

//算法的优化
//1.查找代表结点的过程之中的沿途的所有结点将它的所有父结点打扁平。

public class TEST {
    public static class Node {
        // whatever you like
    }

    public static class UnionFindSet {

        //前面的Node表示的是当前结点，后一个Node表示的是当前结点的父结点
        //这个fatherMap就是我们向上进行寻找的根据
        public HashMap<Node, Node> fatherMap;

        //表示某一个结点所在的集合一共存在多少个结点
        public HashMap<Node, Integer> sizeMap;

        public UnionFindSet(List<Node> nodes) {
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
            makeSets(nodes);
        }

        //使用用户提供的结点对两个集合进行初始化
        public void makeSets(List<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                //每一个node自己形成一个集合，父结点是自身，成环。
                fatherMap.put(node, node);
                //这个结点的所在的集合初始只有自己，所以为1
                sizeMap.put(node, 1);
            }
        }

        //寻找头结点，即代表结点
        private Node findHead(Node node) {
            Node father = fatherMap.get(node);//找出用户给定结点的父亲结点
            //如果父亲结点不等于自身--则说明不是代表结点，则继续进行查找
            if (father != node) {
                father = findHead(father);
            }
            // 优化操作，将查到的结点全部直连代表结点。
            fatherMap.put(node, father);//将查找路径上的结点变得扁平
            return father;
        }


        //算法思想
        //一开始每一个结点的指针指向自己，说明每一个结点都是本集合的代表结点
        //然后随着合并的情形发生，需要合并的结点做为代表结点的子结点，这样的情况下
        //我们如果想要判断两个结点是否属于同一个集合只需要两个结点找到它们的代表结点并且
        //判断它们的代表结点是否是同一个即可

        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }


        //若要根据两个结点，合并他们两个所在的集合，我们需要找到它们各自的代表结点，选取元素多的
        //合并元素少的集合，即为将少元素的集合挂在多元素的集合的代表元素的下面。
        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) {
                int aSetSize= sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }

    }

    public static void main(String[] args) {

    }
}
