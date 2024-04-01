package com.vikas.core.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(new ArrayList<>(), result, candidates, 0, target);
        return result;
    }

    private void backTrack(List<Integer> path, List<List<Integer>> result, int[] nums, int index, int target) {
        if(target<0){
            return;
        }
        else if(target == 0) {
            result.add(new ArrayList<>(path));
        }
        else {
            for (int i = index; i < nums.length; i++) {
                path.add(nums[i]);

                backTrack(path, result, nums, i , target- nums[i]);

                path.remove(path.size() - 1);
            }
        }
    }
}
