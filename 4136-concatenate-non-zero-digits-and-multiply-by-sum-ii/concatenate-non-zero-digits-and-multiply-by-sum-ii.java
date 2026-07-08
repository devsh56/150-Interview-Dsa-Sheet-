class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] pref = new long[n + 1];     // value of concatenated non-zero digits
        int[] cnt = new int[n + 1];        // count of non-zero digits
        int[] digitSum = new int[n + 1];   // sum of non-zero digits
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            cnt[i + 1] = cnt[i];
            digitSum[i + 1] = digitSum[i];
            pref[i + 1] = pref[i];

            if (d != 0) {
                cnt[i + 1]++;
                digitSum[i + 1] += d;
                pref[i + 1] = (pref[i] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int k = cnt[r + 1] - cnt[l];
            long sum = digitSum[r + 1] - digitSum[l];

            long x = (pref[r + 1] - (pref[l] * pow10[k]) % MOD + MOD) % MOD;

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}