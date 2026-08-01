class Solution {
    public boolean predictTheWinner(int[] nums) {
        Integer dp[][] = new Integer[nums.length][nums.length];
        return getthewinner(0,nums.length-1,nums,dp) >= 0;
    }
    public static int getthewinner(int left, int right,int n[],Integer[][]dp){
        if(left == right) return n[left];
        if(dp[left][right]!= null) return dp[left][right];
        int leftsidesum = n[left] - getthewinner(left+1,right,n,dp);
        int rightsidesum = n[right] - getthewinner(left,right-1,n,dp);

        return dp[left][right] = Math.max(leftsidesum,rightsidesum);
    }
}