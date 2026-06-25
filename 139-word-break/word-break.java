class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> seen = new HashSet(wordDict);
        Boolean dp[] = new Boolean[s.length()+1];
       return matchOrNot(s,0,seen,dp);  
    }
    public static boolean matchOrNot(String a, int index,HashSet<String> seen, Boolean dp[]){
        if(index >= a.length()) return true;
        if(dp[index] != null) return dp[index];
        boolean flag = false;
        for(int i = index+1 ;i<=a.length();i++){
            if(seen.contains(a.substring(index,i))){
                if(matchOrNot(a,i,seen,dp)) return dp[index] = true;
            }
        }
        return dp[index] = false;
    }
}