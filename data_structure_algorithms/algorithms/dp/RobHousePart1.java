package com.vikas.core.leetcode.dp;

public class RobHousePart1 {
    public static void main(String[] args){
        RobHousePart1 c= new RobHousePart1();
        System.out.println(c.rob(new int[]{10,15,30}));
    }

    public int rob(int[] nums) {
        int[] rob = new int[nums.length];
        rob[0] = nums[0];
        rob[1] = Math.max(nums[0],nums[1]);
        for(int i =2;i<nums.length;i++){
            rob[i] = Math.max(rob[i-2] + nums[i], rob[i-1]);
        }
        return rob[nums.length-1];
    }
}
