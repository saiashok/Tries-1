
// Time Complexity : O(n*l) or O(m*l)
// Space Complexity :  O(n*l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * 648. Replace Words
 * 
 */

import java.util.List;

public class ReplaceWords {
    TrieNode root;

    class TrieNode {
        TrieNode[] chilNodes;
        boolean isEnd;

        TrieNode() {
            this.chilNodes = new TrieNode[26];
        }

        public void insert(List<String> dicList) {

            for (String word : dicList) {
                TrieNode currNode = root; // reset currNode to root after every word.
                for (char c : word.toCharArray()) {
                    if (currNode.chilNodes[c - 'a'] == null) {
                        currNode.chilNodes[c - 'a'] = new TrieNode();
                    }
                    currNode = currNode.chilNodes[c - 'a'];
                }
                currNode.isEnd = true; // mark at end of the word

            }
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        this.root.insert(dictionary);

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            result.append(searchForShortest(word) + " "); // give a space after each word
        }

        return result.toString().trim();
    }

    private String searchForShortest(String word) {
        TrieNode currNode = this.root;
        StringBuilder result = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (currNode.chilNodes[c - 'a'] == null) {
                break; // if you don't find a children (you are one step behind, looking at children)
            }
            result.append(c);
            currNode = currNode.chilNodes[c - 'a']; // child available, so set currNode to child.
            if (currNode.isEnd) // if child has an end? return
                return result.toString();
        }

        return word;
    }
}
