class Solution {
    public String smallestPalindrome(String s) {
       char ch [] = s.toCharArray();
       int [] fre = new int[26];
       for(int i =0 ;i<s.length();i++){
        fre[s.charAt(i) - 'a']++;
       } 
       StringBuilder ss = new StringBuilder();
        String d = "";
       for(int i = 0 ;i<26;i++){
        if(fre[i] % 2 !=0){
            fre[i]--;
            d+= (char)('a'+i);
        }
         int a = fre[i]/2;
        for(int j = 0 ;j<a;j++){
            ss.append((char)('a'+i));
         }
       }

       String rev = ss.reverse().toString();
    //    System.out.println(rev.toString());
    //      System.out.println(ss.toString());
    //        System.out.println(d);

       return ss.reverse().toString()+d+rev.toString();
    }
}