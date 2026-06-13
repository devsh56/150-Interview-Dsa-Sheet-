class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ll = new StringBuilder();
        for(int i =0 ;i<words.length;i++){
            String a = words[i];
                int sum = 0;
            for(int j = 0 ;j<a.length();j++){
                sum += weights[a.charAt(j) - 'a'];
            }
            sum = sum % 26;
            ll.append((char)('z' - sum));
        }
        return ll.toString();
    }
}