package com.vikas.core.leetcode.mathsAndGeom;

public class Power {
    public static void main(String[] args){
        Power p = new Power();
        System.out.println(p.myPow(2.0,-2147483648));
    }

    public double myPow(double x, int n) {
        if(x==1){
            return 1;
        }
        long val = n;
        long absN =Math.abs(val);
        double acc=1;
        for(long i =0;i<absN;i++) {
            acc = acc * x;
        }
        if(n<0)
            return 1.0d/acc;
        return acc;
    }
}
