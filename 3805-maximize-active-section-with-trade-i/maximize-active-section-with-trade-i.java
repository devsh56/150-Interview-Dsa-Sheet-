class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        // Count original number of ones
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        // Group lengths
        List<Integer> len = new ArrayList<>();
        List<Character> type = new ArrayList<>();

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            type.add(s.charAt(i));
            len.add(j - i);
            i = j;
        }

        int ans = ones;

        // Try every middle block of 1's
        for (int k = 1; k + 1 < len.size(); k++) {
            if (type.get(k) == '1') {
                int gain = len.get(k - 1) + len.get(k + 1);
                ans = Math.max(ans, ones + gain);
            }
        }

        return ans;
    }
}