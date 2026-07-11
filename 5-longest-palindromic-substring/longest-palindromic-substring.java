class Solution {
    public String longestPalindrome(String s) {
        boolean dp[][]=new boolean[s.length()][s.length()];
        int index=0;
        int maxlen=1;
        for(int i =0 ;i<s.length();i++){
            dp[i][i] = true;
        }

        for(int L=2 ;L<=s.length();L++){
            for(int i =0 ;i<s.length();i++){
                int j = i+L-1;
                if(j <= s.length()-1 && s.charAt(i) == s.charAt(j) && L == 2) {
                    dp[i][j] = true;
                    if(maxlen < L){
                        index = i;
                        maxlen = L;
                    }
                }
                else if(j <= s.length()-1 && s.charAt(i)  == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if(maxlen < L){
                        index = i;
                        maxlen = L;
                    }
                }
            }
        }
        return s.substring(index,index+maxlen);
    }
}