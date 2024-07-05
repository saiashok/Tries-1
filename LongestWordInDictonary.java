
// Time Complexity : O(l)
// Space Complexity :  O(l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * 720. Longest Word in Dictionary
 * Create a TrieNode DS for the words and do a DFS paired with backtracking
 * 
 * If at any dfs you find the path.length > than the result.length update result( no return here)
 * For backtracking a StringBuilder, get the length of the stringbuilder and do the dfs and setLength to the previous length.
 */

import java.util.*;

public class LongestWordInDictonary {

    TrieNode root;

    class TrieNode {
        TrieNode[] chilNodes;
        boolean isEnd;

        TrieNode() {
            this.chilNodes = new TrieNode[26];
        }

    }

    String result = "";
    StringBuilder path;

    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.chilNodes[c - 'a'] == null) {
                curr.chilNodes[c - 'a'] = new TrieNode();
            }
            curr = curr.chilNodes[c - 'a'];
        }
        curr.isEnd = true;

    }

    public String longestWord(String[] words) {
        path = new StringBuilder();
        root = new TrieNode();
        for (String s : words) {
            insert(s);
        }

        dfs(root);

        return result;

    }

    private void dfs(TrieNode curr) {
        // base
        if (path.length() > result.length()) {
            result = path.toString();
        }

        // logic
        for (int i = 0; i < 26; i++) {
            if (curr.chilNodes[i] != null && curr.chilNodes[i].isEnd) {
                int len = path.length();
                path.append((char) ('a' + i));
                dfs(curr.chilNodes[i]);
                path.setLength(len); // backtracking
            }
        }

    }

}
