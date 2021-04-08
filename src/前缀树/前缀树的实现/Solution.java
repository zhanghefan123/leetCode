package 前缀树.前缀树的实现;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class TrieNode {
        // 原来是否添加过这个字符串，如果添加过这个字符串，那么isWord为true
        // 从根结点抵达这里组成的字母序列是否构成一个单词
        public boolean isWord;
        // 键是字母，值是结点。
        public Map<Character, TrieNode> childrenMap = new HashMap<>();
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Solution() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null){
                // insert a new node if the path does not exist
                cur.childrenMap.put(c, new TrieNode());
            }
            cur = cur.childrenMap.get(c);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    // 返回这棵前缀树之中是否有前缀prefix
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0;i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return true;
    }
}
