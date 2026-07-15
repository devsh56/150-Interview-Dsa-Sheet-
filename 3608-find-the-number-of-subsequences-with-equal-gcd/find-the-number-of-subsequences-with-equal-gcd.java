class Solution {

    static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {

        int n = nums.length;

        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        int[][][] dp = new int[n + 1][max + 1][max + 1];

        // Base case
        for (int g1 = 0; g1 <= max; g1++) {
            for (int g2 = 0; g2 <= max; g2++) {
                dp[n][g1][g2] = (g1 == g2) ? 1 : 0;
            }
        }

        // Fill from back
        for (int i = n - 1; i >= 0; i--) {

            for (int g1 = 0; g1 <= max; g1++) {

                for (int g2 = 0; g2 <= max; g2++) {

                    long ans = dp[i + 1][g1][g2];

                    ans += dp[i + 1][gcd(g1, nums[i])][g2];
                    ans %= MOD;

                    ans += dp[i + 1][g1][gcd(g2, nums[i])];
                    ans %= MOD;

                    dp[i][g1][g2] = (int) ans;
                }
            }
        }

        return (dp[0][0][0] - 1 + MOD) % MOD;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}