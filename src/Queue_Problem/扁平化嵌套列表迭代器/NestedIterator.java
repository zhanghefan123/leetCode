package Queue_Problem.扁平化嵌套列表迭代器;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

interface NestedInteger {
             // @return true if this NestedInteger holds a single integer, rather than a nested list.
             public boolean isInteger();

             // @return the single integer that this NestedInteger holds, if it holds a single integer
             // Return null if this NestedInteger holds a nested list
            public Integer getInteger();

             // @return the nested list that this NestedInteger holds, if it holds a nested list
             // Return null if this NestedInteger holds a single integer
             public List<NestedInteger> getList();
 }
public class NestedIterator implements Iterator<Integer> {

    public Deque<Integer> cache;
    public List<NestedInteger> copy_list;
    public int count;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.cache = new LinkedList<>();
        this.copy_list = nestedList;
        this.count = 0;
    }

    @Override
    public Integer next() {

        // 将队列之中的数据弹出并返回
        return cache.pollFirst();

    }

    public void dfs(NestedInteger item)
    {
        // base case
        if(item.isInteger())
        {
            cache.offerLast(item.getInteger());
            return;
        }
        else{
            List<NestedInteger> list = item.getList();
            if(list.size() == 0)
            {
                return;
            }
            for(NestedInteger tmp : list)
            {
                dfs(tmp);
            }
        }
    }

    @Override
    public boolean hasNext() {
        // count没到末尾，且队列非空
        if(!cache.isEmpty())
        {
            return true;
        }
        else if(count != this.copy_list.size() && cache.isEmpty())
        {
            while(count != this.copy_list.size() && cache.isEmpty())
            {
                dfs(this.copy_list.get(count));
                count++;
            }
            if(!cache.isEmpty())
            {
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
