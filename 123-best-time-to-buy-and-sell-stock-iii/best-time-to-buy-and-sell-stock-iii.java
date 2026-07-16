class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][3][2];
        for(int i =0 ;i<prices.length;i++){
            for(int j =0 ;j<3;j++){
                for(int k =0;k<2;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return getProfitByTransaction(0,2,0,prices,dp);
    }
    public static int getProfitByTransaction(int i , int k , int buy ,int p[],int[][][] dp){
        if(i >= p.length) return 0;
        if( k <= 0) return 0;
        if(dp[i][k][buy] != -1) return dp[i][k][buy];
        int profit = 0;
        if(buy == 0){
            int a = -p[i] + getProfitByTransaction(i+1,k,1,p,dp);
            int b = 0+getProfitByTransaction(i+1,k,0,p,dp);
            profit += Math.max(a,b);
        }else{
            int c = p[i] + getProfitByTransaction(i+1,k-1,0,p,dp);
            int d = 0+getProfitByTransaction(i+1,k,1,p,dp);
            profit+=Math.max(c,d);
        }
        return dp[i][k][buy] = profit;
    }
}