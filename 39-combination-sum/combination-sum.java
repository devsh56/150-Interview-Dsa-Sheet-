class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer>ans = new ArrayList<>();
        generateCombination(0,0,candidates,target,ans,result);
        return result;
    }
    public static void generateCombination(int i,int sum,int [] c, int target,List<Integer>ans, List<List<Integer>> result ){
        if(sum  == target){
            result.add(new ArrayList<>(ans));
            return;
        }
        if(target < sum || i >= c.length) return;
        ans.add(c[i]);
        if(target-sum >= 0){
            generateCombination(i,sum+c[i],c,target,ans,result);
            ans.remove(ans.size()-1);
        } 
        generateCombination(i+1,sum,c,target,ans,result);
    } 
}