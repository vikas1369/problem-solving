package com.vikas.core.leetcode.arrays;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {
    HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args){

    }

    public int[] topKFrequent(int[] nums, int k) {
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) ->map.get(b) -map.get(a));
        heap.addAll(map.keySet());
        int[] res = new int[k];
        for(int i =0;i<k;i++){
            res[i]= heap.poll();
        }
        return res;
    }

}
