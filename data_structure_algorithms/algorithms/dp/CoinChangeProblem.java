package com.vikas.core.leetcode.dp;

import java.util.Arrays;

public class CoinChangeProblem {
    public static void main(String[] args){

    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1;i<=dp.length;i++){
            for(int coin: coins){
                if(i-coin>=0)
                dp[i] = Math.min(dp[i], 1+dp[i-coin]);
            }
        }
        return dp[amount+1]!=amount+1 ? dp[amount]: -1;
    }
}
