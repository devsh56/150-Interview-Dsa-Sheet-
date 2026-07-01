class Solution {
    public int maxProduct(String[] words) {
        int ans = 0 ;
        int count[]=new int[26];
        for(int i = 0 ;i<words.length;i++){
            count = getCharacterLength(words[i]);
            for(int j = i+1 ;j<words.length;j++){
                if(getWordLength(count,words[j]))
                ans = Math.max((words[i].length() * words[j].length()),ans);
            }
        }
        return ans;
    }
    public static boolean getWordLength(int[]c,String b){
        for(int i = 0 ; i<b.length();i++){
            char ch = b.charAt(i);
            if(c[ch-'a'] > 0) return false;
        }
        return true;
    }
     public static int[] getCharacterLength(String a){
        int [] count = new int[26];
        for(int i =0 ;i<a.length();i++){
            count[a.charAt(i) - 'a']++;
        }
        return count;
    }
}