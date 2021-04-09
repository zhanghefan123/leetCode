package 蓝桥杯.题目_2020.七段码;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static HashMap<Character,HashSet<Character>> map;

    public static boolean[] visited_for_check = new boolean[7];

    public static ArrayList<Character> list = new ArrayList<>();

    public static char[] char_array = "abcdefg".toCharArray();

    public static int final_res = 0;

    public static void main(String[] args)
    {
        map = new HashMap<>();
        char[][] side = new char[][] {
                {'a','f'},{'a','b'},{'f','g'},{'b','g'},{'g','e'},{'g','c'},{'e','d'},{'c','d'},{'f','e'},{'b','c'}
        };
        for(char[] array : side)
        {
            if(!map.containsKey(array[0]))
            {
                HashSet<Character> set = new HashSet<>();
                set.add(array[1]);
                map.put(array[0],set);
            }
            else
            {
                map.get(array[0]).add(array[1]);
            }
            if(!map.containsKey(array[1]))
            {
                HashSet<Character> set = new HashSet<>();
                set.add(array[0]);
                map.put(array[1],set);
            }
            else
            {
                map.get(array[1]).add(array[0]);
            }
        }
        for(int i = 1; i <= 7; i++)
        {
            combination_dfs(i,0);
        }
        System.out.println(final_res);
    }

    public static void combination_dfs(int length, int index)
    {
        // 终止条件
        if(length == list.size())
        {
            Arrays.fill(visited_for_check,false);
            check_dfs(list.get(0));
            int tmp = 0;
            for (boolean b : visited_for_check) {
                if (b) {
                    tmp++;
                }
            }
            if(tmp == list.size())
            {
                final_res++;
            }
        }
        else
        {
            for(int i = index;i < char_array.length;i++)
            {
                list.add(char_array[i]);
                combination_dfs(length,i+1);
                list.remove(list.size()-1);
            }
        }
    }

    public static void check_dfs(char start)
    {
        visited_for_check[start-'a'] = true;
        // 遍历所有邻居节点
        HashSet<Character> neighbours = map.get(start);
        for(char neighbour : neighbours)
        {
            if(!visited_for_check[neighbour-'a'] && list.contains(neighbour))
            {
                check_dfs(neighbour);
            }
        }
    }
}
