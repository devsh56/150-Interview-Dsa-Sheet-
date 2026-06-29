class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][]= new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        return UniquePath(0,0,obstacleGrid,dp);
    }
    public static int UniquePath(int i,int j,int obstacleGrid[][],int dp[][]){
        if(i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1){
            if(obstacleGrid[i][j] == 1) return 0;
            else return 1;
        }
        if(i<0 || j<0 || i >=obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int a = UniquePath(i+1,j,obstacleGrid,dp);
        int b = UniquePath(i,j+1,obstacleGrid,dp);
        return dp[i][j] = a+b;        
    }
}