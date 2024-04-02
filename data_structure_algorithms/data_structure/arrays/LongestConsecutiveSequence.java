package com.vikas.core.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args){

    }
    public int longestConsecutive(int[] nums) {
        int longestStreak = 1;
        if(nums==null || nums.length ==0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for(int num:nums){
            if(!set.contains(num-1)){
                int currentStreak = 1;
                int currentNum = num;

                while(set.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                    longestStreak = Math.max(longestStreak, currentStreak);
                }

            }
        }
        return longestStreak;
    }
}
