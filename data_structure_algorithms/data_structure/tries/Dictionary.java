package com.vikas.core.leetcode.tries;

public class Dictionary {
}

class WordDictionary {

    public static void main(String[] args){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        //wordDictionary.search("pad"); // return False
        //.search("bad"); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        wordDictionary.search("b.."); // return True
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return searchHelper(word, root);
    }

    public boolean searchHelper(String word, TrieNode root) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(int i = 0;i< chars.length;i++){
            char character = chars[i];
            if(character == '.'){
                for(TrieNode trieNode:node.links){
                    if(trieNode!=null && searchHelper(word.substring(i+1), trieNode)) return true;
                }
                return false;
            }
            if(node.containsNode(character)){
                node = node.getNode(character);
                continue;
            }
            return false;
        }
        return node.getEnd();
    }

}


