package com.vikas.core.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationDigits {
    public static void main(String[] args){

    }

    public List<String> letterCombinations(String digits) {
        List<String> solution = new ArrayList<>();
        String[] phoneMap = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.isEmpty())
            return solution;
        backTrack(digits, solution,phoneMap, "");
        return  solution;
    }

    private void backTrack(String nextDigits, List<String> solution, String[] phoneMap, String combination) {
        if(nextDigits.isEmpty()){
            solution.add(combination);
        }else{
            String letters = phoneMap[nextDigits.charAt(0)-'2'];
            for(char letter: letters.toCharArray()){
                backTrack(nextDigits.substring(1), solution, phoneMap, combination+letter);
            }
        }
    }
}
