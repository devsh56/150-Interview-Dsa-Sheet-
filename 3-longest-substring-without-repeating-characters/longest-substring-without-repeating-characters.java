class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int start = 0;
        int end = 0;
        int ans  = 0;
        while(end < s.length()){
            char ch = s.charAt(end);
            while(!seen.isEmpty() && start <= end && seen.contains(ch)){
                seen.remove(s.charAt(start));
                start++;
            }
           
             seen.add(ch);
              ans = Math.max(ans, seen.size());
            end++;
        }
        return ans;
    }
}