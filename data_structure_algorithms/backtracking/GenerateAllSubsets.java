package com.vikas.core.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(new ArrayList<>(), result, nums, 0);
        return result;
    }

    private void backTrack(List<Integer> path, List<List<Integer>> result, int[] nums, int index) {
        result.add(new ArrayList<>(path));
        for(int i = index;i< nums.length;i++){
            path.add(nums[i]);

            backTrack(path, result, nums, i+1);

            path.remove(path.size()-1);
        }
    }
}
