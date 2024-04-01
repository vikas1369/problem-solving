package com.vikas.core.leetcode.stack;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet {
    public static void main(String[] args){

    }

    public int carFleet(int target, int[] position, int[] speed) {
        double [][] carTime = new double[position.length][2];
        for(int i =0;i< position.length;i++){
            carTime[i] = new double[]{position[i], (target - position[i])/speed[i]};
        }

        Arrays.sort(carTime, Comparator.comparingDouble(a -> a[0]));
        int fleet = 0;
        double curr = 0;
        for(int i = position.length-1;i>=0;i--){
            if(carTime[i][1]>curr){
                curr = carTime[i][1];
                fleet++;
            }
        }
        return fleet;
    }
}
