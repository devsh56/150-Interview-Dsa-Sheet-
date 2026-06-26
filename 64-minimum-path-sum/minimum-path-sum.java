class Solution {
    public int minPathSum(int[][] grid) {
        int dp [][] = new int[grid.length][grid[0].length];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        return getMinSum(0,0,grid,dp);
    }
    public static int getMinSum(int row,int col, int [][] g,int [][]dp){
        if(row>=g.length || col >= g[0].length) return Integer.MAX_VALUE;
        if(row == g.length-1 && col ==g[0].length-1) return g[row][col];
        if(dp[row][col] !=-1)return dp[row][col];
        int sum = 0 ;
        sum+=g[row][col];
        return dp[row][col] = sum+Math.min(getMinSum(row+1,col,g,dp),getMinSum(row,col+1,g,dp));

    }
}