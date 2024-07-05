
// Time Complexity : O(l)
// Space Complexity :  O(l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
208. Implement Trie (Prefix Tree)
 * 
 */

public class Trie {

    TrieNode root;

    class TrieNode {
        TrieNode[] chilNodes;
        boolean isEnd;

        TrieNode() {
            this.chilNodes = new TrieNode[26];
        }

    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (curr.chilNodes[c - 'a'] == null) {
                curr.chilNodes[c - 'a'] = new TrieNode();
            }
            curr = curr.chilNodes[c - 'a'];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (curr.chilNodes[c - 'a'] == null)
                return false;

            curr = curr.chilNodes[c - 'a'];
        }

        return curr.isEnd;

    }

    public boolean startsWith(String prefix) {

        TrieNode curr = root;

        for (char c : prefix.toCharArray()) {
            if (curr.chilNodes[c - 'a'] == null) {
                return false;
            }
            curr = curr.chilNodes[c - 'a'];
        }

        return true;

    }
}
