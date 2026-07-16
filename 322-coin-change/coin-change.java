class Solution {
    public int coinChange(int[] coins, int amount) {
        long dp[][] = new long[coins.length][amount+1];
        for(long arr[] : dp){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        for(int i =0 ;i<coins.length;i++){
            dp[i][0] = 0;
        }
        for(int i = coins.length-1;i>=0;i--){
            for(int j = 1 ;j<=amount ;j++){
                if(j-coins[i] >= 0){
             dp[i][j] = 1+dp[i][j-coins[i]];
        }
        if(i != coins.length-1)
        dp[i][j] = Math.min(dp[i][j],dp[i+1][j]);
            }
        }
    return dp[0][amount] >= Integer.MAX_VALUE
       ? -1
       : (int)dp[0][amount];
    }
}