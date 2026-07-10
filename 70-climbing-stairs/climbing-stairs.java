class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
       return climbstairs(n,dp); 
    }
    public static int climbstairs(int n,int dp[]){
        if(n == 0) return 1;
        if(n<0) return 0;
        if(dp[n] != -1) return dp[n];
        int a = 0;
        int b = 0;
        if(n>=1)a=climbstairs(n-1,dp);
        if(n>=2)b=climbstairs(n-2,dp);
        return dp[n] = a+b;
    }
}