package HASH;
//设计一种结构，在该结构中存在如下三个功能，
//insert(key),将某个key加入到该结构,做到不重复插入
//delete(key),将原本在结构中的某个key进行删除，getRandom()等概率随机返回结构中的任何一个key
//getRandom()，等概率随机返回结构中的任何一个key

import java.util.HashMap;

//算法思想
/*
准备两张hash表，准备一个size变量，当第一个数进来的时候
第一张hashTable中的内容 第二张hashTable中的内容
key value                key value
 A    0                   0    A
 B    1                   1    B
 //当我们需要进行getRandom的时候Math.random*size即可
*/
public class RandomPool {
    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool() {
            this.keyIndexMap = new HashMap<K, Integer>();
            this.indexKeyMap = new HashMap<Integer, K>();
            this.size = 0;
        }

        public void insert(K key) {
            //保证不重复插入
            if (!this.keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key, this.size);
                this.indexKeyMap.put(this.size++, key);
            }
        }

        //删除的过程之中可能会产生洞，这个时候我们将最后一条记录移到要删除的记录上，
        //并且进行修改最后一条记录的value，并且在第二个hash表之中修改key
        public void delete(K key) {
            if (this.keyIndexMap.containsKey(key)) {
                int deleteIndex = this.keyIndexMap.get(key);
                int lastIndex = --this.size;
                K lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey, deleteIndex);
                this.indexKeyMap.put(deleteIndex, lastKey);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }
        }

        public K getRandom() {
            if (this.size == 0) {
                return null;
            }
            int randomIndex = (int) (Math.random() * this.size); // 0 ~ size -1
            return this.indexKeyMap.get(randomIndex);
        }

    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }

}
