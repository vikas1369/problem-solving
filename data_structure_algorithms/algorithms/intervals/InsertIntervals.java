package com.vikas.core.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InsertIntervals {
    public static void main(String[] args){

    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> list = new ArrayList<>();
        int i =0;
        while(i<intervals.length && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        while(i<intervals.length && intervals[i][0] < newInterval[1]){
            //merge intervals
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);

        while(i<intervals.length){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[0][]);
    }
}
