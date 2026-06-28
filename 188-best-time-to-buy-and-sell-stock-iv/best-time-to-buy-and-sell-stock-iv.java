class Solution {
    public int maxProfit(int k, int[] prices) {

        int dp[][][]=new int[prices.length][k][2];
        for(int i =0 ;i<prices.length;i++){
            for(int j=0;j<k;j++){
                for(int m =0 ;m<2;m++){
                    dp[i][j][m] = -1;
                }
            }
        }
        return BuyOrSellStocks(prices,k,0,0,dp);
    }
    public static int BuyOrSellStocks(int[]p,int k ,int i,int buy,int[][][]dp){
        if(i >= p.length) return 0;
        if(k == 0) return 0;
        if(dp[i][k-1][buy] !=-1) return dp[i][k-1][buy];
        if(buy == 0){
          return dp[i][k-1][buy] = Math.max(-p[i] + BuyOrSellStocks(p,k,i+1,1,dp),
          BuyOrSellStocks(p,k,i+1,0,dp)) ;
        }else{
           return dp[i][k-1][buy] = Math.max(p[i] + BuyOrSellStocks(p,k-1,i+1,0,dp),BuyOrSellStocks(p,k,i+1,1,dp));
        }
    }
}