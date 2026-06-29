class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][]dp=new int[nums.length][nums.length+1];
        for(int arr[]:dp){
          Arrays.fill(arr,-1);
        }
       
        return GetLcsCount(0,-1,nums.length,nums,dp);
    }
    public static int GetLcsCount(int i,int prev_index, int n,int nums[],int[][]dp){
        if(i >= n) return 0;
        if(dp[i][prev_index+1] != -1) return dp[i][prev_index+1];
        int count = 0;
        if(prev_index == -1 || nums[prev_index] < nums[i]){
           // System.out.println(v); 
            count = 1 + GetLcsCount(i+1,i,n,nums,dp);
        }
        count = Math.max(count,GetLcsCount(i+1,prev_index,n,nums,dp));
        return dp[i][prev_index+1] = count;
    } 
}