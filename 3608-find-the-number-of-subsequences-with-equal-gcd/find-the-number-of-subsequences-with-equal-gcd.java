class Solution {
    public static int mod = 1000000007 ;
    public int subsequencePairCount(int[] nums) {
        int max = 0;
        for(int a : nums)max = Math.max(a,max); 
        System.out.println(max);
        int dp [][][] = new int[nums.length+1][max+1][max+1];
        for(int i =0 ;i<nums.length;i++){
            for(int j=0;j<max+1;j++){
                for(int k=0;k<max+1;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return getPairGcdCount(0,0,nums,0,dp) - 1;
    }
    public static int getPairGcdCount(int seq1,int seq2,int []n , int i,int dp[][][]){
        if(i == n.length){
            if(seq1 == seq2) return 1;
            else return 0;
        }

        if(dp[i][seq1][seq2] != -1) return dp[i][seq1][seq2];

        long a = getPairGcdCount(seq1,seq2,n,i+1,dp) % mod;
        long b = getPairGcdCount(gcd(seq1,n[i]),seq2,n,i+1,dp) % mod;
        long c = getPairGcdCount(seq1,gcd(seq2,n[i]),n,i+1,dp) % mod;

        return dp[i][seq1][seq2] = (int)((a+b) % mod +c) % mod;
    }
  public static int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
}