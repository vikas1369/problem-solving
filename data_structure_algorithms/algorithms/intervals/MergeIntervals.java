package com.vikas.core.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args){

    }

    public int[][] merge(int[][] intervals) {
        List<int []> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(num -> num[0]));
        for(int[] interval: intervals){
            if(list.isEmpty() || interval[0] > list.get(list.size()-1)[1]){
                list.add(interval);
            }
            else{
                list.get(list.size()-1)[1] = Math.max(interval[1],list.get(list.size()-1)[1]);
            }
        }
        return list.toArray(new int[0][]);
    }
}
