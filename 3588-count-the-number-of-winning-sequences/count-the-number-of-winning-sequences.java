class Solution {
    static final int MOD = 1_000_000_007;

    public int countWinningSequences(String s) {
        int n = s.length();
        Integer[][][] dp = new Integer[n][4][2 * n + 1];
        return dfs(0, 3, 0, s, dp);
    }

    private int dfs(int idx, int last, int diff, String s, Integer[][][] dp) {
        int n = s.length();

        if (idx == n) {
            return diff > 0 ? 1 : 0;
        }

        if (dp[idx][last][diff + n] != null)
            return dp[idx][last][diff + n];

        long ans = 0;

        for (int move = 0; move < 3; move++) {
            if (move == last)
                continue;

            int newDiff = diff + score(move, s.charAt(idx));

            ans += dfs(idx + 1, move, newDiff, s, dp);
            ans %= MOD;
        }

        return dp[idx][last][diff + n] = (int) ans;
    }

    private int score(int bob, char alice) {

        if (bob == 0) { // Fire
            if (alice == 'E') return 1;
            if (alice == 'W') return -1;
        }

        if (bob == 1) { // Water
            if (alice == 'F') return 1;
            if (alice == 'E') return -1;
        }

        if (bob == 2) { // Earth
            if (alice == 'W') return 1;
            if (alice == 'F') return -1;
        }

        return 0;
    }
}
