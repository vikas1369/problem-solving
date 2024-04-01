package com.vikas.core.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthLargestElement {
    public static void main(String[] args){

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        pq.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int i =1;
        while(i<k){
            pq.poll();
            i++;
        }
        return pq.poll();
    }
}
