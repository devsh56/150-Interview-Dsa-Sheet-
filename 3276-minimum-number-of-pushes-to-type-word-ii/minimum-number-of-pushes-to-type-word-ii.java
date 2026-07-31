class Solution {
    public int minimumPushes(String word) {
        int [] countarr = new int[26];
        for(int i =0 ;i<word.length();i++){
            countarr[word.charAt(i) - 'a']++;
        }
        Arrays.sort(countarr);
        int count = 1;
        int ans = 0;
        for(int i =countarr.length-1;i>=0;i--){
            if(countarr[i] > 0){
            if(count > 8 && count <= 16){
                ans+= 2 * countarr[i];
            }else if(count > 16 && count <= 24){
                ans+= 3 * countarr[i];
            }else if (count > 24){
                ans += 4 * countarr[i];
            }else{
                ans += countarr[i];
            }
            count++;
            }

        }
        return ans;
    }
}