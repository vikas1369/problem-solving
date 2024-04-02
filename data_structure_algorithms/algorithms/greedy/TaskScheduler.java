package com.vikas.core.leetcode.greedy;

import java.util.Arrays;

public class TaskScheduler {
    public static void main(String[] args){
        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B'}, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        for(int i =0;i<tasks.length;i++){
            counter[tasks[i]-'A']++;
        }

        Arrays.sort(counter);

        int maxFreq = counter[25]-1;
        int idleSlots = n * maxFreq;

        for(int i =24;i>=0 && counter[i]>0;i--){
            idleSlots = idleSlots - Math.min(counter[i], maxFreq);
        }

        return tasks.length+Math.max(0,idleSlots);
    }
}
