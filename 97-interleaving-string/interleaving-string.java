class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.isEmpty()) return true;
        Boolean dp[][][] = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return GetConcateString(0,0,0,s1,s2,s3,dp);
    }
    public static boolean GetConcateString(int i ,int j , int k , String s1,String s2, String s3,Boolean dp[][][]){
        if(k == s3.length() && i== s1.length() && j == s2.length()) return true;
        if(k == s3.length() && (i!= s1.length() || j != s2.length())) return false;
        if(i>=s1.length() && j >= s2.length() ) return false;
        if(i<s1.length() && j<s2.length() && s1.charAt(i) != s3.charAt(k) && s2.charAt(j) != s3.charAt(k)) return false;
        if(dp[i][j][k] != null) return dp[i][j][k];
        boolean flag = false;
        if(i<s1.length() && j<s2.length() && s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)){
             flag = flag || (GetConcateString(i+1,j,k+1,s1,s2,s3,dp) || GetConcateString(i,j+1,k+1,s1,s2,s3,dp));
        }else if(i<s1.length() && s1.charAt(i) == s3.charAt(k)){
            flag = flag || GetConcateString(i+1,j,k+1,s1,s2,s3,dp);
        }else if(j<s2.length() && s2.charAt(j) == s3.charAt(k)){
            flag = flag || GetConcateString(i,j+1,k+1,s1,s2,s3,dp);
        }
        return dp[i][j][k] = flag;
    }
}