package com.vikas.core.leetcode.linkedlist;

public class FloyydCycleDetection {
    public static void main(String[] args){

    }

    public int getRepeatedNumber(int[] num){
        int fast = num[0];
        int slow = num[0];
        while(slow!=fast){
            slow = num[slow];
            fast = num[num[fast]];
        }

        slow = num[0];
        while(slow!=fast){
            slow = num[slow];
            fast = num[fast];
        }

        return slow;
    }
}
