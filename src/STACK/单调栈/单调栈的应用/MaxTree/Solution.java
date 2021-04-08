package STACK.单调栈.单调栈的应用.MaxTree;
// 构造数组的MaxTree

// 定义二叉树的结点如下

import java.util.HashMap;
import java.util.Stack;

class Node{
    public int value;
    public Node left;
    public Node right;
    public Node(int data)
    {
        this.value = data;
    }
}

// 一个数组的MaxTree的定义如下
/*
数组必须没有重复元素，MaxTree是一棵二叉树，数组的每一个值对应一个
二叉树的结点，包括MaxTree树在内且 在其中的每一棵子树上，值最大的结点
都是树的头。时间复杂度为O(N)
* */

// 思路1:
/* 建立大根堆的时间复杂度为O(N)*/

// 思路2:
/* 单调栈
首先通过单调栈找到左边离他最近的比他大的数
以及找到右边离他最近的比他大的数，然后按照下面的例子进行挂点

例子: 3 2 4 1 0 5
    左   右
3   无   4
2   3   4
4   无   5
1   4   5
0   1   5
5   无   无

规则:
rule1: 两边都没有的为最大值
rule2: 左边无，右边有的，本结点挂在右侧结点之下
rule3: 右边无，左边有的，本结点挂在左侧结点之下
rule4: 左边有，右边有的，本结点挂在较小的结点之下

* */

public class Solution {
    public static Node getMaxTree(int[] arr)
    {
        // 可用的结点数组
        Node[] nArr = new Node[arr.length];
        for(int i = 0;i < arr.length;i++)
        {
            nArr[i] = new Node(arr[i]);
        }
        // 单调栈
        Stack<Node> stack = new Stack<>();
        HashMap<Node,Node> lBigMap = new HashMap<>();
        HashMap<Node,Node> rBigMap = new HashMap<>();
        for(int i = 0; i < nArr.length;i++)
        {
            Node curNode = nArr[i];
            while(!stack.isEmpty() && stack.peek().value < curNode.value)
            {
                popStackAndSetMap(stack,lBigMap);
            }
            stack.push(curNode);
        }
        while(!stack.isEmpty())
        {
            popStackAndSetMap(stack,lBigMap);
        }
        return null;
    }

    public static void popStackAndSetMap(Stack<Node> stack,HashMap<Node,Node> map )
    {

    }
}
