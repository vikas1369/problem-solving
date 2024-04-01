package com.vikas.core.leetcode.greedy;

public class JumpGame {
    public static void main(String[] args){

    }

    public boolean canJump(int[] nums) {
        int current = 0;
        for(int i =0;i<nums.length;i++){
            if(i> current)
                return  false;
            current = Math.max(current, i + nums[i]);
        }
        return true;
    }
}
