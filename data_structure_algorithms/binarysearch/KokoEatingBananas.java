package com.vikas.core.leetcode.binarysearch;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KokoEatingBananas {
    public static void main(String[] args){
    KokoEatingBananas k = new KokoEatingBananas();
    System.out.println(k.minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
    //System.out.println(k.minEatingSpeed(new int[]{9,9,9}, 10));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile:piles){
            max = Math.max(pile, max);
        }
        //int[] range = IntStream.range(1, max+1).toArray();
        int low = 1;
        int high = max;
        while(low<=high){
            int mid = (low+high)/2;
            if(canEatBanas(piles, h, mid)){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    boolean canEatBanas(int[] piles, int h, int k){
        long totalTimeTaken = 0;
        for(int pile:piles){
            totalTimeTaken+=(pile/k)+Math.min(1, pile%k);
        }
        return totalTimeTaken<=h;
    }
}
