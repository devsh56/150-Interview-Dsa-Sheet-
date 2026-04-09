class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefixProd[] = new int[nums.length];
        int suffixProd[] = new int[nums.length];
        suffixProd[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2 ; i>=0 ;i--){
            suffixProd[i] = suffixProd[i+1] * nums[i];
        }
        prefixProd[0] = nums[0];
        for(int i =1 ;i<nums.length;i++){
                prefixProd[i] = prefixProd[i-1] * nums[i];
        }
        int ans[]=new int[nums.length];
        ans[0] = suffixProd[1];
        ans[nums.length-1] = prefixProd[nums.length-2];
        for(int i=1 ;i<nums.length-1;i++){
            ans[i] = prefixProd[i-1] * suffixProd[i+1];
        }
        return ans;
    }
}