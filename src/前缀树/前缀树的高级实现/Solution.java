package 前缀树.前缀树的高级实现;

public class Solution {
    public static class TrieNode {
        // 以这个结点为止为前缀的字符串的个数 -- 也就是有多少个我们加入的字符串到达过这个接待你
        public int path;
        // 以这个结点结尾的字符串的个数 -- 也就是多少个我们加入的字符串以这个结点结尾。
        public int end;
        // 只能有26个字母，所以有26条路
        public TrieNode[] nexts;

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                // 如果没有路则建出来新的路
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                // node指向这个新建的或者已经存在的结点。
                node = node.nexts[index];
                // 到过这个结点的字符串数量++
                node.path++;
            }
            // 以这个结点结尾的字符串数量++;
            node.end++;
        }

        public void delete(String word) {
            // 存在的时候才考虑删除的问题
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    // 根据path是否变成0，决定要不要继续，
                    // 沿途都进行path--，若发现为0，则直接让这条路为空
                    if (--node.nexts[index].path == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }


        // 找到这个字符串被插入的次数
        public int search(String word)  {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            // 找到这个字符串出现的次数
            return node.end;
        }

        // 找到前缀数量。
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));

    }
}
