package bogglesolver;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private final TrieNode root;

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }
    
    public Dictionary(String[] words) {
        root = new TrieNode();
        for (String word: words) {
            insert(word);
        }
    }

    public boolean startsWith(String prefix) {
        TrieNode node = search(prefix);
        boolean startsWith = (node != null);
        debug("startsWith " + prefix + " - " + startsWith);
        return startsWith;
    }

    public boolean contains(String str) {
        TrieNode node = search(str);
        boolean contains = (node != null && node.endOfWord);
        debug("Contains " + str + " - " + contains);
        return contains;
    }
    
    private void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    private TrieNode search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return node;
            }
            current = node;
        }
        return current;
    }

    private void debug(String string) {
        //used for debugging only, disabled by default
        debug(string, false);
    }
    
    private void debug(String string, boolean isDebugEnabled) {
        if (! isDebugEnabled) {
            return;
        }
        System.out.println(string);
    }
}