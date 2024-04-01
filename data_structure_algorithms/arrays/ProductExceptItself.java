package com.vikas.core.leetcode.arrays;

import java.util.Arrays;

public class ProductExceptItself {
    public static void main(String[] args){

    }

    public int[] productExceptSelf(int[] nums) {
        int prefixMul = 1;
        int suffixMul = 1;
        int[] sum = new int[nums.length];
        Arrays.fill(sum, 1);
        for(int i = 1;i<nums.length;i++){
            prefixMul = prefixMul * nums[i-1];
            sum[i] *= prefixMul;
        }

        for(int i = nums.length-2; i>=0 ;i--){
            suffixMul = suffixMul * nums[i+1];
            sum[i] *= suffixMul;
        }
        return sum;
    }
}
