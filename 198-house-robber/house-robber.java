class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return getrobbedhouse(0,nums,dp);
    }
    public static int getrobbedhouse(int i , int [] n,int dp[]){
        if(i>=n.length) return 0;
        if(dp[i] != -1) return dp[i];
        int v1 = n[i] + getrobbedhouse(i+2,n,dp);
        int v2= 0+getrobbedhouse(i+1,n,dp);
        return dp[i] = Math.max(v1,v2);
    }

}