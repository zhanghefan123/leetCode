package HASH.手动实现哈希表;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

    public ArrayList<LinkedList<Integer>> list;

    public int length;

    /** Initialize your data structure here. */
    public Solution() {
        this.list = new ArrayList<>();
        this.length = 800;
        for(int i = 0; i < this.length; i++)
        {
            this.list.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        if(!contains(key))
        {
            int position = key % this.length;
            list.get(position).add(key);
        }
        else
        {
            return;
        }
    }

    public void remove(int key) {
        if(!contains(key))
        {
            return;
        }
        else{
            int position = key % this.length;
            list.get(position).remove(new Integer(key));
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int position = key % this.length;
        return list.get(position).contains(key);
    }
}