class Solution {
    public String removeDuplicateLetters(String s) {
        int [] freq = new int[26];
        for(int i =0 ;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        Stack<Character> st = new Stack<>();
        boolean [] visited = new boolean[26];

        for(int i =0 ;i<s.length();i++){
            char ch = s.charAt(i);
            while(!st.isEmpty() && st.peek() > ch && freq[st.peek() - 'a'] > 1 && visited[ch-'a'] == false){
                char a = st.pop();
                freq[a-'a']--;
                visited[a-'a'] = false;
            }

            if(!visited[ch - 'a']){
               st.push(ch);
               visited[ch-'a']=true; 
            }else{
            freq[ch-'a']--;
            }
        }
        StringBuilder ss = new StringBuilder();
        while(!st.isEmpty()){
            ss.append(st.pop());
            }
            return ss.reverse().toString();
    }
}