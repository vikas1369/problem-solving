package com.vikas.core.leetcode.stack;

import java.util.Stack;

/*
https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemparatures {
    public static void main(String[] args){

    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i< temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int j = stack.pop();
                result[j] = i-j;
            }
            stack.push(i);
        }
        return result;
    }
}
