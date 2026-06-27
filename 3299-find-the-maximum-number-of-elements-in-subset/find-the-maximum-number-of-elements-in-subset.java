class Solution {
    public int maximumLength(int[] nums) {
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i =0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
       } 
       int ans = map.getOrDefault(1,0);
       if (ans % 2 == 0)ans=ans-1;

       for(int i =0 ;i<nums.length;i++){
        int curr = nums[i];
        int c = 0;
        while(curr <= Integer.MAX_VALUE && map.containsKey(curr)&&map.get(curr) >= 2 && curr != 1){
            curr*=curr;
            c++;
        }
        if(map.containsKey(curr)) c++;
        ans = Math.max(ans,2*c-1);
       }
       return ans;
    }
}