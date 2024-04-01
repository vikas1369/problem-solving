package com.vikas.core.leetcode.dp;

public class Climbingstrairscost {
    public static void main(String[] args){
        Climbingstrairscost c= new Climbingstrairscost();
        System.out.println(c.minCostClimbingStairs(new int[]{10,15,30}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (n<=2) return Math.min(first, second);
        for (int i=2; i<n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }
}
