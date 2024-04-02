package com.vikas.core.leetcode.tries;

public class ImplementPrefixTree {

}

class Trie {
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(char character: chars){
            if(!node.containsNode(character)){
                TrieNode t = new TrieNode();
                node.setNode(character, t);
                //continue;
            }
            node = node.getNode(character);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(char character: chars){
            if(node.containsNode(character)){
                node = node.getNode(character);
                continue;
            }
            return false;
        }
        return node.getEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] chars = prefix.toCharArray();
        for(char character: chars){
            if(node.containsNode(character)){
                node = node.getNode(character);
                continue;
            }
            return false;
        }
        return node!=null;
    }
}

class TrieNode{
    TrieNode[] links;
    boolean isEnd;

    TrieNode(){
        links = new TrieNode[26];
        isEnd = false;
    }

    void setNode(char ch, TrieNode node){
        links[ch-'a'] = node;
    }

    boolean containsNode(char ch){
        return links[ch-'a']!=null;
    }

    TrieNode getNode(char ch){
        return links[ch-'a'];
    }

    void setEnd(){
        this.isEnd = true;
    }

    boolean getEnd(){
        return isEnd;
    }
}
