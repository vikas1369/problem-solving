package com.vikas.core.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args){

    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for(int right=0; right<s.length();right++){
            while(!set.add(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            max = Math.max(max, right - left+1);
        }
        return max;
    }
}
