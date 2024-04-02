package com.vikas.core.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(new ArrayList<>(), result, nums);
        return result;
    }

    private void backTrack(List<Integer> permutations, List<List<Integer>> result, int[] nums) {
        if(permutations.size()== nums.length) {
            result.add(new ArrayList<>(permutations));
        }
        for(int i = 0;i< nums.length;i++){
            if(permutations.contains(nums[i])){
                continue;
            }
            permutations.add(nums[i]);

            backTrack(permutations, result, nums);

            permutations.remove(permutations.size()-1);
        }
    }
}
