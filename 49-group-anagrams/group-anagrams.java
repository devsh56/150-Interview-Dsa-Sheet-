class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String a = check(strs[i]);
            if(map.containsKey(a)){
                map.get(a).add(strs[i]);
            }else{
                map.put(a,new ArrayList<String>());
                map.get(a).add(strs[i]);
            }
        }
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
    public static String check(String a){
        char characterArray[] = a.toCharArray();
        int [] bitArray= new int[26];
        for(char ch : characterArray){
            bitArray[ch-97]++;
        }
        StringBuilder ss =new StringBuilder();
        for(int d : bitArray){
            ss.append(d +",");
        }
        return ss.toString();
    }
}