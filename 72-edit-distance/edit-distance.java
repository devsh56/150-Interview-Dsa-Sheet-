class Solution {
    public int minDistance(String word1, String word2) {
       
        if(word1.length()== 0) return word2.length();
        if(word2.length()== 0) return word1.length();
        int dp [][] = new int [word1.length()][word2.length()];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
         return getMinDistance(0,0,word1,word2,dp);
    }
    public static int getMinDistance(int i , int j , String word1,String word2,int [][]dp){
        if(j == word2.length()){
            return word1.length()-i;
        }
        if(i == word1.length()){
            return word2.length() - j;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int count = 0;
        if(word1.charAt(i) != word2.charAt(j)){
        count = 1 + Math.min(Math.min(getMinDistance(i+1,j+1,word1,word2,dp),getMinDistance(i+1,j,word1,word2,dp)),getMinDistance(i,j+1,word1,word2,dp));
        }
        else{
          count = 0 + getMinDistance(i+1,j+1,word1,word2,dp);
        }
        return dp[i][j] = count;
    }
}