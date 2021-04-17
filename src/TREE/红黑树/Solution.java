package TREE.红黑树;



import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args)
    {
        // TreeSet,TreeMap底层是红黑树,只是key的部分参与排序，我们可以粗浅的将红黑树理解为平衡搜索二叉树只是
        // 平衡要求没有平衡搜索二叉树那么高，因此不需要更多次的调整。
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(10);
        treeSet.add(15);
        treeSet.add(20);
        // 查看某个key是否存在
        System.out.println(treeSet.contains(5));

        // TreeMap只有key参与排序，value不参与排序
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(5,"zhang");
        treeMap.put(10,"he");
        treeMap.put(15,"fan");
        treeMap.put(20,"yao");
        treeMap.put(25,"laowang");
        // 查看某个key是否存在
        System.out.println(treeMap.containsKey(5));
        // 根据键来进行值得获取，在HashMap之中时间复杂度O(1)，在TreeMap之中时间复杂度O(logn)

        // 返回最小的key,时间复杂度O(logn)
        System.out.println(treeMap.firstKey());
        // 返回最大的key,时间复杂度O(logn)
        System.out.println(treeMap.lastKey());
        // 返回最大的键值对
        System.out.println(treeMap.lastEntry().getKey());
        System.out.println(treeMap.lastEntry().getValue());
        // 在整棵树之中找到刚比传入的数值大的key
        System.out.println(treeMap.ceilingKey(21));
        // 在整棵树之中找到刚比传入的数值大的entry
        System.out.println(treeMap.ceilingEntry(21));
        // 在整棵树之中找到刚比传入的数值小的key
        System.out.println(treeMap.floorKey(12));
        // 在整棵树之中找到刚比传入的数值小的entry
        System.out.println(treeMap.floorEntry(12));
        HashSet<Integer> tmp = new HashSet<>();
    }
}
