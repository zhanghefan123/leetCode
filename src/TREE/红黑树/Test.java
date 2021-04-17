package TREE.红黑树;

import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> map  = new TreeMap<>();
        map.put(15,1);
        map.put(13,1);
        map.put(11,1);
        System.out.println(map.floorKey(12));
        System.out.println(map.ceilingKey(14));
    }
}
