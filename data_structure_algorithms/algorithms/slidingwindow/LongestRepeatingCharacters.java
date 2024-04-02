package com.vikas.core.leetcode.slidingwindow;

public class LongestRepeatingCharacters {
    public static void main(String[] args){

    }
    public int characterReplacement(String s, int k) {
        int beg= 0;
        int end = s.length()-1;
        int[] freq= new int[s.length()];
        int maxOccurance = 0;
        int maxLen = 0;
        for(int i =0;i<s.length();i++){
            freq[s.charAt(i)-65]++;
            int currentOccurance = freq[s.charAt(i)-65];
            maxOccurance = Math.max(maxOccurance, currentOccurance);
            if(end-beg+1 > maxOccurance + k){
                beg++;
                freq[s.charAt(beg)-65]--;
            }
            maxLen = Math.max(maxLen, end- beg+1);
        }
        return maxLen;
    }
}
