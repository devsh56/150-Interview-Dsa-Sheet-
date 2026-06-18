class Solution {
    public List<List<Integer>> permute(int[] nums) {
       boolean [] check = new boolean [nums.length];
       List<Integer> ans = new ArrayList<>();
       List<List<Integer>> result = new ArrayList<>();
       getpermute(check,nums,ans,result); 
       return result;
    }
    public static void getpermute(boolean c[], int [] n, List<Integer>ans,List<List<Integer>> result){
        if(ans.size() == n.length){
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int i =0 ;i<n.length;i++){
            if(c[i] != true){
                ans.add(n[i]);
                c[i]= true;
                getpermute(c,n,ans,result);
                ans.remove(ans.size()-1);
                c[i]= false;
            }
        }
        return;
    }
}