class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String>map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6', "mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String>result = new ArrayList<>();
        getlettercombinations(0,digits,map,"",result);
        return result;
    }
    public static void getlettercombinations(int i, String d,HashMap<Character,String>map,String ans,List<String>result){
        if(i == d.length()){
            result.add(ans);
            return;
        }
        String v = map.get(d.charAt(i));
        for(int j=0;j<v.length();j++){
            getlettercombinations(i+1,d,map,ans+v.charAt(j),result);
        }
        return;
    }
}