package com.vikas.core.leetcode.bitmanipulation;

public class ReverseNumber {
    public static void main(String[] args){
        ReverseNumber reverseNumber = new ReverseNumber();
        System.out.println(reverseNumber.reverse(123));
    }

    public int reverse(int x) {
        long finalNumber = 0;
        while(x!=0){
            int lastDigit = (x % 10);
            finalNumber = finalNumber * 10 + lastDigit;
            x /= 10;
        }

        if(finalNumber < Integer.MIN_VALUE || finalNumber > Integer.MAX_VALUE){
            return 0;
        }

        if(x < 0){
            return (int) ((-1) * finalNumber);
        }

        return (int) finalNumber;
    }
}
