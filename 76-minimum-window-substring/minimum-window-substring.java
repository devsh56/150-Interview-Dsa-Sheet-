class Solution {
    public String minWindow(String s, String t) {
        int start =0;
        int end =0;
        int [] freq1=new int[123];
        int [] freq2=new int[123];
        int count = 0;
        int ans =Integer.MAX_VALUE;
        int ans_s =-1;
        for(int i =0;i<t.length();i++){
            char ch = t.charAt(i);
            freq1[ch]++;
        }
        while(end < s.length()){
            char ch = s.charAt(end);
            freq2[ch]++;
            if(freq2[ch] <= freq1[ch])count++;
            if(count >= t.length()){
                while(start <= end && freq2[s.charAt(start)] > freq1[s.charAt(start)] ){
                    freq2[s.charAt(start)]--;
                    start++;
                }
                if(ans > end-start+1){
                    ans_s = start;
                    ans = end-start+1; 
                }
            }
            end++;
        }
        if(ans_s == -1) return "";
        return s.substring(ans_s, ans_s+ans);
    }
}