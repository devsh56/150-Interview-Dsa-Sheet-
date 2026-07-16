class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
         long a = numberOfCoins(0,coins,amount,dp);
         return (a >= Integer.MAX_VALUE ? -1 : (int )a);
    }
    public static long numberOfCoins(int i , int c[],int amount,int dp[][]){
         if(amount == 0) return 0;
        if(i>=c.length) return Integer.MAX_VALUE;
        if(dp[i][amount] != -1) return dp[i][amount];
        long a = Integer.MAX_VALUE;
        long b = Integer.MAX_VALUE;
        if(amount-c[i] >= 0){
             a = 1+numberOfCoins(i,c,amount-c[i],dp);
        }
        b = numberOfCoins(i+1,c,amount,dp);

        return dp[i][amount] = (int)Math.min(a,b);
    }
}