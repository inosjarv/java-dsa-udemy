package io.dsa.trie;

import java.util.HashMap;
import java.util.Map;

import static io.dsa.Colors.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfString;

    TrieNode() {
        children = new HashMap<>();
        endOfString = false;
    }
}

public class Trie {
    private final TrieNode root;

    Trie() {
        root = new TrieNode();
        colorPrintln("Trie has been created!!", YELLOW);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("application");
        trie.insert("api");
        trie.search("ap");
        trie.search("application");
        trie.insert("banana");

        trie.delete("banana");
        trie.search("banana");
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            TrieNode node = current.children.get(c);
            if (node == null) {
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node;
        }
        current.endOfString = true;
        colorPrintln(word + " Successfully Inserted!!", YELLOW);
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            TrieNode node = current.children.get(c);

            if (node == null) {
                colorPrintln(word + " does not exist in Trie!!", RED);
                return false;
            }
            current = node;
        }

        if (current.endOfString) {
            colorPrintln(word + " exists in Trie!!", GREEN);
            return true;
        } else {
            colorPrintln(word + " does not exist in Trie, " + "But it is prefix of another string", RED);
        }

        return current.endOfString;
    }

    private boolean delete(TrieNode parent, String word, int index) {
        char ch = word.charAt(index);
        TrieNode current = parent.children.get(ch);
        boolean canThisNodeBeDeleted;

        if (current.children.size() > 1) {
            delete(current, word, index + 1);
            return false;
        }

        if (index == word.length() - 1) {
            if (current.children.size() >= 1) {
                current.endOfString = false;
                return false;
            } else {
                parent.children.remove(ch);
                return true;
            }
        }

        if (current.endOfString) {
            delete(current, word, index + 1);
            return false;
        }

        canThisNodeBeDeleted = delete(current, word, index + 1);
        return canThisNodeBeDeleted;
    }

    public void delete(String word) {
        if (search(word))
            delete(root, word, 0);
    }
}
