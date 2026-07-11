class Solution {
    public String longestPalindrome(String s) {
        Boolean dp[][]=new Boolean[s.length()][s.length()];
       /* for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }*/
        int maxlen = 1;
        int index = 0;
        for(int i =0 ;i<s.length();i++){
            for(int j = i+1;j<s.length();j++){
                if(Palindrome(i,j,s,dp)){
                   if (j - i + 1 > maxlen) {
        maxlen = j - i + 1;
        index = i;
    }
                }
            }
        }
        return s.substring(index,index+maxlen);
    }
    public static boolean Palindrome(int i,int j , String s,Boolean dp[][]){
            if(i>=j) return true;

            if(dp[i][j] != null) return dp[i][j];
            boolean flag = false;
            if(s.charAt(i) == s.charAt(j)){
                flag = flag || Palindrome(i+1,j-1,s,dp);
            }
            return dp[i][j] = flag;
    }
}