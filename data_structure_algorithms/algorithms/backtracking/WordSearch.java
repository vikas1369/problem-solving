package com.vikas.core.leetcode.backtracking;

public class WordSearch {
    public static void main(String[] args){

    }
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i =0;i< board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0) == board[i][j] & search(board, word, 0, i, j, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    boolean search(char[][] board, String word, int index, int i, int j, boolean[][] visited){
        if(index == word.length()){
            return true;
        }

        if(i < 0 || i>= board.length || j < 0 || j>= board[0].length || board[i][j]!=word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(search(board, word, index+1, i-1, j, visited) ||
        search(board, word, index+1, i+1, j, visited) ||
        search(board, word, index+1, i, j+1, visited) ||
        search(board, word, index+1, i, j-1, visited)){
            return true;
        }

        visited[i][j] = false;

        return false;

    }
}
