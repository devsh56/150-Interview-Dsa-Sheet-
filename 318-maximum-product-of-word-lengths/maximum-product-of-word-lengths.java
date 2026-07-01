class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int [] mask = new int[n];
        int ans = 0 ;
        for(int i =0 ;i<n;i++){
            char[]ch = words[i].toCharArray();
            for(char a : ch){
                mask[i] |= (1<<(a-'a')); 
            }
        }
        for(int i =0 ; i < words.length ; i++){
            for(int j = i+1 ;j<words.length;j++){
                if((mask[i] & mask[j]) == 0){
                    ans = Math.max(ans,(words[i].length() * words[j].length()));
                }
            }
        }
        return ans;
    }
}