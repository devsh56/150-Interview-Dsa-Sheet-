class Solution {
    public String stoneGameIII(int[] stoneValue) {
        Integer [] dp = new Integer[stoneValue.length];
      int v =  getthewinner(0,stoneValue.length-1,stoneValue,dp);
      if(v < 0) return "Bob";
      else if (v > 0) return "Alice";
      return "Tie";
    }
    public static int getthewinner(int i , int j , int [] stone,Integer[] dp){
        if(i>j) return 0;
        if(i==j){
            return stone[i];
        }
        if(dp[i] !=  null) return dp[i];
        int second_leftsum = 0;
         int third_leftsum = 0;
          int first_leftsum = stone[i] - getthewinner(i+1,j,stone,dp);
        if(i+1 <= j)
         second_leftsum = stone[i] + stone[i+1] - getthewinner(i+2,j,stone,dp);
        if(i+2 <= j)
         third_leftsum = stone[i] + stone[i+1] + stone[i+2] - getthewinner(i+3,j,stone,dp);

         return dp[i] = Math.max(first_leftsum,Math.max(second_leftsum,third_leftsum));
    }
}