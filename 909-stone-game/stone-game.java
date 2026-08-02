class Solution {
    public boolean stoneGame(int[] piles) {
        Integer [][] dp = new Integer[piles.length][piles.length];
        return GetWinner(0,piles.length-1,piles,dp) > 0;
    }
    public static int GetWinner(int i , int j , int[]p,Integer dp[][]){
        if(i==j)return p[i];

        if(dp[i][j] != null) return dp[i][j];


        int left = p[i] - GetWinner(i+1,j,p,dp);
        int right = p[j] - GetWinner(i,j-1,p,dp);

        return dp[i][j] = Math.max(left,right);
    }
}