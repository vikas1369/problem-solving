package com.vikas.core.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTrack(new ArrayList<>(), result, s, 0);
        return result;
    }

    private void backTrack(List<String> path, List<List<String>> result, String s, int start) {
        if(start == s.length()) {
            result.add(new ArrayList<>(path));
        }
        for(int i = start; i< s.length(); i++){
            if(isPalindrome(s, start, i)) {
                path.add(s.substring(start, i+1));

                backTrack(path, result, s, i + 1);

                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }


}
