package com.vikas.core.leetcode.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args){

    }
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;
        while(left < right){
            int currentArea = Math.min(height[left], height[right]) * Math.abs(left-right);
            maxArea = Math.max(maxArea, currentArea);
            if(height[left] < height[right]){
                left++;
            }else{
                right++;
            }
        }
        return  maxArea;
    }
}
